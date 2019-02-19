package ru.bjcreslin.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity()
@Table(name = "itemsfromadress")
public class ItemEntity extends IdEntity {

    private String name;

    private String adress;

    private Long price;

    private Long discountPrice;

    private Long code;

    private String groupe;

    private Date date;

}
