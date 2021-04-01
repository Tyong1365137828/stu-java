package edu.hebeu.test.service;

import edu.hebeu.entity.Items;
import edu.hebeu.service.IItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ItemsServiceTest {

    @Test
    public void findAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IItemsService iItemsService = applicationContext.getBean("itemsService", IItemsService.class);
        List<Items> items = iItemsService.findAll();
        for (Items item : items) {
            System.out.println(item);
        }
    }
}
