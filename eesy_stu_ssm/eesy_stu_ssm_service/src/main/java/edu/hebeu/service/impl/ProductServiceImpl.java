package edu.hebeu.service.impl;

import edu.hebeu.dao.IProductDao;
import edu.hebeu.domain.Product;
import edu.hebeu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    /**
     * save()方法的重写实现
     * @param product
     */
    @Override
    public void saveS(Product product) throws Exception {
        productDao.insert(product);
    }

    /**
     * findAll()方法的重写实现
     * @return
     */
    @Override
    public List<Product> findAllS() throws Exception {
        return productDao.selectAll();
    }
}
