package ru.bjcreslin.controller;

import ru.bjcreslin.entity.ItemEntity;

import java.io.IOException;
import java.util.List;

public interface AppController {
    List<ItemEntity> getList() throws IOException;
}
