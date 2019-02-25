package ru.bjcreslin.controller;

import ru.bjcreslin.model.ItemModel;

import java.io.IOException;
import java.util.List;

public interface AppController {
    List<ItemModel> getList() throws IOException;
}
