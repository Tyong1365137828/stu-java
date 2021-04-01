package edu.hebeu.dao;

import edu.hebeu.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("travellerDao")
public interface ITravellerDao {

    /**
     * 通过orderId查询对应的travellerId，并通过travellerId查询出Traveller信息
     * @param ordersId
     * @return
     */
    @Select("SELECT * FROM traveller WHERE id IN(SELECT travellerId FROM order_traveller WHERE orderId = #{ty})")
    List<Traveller> selectByOrdersId(String ordersId);
}
