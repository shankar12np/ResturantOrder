package com.example.restuant.Services;

import com.example.restuant.DTOs.FoodOrderDTO;
import com.example.restuant.DTOs.LineItemDTO;
import com.example.restuant.Model.FoodOrder;
import com.example.restuant.Model.LineItemRequest;
import com.example.restuant.Model.LineItem;
import com.example.restuant.Model.PlaceFoodOrderRequest;
import com.example.restuant.Repository.FoodOrderDTORepository;
import com.example.restuant.Repository.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FoodOrderService {
    @Autowired
    private FoodOrderDTORepository foodOrderDTORepository;

    @Autowired
    LineItemRepository lineItemRepository;

    public FoodOrder placeOrder(PlaceFoodOrderRequest placeFoodOrderRequest) {
        FoodOrder foodOrder = new FoodOrder();

        FoodOrderDTO foodOrderDTO = new FoodOrderDTO();
        foodOrderDTO.setOrderId(UUID.randomUUID().toString());
        foodOrderDTO.setOrderStatus("ACCEPTED");
        foodOrderDTORepository.save(foodOrderDTO);

        foodOrder.setOrderId(foodOrderDTO.getOrderId());
        foodOrder.setOrderStatus(foodOrderDTO.getOrderStatus());
        List<LineItem> lineItems = new ArrayList<>();

        for (LineItemRequest lineItemRequest : placeFoodOrderRequest.getLineItems()) {
            LineItemDTO lineItemDTO = new LineItemDTO();
            lineItemDTO.setItemId(UUID.randomUUID().toString());
            lineItemDTO.setItemTitle(lineItemRequest.getItemTitle());
            lineItemDTO.setPrice(lineItemRequest.getPrice());
            lineItemDTO.setOrderId(foodOrderDTO.getOrderId());

            LineItem lineItem = new LineItem();
            lineItem.setItemId(lineItemDTO.getItemId());
            lineItem.setItemTitle(lineItemDTO.getItemTitle());
            lineItem.setPrice(lineItemDTO.getPrice());
            lineItem.setOrderId(lineItemDTO.getOrderId());
            lineItems.add(lineItem);

            lineItemRepository.save(lineItemDTO);

        }
        foodOrder.setLineItems(lineItems);
        return foodOrder;
    }


}
