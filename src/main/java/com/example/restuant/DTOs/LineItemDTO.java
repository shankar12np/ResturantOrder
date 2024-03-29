package com.example.restuant.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "line_items")
@Getter
@Setter
public class LineItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemId;
    private String itemTitle;
    private Float price;
    private String orderId;
}
