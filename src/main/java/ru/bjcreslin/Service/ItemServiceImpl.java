package ru.bjcreslin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bjcreslin.entity.ItemEntity;
import ru.bjcreslin.model.ItemModel;
import ru.bjcreslin.repository.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void saveStroypark(ItemModel itemModel) {
        ItemEntity itemEntityinBase;

        // Если данных с такоим именем нет, то заводим новые и даем им имя
        if ((itemEntityinBase = findByName(itemModel.getName())) == null) {
            itemEntityinBase = new ItemEntity();
            itemEntityinBase.setName(itemModel.getName());
        }
        if (!itemModel.getAdress().isEmpty()) {
            itemEntityinBase.setAdress(itemModel.getAdress());
        }
        if (!itemModel.getGroupe().isEmpty()) {
            itemEntityinBase.setGroupe(itemModel.getGroupe());
        }
        if (!itemModel.getWaterName().isEmpty()) {
            itemEntityinBase.setWaterName(itemModel.getWaterName());
        }
        if (!(itemModel.getCode() == null)) {
            itemEntityinBase.setCode(itemModel.getCode());
        }
        if (!(itemModel.getWaterPrice() == null)) {
            itemEntityinBase.setWaterPrice(itemModel.getWaterPrice());
        }
        if (!(itemModel.getDiscountPrice() == null)) {
            itemEntityinBase.setDiscountPrice(itemModel.getDiscountPrice());
        }
        if (!(itemModel.getPrice() == null)) {
            itemEntityinBase.setPrice(itemModel.getPrice());
        }

itemRepository.save(itemEntityinBase);
    }

    public void saveAllStroyPark(List<ItemModel> itemModelList) {
        if (!itemModelList.isEmpty()) {
            itemModelList.forEach(this::saveStroypark);
        }
        System.out.println(itemModelList.size()+" добавленно в базу");
    }


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
