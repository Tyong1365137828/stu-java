package edu.hebeu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.hebeu.dao.ItemsDao;
import edu.hebeu.po.Items;
import edu.hebeu.service.ItemsService;
import edu.hebeu.util.PageBean;

public class ItemsServiceImpl implements ItemsService{
	private ItemsDao itemsDao;
	private SqlSessionFactory sqlSessionFactory;
	
	public ItemsServiceImpl() throws IOException{	//���ɴ˶���ʱ����ִ�й��췽�����Ի�ȡ������Ϣ��
		// ��ȡ��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ��ȡSqlSessionFactory,�����Ự����.���������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	/**
	 * 
	 */
	@Override
	public void showProductAllPage(PageBean<Items> pageBean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		itemsDao = sqlSession.getMapper(ItemsDao.class);
		
		int totalCount = this.itemsDao.FindAllItems().size();
		
		pageBean.setTotalCount(
				totalCount);/*
								 * ��ֵ��PageBean,ʹ����ͨ�����ܼ�¼���õ�����(��list��)������ֵ,
								 * ��setTotalCount()��
								 * ����������ѯ����ܼ�¼����ס,Ȼ�����setTotalPageCountByRs()����,
								 * �÷���������ܼ�
								 * ¼����֮ǰ��õ�size(ÿҳ��ʾ�ļ�¼��)������ҳ��,Ȼ���ٵ���setNumbers(
								 * totalPageCount)��
								 * ��,�˷������ȡչʾҳ������(��1��2��3��4��5��6),��������;
								 * ��ȡPageBean��totalCount��number�� totalPageCount,��������
								 */

			// 3.��ȡ��ǰҳ���û����ݣ�������PageBean
			// List<User> userList=this.userDao.findPageUser(pageBean);
			// ��Ҫ��DAO�㴫��ȥһ�����ݣ����ý�������һ�鹤��Ӧ����ҵ���е�
			/**
			 * size=5 ҳ�� ��ʼ���� ����ҳ�� 1 1 5 2 6 10 3 11 15
			 * 
			 * index >=(index-1)*size+1 <=index*size index >(index-1)*size
			 * <=index*size
			 * 
			 */
			// ָ����������¼��ʼ(start)��������¼����(end)
			// int start=(pageBean.getIndex()-1)*pageBean.getSize();
			// int end=pageBean.getIndex()*pageBean.getSize();
			// ����ʹ�����·���
			int start = pageBean.getStartRow();
			int end = pageBean.getEndRow();
			
			List<Items> list = this.itemsDao.findItemsByCount(start, end);
			pageBean.setList(list);	//��ȡpagebean��list����
			
			System.out.println("ServiceImpl��list"+list);
			
			System.out.println("TotalCount=" + pageBean.getTotalCount());
			System.out.println("TotalPageCount=" + pageBean.getTotalPageCount());
			System.out.println("Numbers=" + pageBean.getNumbers());
			System.out.println("StartRow=" + pageBean.getStartRow() + ";	EndRow" + pageBean.getEndRow());
			System.out.println("Index=" + pageBean.getIndex() + ";		Size" + pageBean.getSize());
			System.out.println("List=" + pageBean.getList());
			System.out.println("Class=" + pageBean.getClass());
			
			sqlSession.close();
	}

	
	@Override
	public List<Items> showProduce() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		itemsDao = sqlSession.getMapper(ItemsDao.class);
		
		List<Items> list = itemsDao.FindAllItems();
		sqlSession.close();
		return list;
	}


	@Override
	public Items showProduceByCode(Items items) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		itemsDao = sqlSession.getMapper(ItemsDao.class);
		
		Items items2 = itemsDao.findItemsByCode(items);
		sqlSession.close();
		
		return items2;
	}


	@Override
	public List<Items> showProduce(Items items) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		itemsDao = sqlSession.getMapper(ItemsDao.class);
		
		List<Items> list = itemsDao.FindMulItems(items);
		sqlSession.close();
		return list;
	}

}
