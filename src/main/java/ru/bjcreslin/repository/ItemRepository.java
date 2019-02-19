package ru.bjcreslin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bjcreslin.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity,Long> {


    @Override
    <S extends ItemEntity> S save(S s);

    @Override
    <S extends ItemEntity> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<ItemEntity> findById(Long aLong);

    ItemEntity findByName(String name);

    ItemEntity findByAdress(String adress);

    List<ItemEntity> findByGroupe(String groupe);

    @Override
    List<ItemEntity> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ItemEntity itemEntity);

    @Override
    void deleteAll();
}
