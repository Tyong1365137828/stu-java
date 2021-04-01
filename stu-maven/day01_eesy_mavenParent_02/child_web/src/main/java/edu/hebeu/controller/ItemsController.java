package edu.hebeu.controller;

import edu.hebeu.entity.Items;
import edu.hebeu.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private IItemsService itemsService;

    @RequestMapping("/findSingleC")
    public String findSingleC(Model model) {
        Items items = itemsService.findSingle(1);
        model.addAttribute("item", items);
        return "success";
    }
}
