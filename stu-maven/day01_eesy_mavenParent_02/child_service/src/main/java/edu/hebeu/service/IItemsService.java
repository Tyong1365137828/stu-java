package edu.hebeu.service;

import edu.hebeu.entity.Items;

import java.util.List;

public interface IItemsService {

    List<Items> findAll();

    Items findSingle(Integer itemId);
}
