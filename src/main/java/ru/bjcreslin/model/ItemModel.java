package ru.bjcreslin.model;

import lombok.Data;

import java.util.Date;

@Data
public class ItemModel {

    private String name;

    private String adress;

    private Long price;

    private Long discountPrice;

    private Long code;

    private Long waterPrice;

    private String waterName;

    private String groupe;

    private Date date;
}
