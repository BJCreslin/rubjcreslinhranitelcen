package ru.bjcreslin.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "itemsfromadress")
public class ItemEntity extends IdEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Column(name = "price")
    private Long price;
    @Column(name = "discountPrice")
    private Long discountPrice;
    @Column(name = "code")
    private Long code;
    @Column(name = "waterPrice")
    private Long waterPrice;
    @Column(name = "waterName")
    private String waterName;
    @Column(name = "groupe")
    private String groupe;
    @Column(name = "date")
    private Date date;

}
