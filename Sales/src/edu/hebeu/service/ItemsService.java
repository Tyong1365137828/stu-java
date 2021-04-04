package edu.hebeu.service;

import java.util.List;

import edu.hebeu.po.Items;
import edu.hebeu.util.PageBean;

public interface ItemsService {
	
	/**
	 * ������ǰ̨չʾ��Ʒ��
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
	 * ͨ��code��ѯItems
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public Items showProduceByCode(Items items) throws Exception;
	
	/**
	 * ȫ����Ʒ��ҳ��ʾ
	 * @param pageBean
	 * @throws Exception
	 */
	public void showProductAllPage(PageBean<Items> pageBean) throws Exception;

}
