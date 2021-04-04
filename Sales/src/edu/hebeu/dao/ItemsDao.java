package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.Items;

public interface ItemsDao {
	
	/**
	 * 获取某些的商品信息
	 * @return
	 * @throws Exception
	 */
	public List<Items> FindMulItems(Items items) throws Exception;
	
	/**
	 * 全部商品的信息信息
	 * @return
	 * @throws Exception
	 */
	public List<Items> FindAllItems() throws Exception;
	
	/**
	 * 查询n到m条记录的字段信息
	 */
	public List<Items> findItemsByCount(@Param("start")int start , @Param("end")int end) throws Exception;
	
	/**
	 * 通过code展示商品
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public Items findItemsByCode(Items items) throws Exception;
	
	
}
