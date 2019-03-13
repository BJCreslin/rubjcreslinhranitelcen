package ru.bjcreslin.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "itemsfromadress")
public class ItemEntity /*extends IdEntity */ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;


    @Column(name = "name_stroypark")
    private String name;
    @Column(name = "adress_stroypark")
    private String adress;
    @Column(name = "price_stroypark")
    private BigDecimal price;
    @Column(name = "discountPrice_stroypark")
    private BigDecimal discountPrice;
    @Column(name = "coefficient_stroypark")
    private BigDecimal coeffStroypark;
    @Column(name = "code")
    private Long code;
    @Column(name = "waterPrice")
    private BigDecimal waterPrice;
    @Column(name = "waterName")
    private String waterName;
    @Column(name = "groupe")
    private String groupe;
    @Column(name = "date")
    private Date date;

}
