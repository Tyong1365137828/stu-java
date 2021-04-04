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
	 * ��ҳ�鿴ȫ������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void CheckAllOrderPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���ղ���
		int index = 1;// ��ǰҳ,Ĭ��1
		String sindex = request.getParameter("index");// ����ǰ̨�����Ĳ���,��Ӧ�ĵڼ�ҳ
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// ��ֵ����ǰҳ
		}

		int size = 4;// ��ǰÿҳ�ļ�¼��,Ĭ��4
		String ssize = request.getParameter("size");// ����ǰ̨�����Ĳ���,��Ӧÿҳ�ļ�¼��
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// ��ֵ����ǰÿҳ�ļ�¼��
		}

		System.out.println("��ǰҳ��:" + index);
		System.out.println("��ǰÿҳ�ļ�¼����:" + size);

		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������

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
