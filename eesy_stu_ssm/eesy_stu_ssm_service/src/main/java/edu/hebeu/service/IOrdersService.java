package edu.hebeu.service;

import edu.hebeu.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 分页获取全部Orders
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAllS(Integer page, Integer pageSize) throws Exception;

    /**
     * 精确查询Orders
     * @param ordersId
     * @return
     */
    Orders findSingleS(String ordersId) throws Exception;

}
