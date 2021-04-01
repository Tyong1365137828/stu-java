package edu.hebeu.controller;

import edu.hebeu.domain.Product;
import edu.hebeu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println("save()方法执行了...");
        System.out.println(product);
        productService.saveS(product);
        return "redirect:/product/findAll.do";
    }

    /**
     * 查询全部Product
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAllS();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
