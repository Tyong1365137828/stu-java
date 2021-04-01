package edu.hebeu.dao;

import edu.hebeu.domain.Member;
import edu.hebeu.domain.Orders;
import edu.hebeu.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ordersDao")
public interface IOrdersDao {

    /**
     * 查询全部的订单，包括这些订单对应的产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from orders ORDER BY orderNum")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class, one = @One(select = "edu.hebeu.dao.IProductDao.selectById")),
    })
    List<Orders> selectAll() throws Exception;

    /**
     * 通过订单的id精确查询一条订单信息，包括该订单对应的产品Product、会员Member、游客Traveller
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM orders WHERE id = #{ty}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class, one = @One(select = "edu.hebeu.dao.IProductDao.selectById")),
            @Result(property = "member", column = "memberId",
                    javaType = Member.class, one = @One(select = "edu.hebeu.dao.IMemberDao.selectById")),
            @Result(property = "travellers", column = "id",
                    javaType = List.class, many = @Many(select = "edu.hebeu.dao.ITravellerDao.selectByOrdersId"))
    })
    Orders selectById(String ordersId) throws Exception;
}
