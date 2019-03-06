package ru.bjcreslin.controller;

import ru.bjcreslin.model.ItemModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AppController {
    List<ItemModel> getList(File file) throws IOException;
}
