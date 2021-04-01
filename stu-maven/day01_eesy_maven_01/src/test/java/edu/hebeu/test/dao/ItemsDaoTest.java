package edu.hebeu.test.dao;

import edu.hebeu.dao.IItemsDao;
import edu.hebeu.entity.Items;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ItemsDaoTest {

    @Test
    public void selectItemsTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IItemsDao itemsDao = applicationContext.getBean(IItemsDao.class);
        List<Items> items = itemsDao.selectItems();
        for (Items item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void selectItemTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IItemsDao itemsDao = applicationContext.getBean(IItemsDao.class);
        Items item = itemsDao.selectItem(2);
        System.out.println(item);
    }
}
