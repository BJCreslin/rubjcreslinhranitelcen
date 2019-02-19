package ru.bjcreslin.view;

import ru.bjcreslin.entity.ItemEntity;

import java.util.List;

public interface AppView {
    void show(List<ItemEntity> itemEntityList);
}
