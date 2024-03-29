package com.example.restuant.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodOrder {
    private String orderId;
    private String orderStatus;

    private List<LineItem> lineItems;
}
