package ru.bjcreslin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bjcreslin.entity.ItemEntity;
import ru.bjcreslin.repository.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<ItemEntity> findByGroupe(String groupe) {

        return itemRepository.findByGroupe(groupe);
    }

    @Override
    public ItemEntity findByName(String name) {

        return itemRepository.findByName(name);
    }

    @Override
    public ItemEntity findByAdress(String adress) {

        return itemRepository.findByAdress(adress);
    }
}
