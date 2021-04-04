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
	
	public ItemsServiceImpl() throws IOException{	//生成此对象时，先执行构造方法，以获取配置信息流
		// 获取流
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 获取SqlSessionFactory,创建会话工厂.传入配置文件信息
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
								 * 赋值给PageBean,使其能通过此总记录数得到其他(出list外)的属性值,
								 * 此setTotalCount()方
								 * 法里会把所查询表的总记录数记住,然后调用setTotalPageCountByRs()方法,
								 * 该方法会根据总记
								 * 录除以之前获得的size(每页显示的记录数)计算总页数,然后再调用setNumbers(
								 * totalPageCount)方
								 * 法,此方法会获取展示页数集合(如1、2、3、4、5、6),引起连锁;
								 * 获取PageBean的totalCount、number、 totalPageCount,三个参数
								 */

			// 3.获取当前页的用户数据，并赋给PageBean
			// List<User> userList=this.userDao.findPageUser(pageBean);
			// 不要给DAO层传进去一堆数据，还得解析，这一块工作应该由业务层承担
			/**
			 * size=5 页号 起始面数 结束页数 1 1 5 2 6 10 3 11 15
			 * 
			 * index >=(index-1)*size+1 <=index*size index >(index-1)*size
			 * <=index*size
			 * 
			 */
			// 指定从那条记录开始(start)到那条记录结束(end)
			// int start=(pageBean.getIndex()-1)*pageBean.getSize();
			// int end=pageBean.getIndex()*pageBean.getSize();
			// 或者使用如下方法
			int start = pageBean.getStartRow();
			int end = pageBean.getEndRow();
			
			List<Items> list = this.itemsDao.findItemsByCount(start, end);
			pageBean.setList(list);	//获取pagebean的list参数
			
			System.out.println("ServiceImpl的list"+list);
			
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
