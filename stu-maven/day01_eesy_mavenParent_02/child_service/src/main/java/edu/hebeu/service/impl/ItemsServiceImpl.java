package edu.hebeu.service.impl;

import edu.hebeu.dao.IItemsDao;
import edu.hebeu.entity.Items;
import edu.hebeu.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemsService")
public class ItemsServiceImpl implements IItemsService {

    @Autowired
    private IItemsDao itemsDao;

    public List<Items> findAll() {
        return itemsDao.selectItems();
    }

    public Items findSingle(Integer itemId) {
        return itemsDao.selectItem(itemId);
    }
}
