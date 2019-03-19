package ru.bjcreslin.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ItemModel {

    private String name;

    private String adress;

    private BigDecimal coeff;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Long code;

    private BigDecimal waterPrice;

    private String waterName;

    private String groupe;

    private Date date;

    public Long getPriceInRub() {
        try {
            return price.longValue();
        } catch (NullPointerException npe) {
            return 0L;
        }
    }

    public Long getDiscountPriceInRub() {
        try {
            return discountPrice.longValue();
        } catch (NullPointerException npe) {
            return 0L;
        }
    }
}
