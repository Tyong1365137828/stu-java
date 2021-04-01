package edu.hebeu.controller;

import com.github.pagehelper.PageInfo;
import edu.hebeu.domain.Orders;
import edu.hebeu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") Integer pageSize)
            throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAllS(page, pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);

        modelAndView.addObject("ordersPageInfo", pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findSingle.do")
    public ModelAndView findSingle(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findSingleS(ordersId);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }
}
