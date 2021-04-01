package edu.hebeu.service;

import edu.hebeu.domain.Product;

import java.util.List;

/**
 * 商品业务层接口
 */
public interface IProductService {

    /**
     * 添加一个Product
     * @param product
     */
    void saveS(Product product) throws Exception;

    /**
     * 获取全部商品
     * @return
     */
    List<Product> findAllS() throws Exception;
}
