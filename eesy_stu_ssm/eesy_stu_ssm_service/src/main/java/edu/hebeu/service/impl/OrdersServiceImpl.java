package edu.hebeu.service.impl;

import com.github.pagehelper.PageHelper;
import edu.hebeu.dao.IOrdersDao;
import edu.hebeu.domain.Orders;
import edu.hebeu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAllS(Integer page, Integer pageSize) throws Exception {

        /**
         * 在将要执行查询操作之前使用这行代码实现分页：
         *  参数1、从第几页开始分页
         *  参数2、每页几条记录
         */
        PageHelper.startPage(page, pageSize);
        return ordersDao.selectAll();
    }

    /**
     * findSingle()方法的重写实现
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Override
    public Orders findSingleS(String ordersId) throws Exception {
        return ordersDao.selectById(ordersId);
    }
}
