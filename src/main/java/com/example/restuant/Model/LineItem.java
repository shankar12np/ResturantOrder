package com.example.restuant.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
    private String itemId;
    private String itemTitle;
    private Float price;
    private String orderId;
}
