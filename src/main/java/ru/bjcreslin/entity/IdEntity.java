package ru.bjcreslin.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
