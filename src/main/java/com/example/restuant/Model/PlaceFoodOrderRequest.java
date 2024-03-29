package com.example.restuant.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PlaceFoodOrderRequest {
    private List<LineItemRequest> lineItems;
}
