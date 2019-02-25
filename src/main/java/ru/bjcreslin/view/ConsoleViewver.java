package ru.bjcreslin.view;

import ru.bjcreslin.model.ItemModel;

import java.util.List;

public class ConsoleViewver implements AppView {
    @Override
    public void show(List<ItemModel> itemEntityList) {
        itemEntityList.stream().forEach(System.out::println);
    }


}
