package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.Items;

public interface ItemsDao {
	
	/**
	 * ��ȡĳЩ����Ʒ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Items> FindMulItems(Items items) throws Exception;
	
	/**
	 * ȫ����Ʒ����Ϣ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Items> FindAllItems() throws Exception;
	
	/**
	 * ��ѯn��m����¼���ֶ���Ϣ
	 */
	public List<Items> findItemsByCount(@Param("start")int start , @Param("end")int end) throws Exception;
	
	/**
	 * ͨ��codeչʾ��Ʒ
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public Items findItemsByCode(Items items) throws Exception;
	
	
}
