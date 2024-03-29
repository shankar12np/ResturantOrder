package com.example.restuant.Controller;

import com.example.restuant.Model.FoodOrder;
import com.example.restuant.Model.PlaceFoodOrderRequest;
import com.example.restuant.Services.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody PlaceFoodOrderRequest placeFoodOrderRequest){
        FoodOrder foodOrder = foodOrderService.placeOrder(placeFoodOrderRequest);
        return ResponseEntity.accepted().body(foodOrder);
    }
}
