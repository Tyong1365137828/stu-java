package edu.hebeu.service;

import java.util.List;

import edu.hebeu.po.Items;
import edu.hebeu.util.PageBean;

public interface ItemsService {
	
	/**
	 * 用来再前台展示商品的
	 * @return
	 * @throws Exception
	 */
	public List<Items> showProduce() throws Exception;
	
	/**
	 * 
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public List<Items> showProduce(Items items) throws Exception;
	
	/**
	 * 通过code查询Items
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public Items showProduceByCode(Items items) throws Exception;
	
	/**
	 * 全部商品分页显示
	 * @param pageBean
	 * @throws Exception
	 */
	public void showProductAllPage(PageBean<Items> pageBean) throws Exception;

}
