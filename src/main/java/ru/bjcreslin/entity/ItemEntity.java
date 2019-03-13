package ru.bjcreslin.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "itemsfromadress")
public class ItemEntity /*extends IdEntity */{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;


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
