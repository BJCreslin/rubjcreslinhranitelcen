package ru.bjcreslin.view;

import ru.bjcreslin.entity.ItemEntity;

import java.util.List;

public class ConsoleViewver implements AppView {
    @Override
    public void show(List<ItemEntity> itemEntityList) {
        itemEntityList.stream().forEach(System.out::println);
    }
}
