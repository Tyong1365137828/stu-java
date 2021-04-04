package edu.hebeu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.po.Items;
import edu.hebeu.service.ItemsService;
import edu.hebeu.service.impl.ItemsServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/myServlet/Items")

public class ItemsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ItemsServlet() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 显示全部商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ViewAllProduce(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemsService itemsService = new ItemsServiceImpl();
		List<Items> list = null;
		try {
			list =itemsService.showProduce();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("商品图片list="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
		
	}
	
	/**
	 * 通过code展示商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProductView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		ItemsService itemsService = new ItemsServiceImpl();
		
		Items items = new Items();
		items.setCode(code);
		
		Items items2= new Items();
		try {
			items2 = itemsService.showProduceByCode(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("showitems", items2);
		request.getRequestDispatcher("/show_items.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 模糊展示商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("proname");
		Items items2 = new Items();
		items2.setName(name);
		
		ItemsService itemsService = new ItemsServiceImpl();
		List<Items> list = null;
		try {
			list =itemsService.showProduce(items2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("name="+name);
		System.out.println("items2"+items2);
		System.out.println("模糊商品图片list="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
	}
	
	
	/**
	 * 分页显示全部信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void PageViewItems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收参数
		int index = 1;// 当前页,默认1
		String sindex = request.getParameter("index");// 接受前台传来的操作,对应的第几页
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// 赋值给当前页
		}

		int size = 4;// 当前每页的记录数,默认4
		String ssize = request.getParameter("size");// 接受前台传来的操作,对应每页的记录数
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// 赋值给当前每页的记录数
		}

		System.out.println("当前页是:" + index);
		System.out.println("当前每页的记录数是:" + size);
		
		PageBean<Items> pageBean = new PageBean<Items>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数
		
		ItemsService itemsService = new ItemsServiceImpl();
		
		try {
			itemsService.showProductAllPage(pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("itemslist", pageBean);
		request.getRequestDispatcher("/admin/items.jsp").forward(request, response);

	}
}
