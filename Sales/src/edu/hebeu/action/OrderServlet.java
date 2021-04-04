package edu.hebeu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.po.Order;
import edu.hebeu.service.OrderService;
import edu.hebeu.service.impl.OrderServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/myServlet/Order")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public OrderServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 分页查看全部订单
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void CheckAllOrderPage(HttpServletRequest request, HttpServletResponse response)
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

		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数

		OrderService orderService = new OrderServiceImpl();
		try {
			orderService.findallorder(pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("orderlist", pageBean);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}

}
