package edu.hebeu.dao;

import edu.hebeu.entity.Items;

import java.util.List;

public interface IItemsDao {

    List<Items> selectItems();

    Items selectItem(Integer itemId);
}
