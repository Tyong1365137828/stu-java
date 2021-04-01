package edu.hebeu.dao;

import edu.hebeu.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品的DAO层
 */
@Repository("productDao")
public interface IProductDao {

    /**
     * 插入一条Product记录
     * @param product
     */
    @Insert("INSERT INTO product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            " VALUES(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void insert(Product product) throws Exception;


    /**
     * 查询全部
     * @return
     */
    @Select("SELECT * FROM product ORDER BY productName")
    List<Product> selectAll() throws Exception;

    /**
     * 通过id查询一条Product记录
     * @param productId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product selectById(String productId) throws Exception;
}
