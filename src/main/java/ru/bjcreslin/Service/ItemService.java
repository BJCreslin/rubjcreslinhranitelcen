package ru.bjcreslin.Service;

import ru.bjcreslin.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    List <ItemEntity> findAll();
    List<ItemEntity> findByGroupe(String groupe);
    ItemEntity findByName(String name);
    ItemEntity findByAdress(String adress);


}
