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
	 * ��ʾȫ����Ʒ
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
		
		System.out.println("��ƷͼƬlist="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
		
	}
	
	/**
	 * ͨ��codeչʾ��Ʒ
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
	 * ģ��չʾ��Ʒ
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
		System.out.println("ģ����ƷͼƬlist="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
	}
	
	
	/**
	 * ��ҳ��ʾȫ����Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void PageViewItems(HttpServletRequest request, HttpServletResponse response)
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
		
		PageBean<Items> pageBean = new PageBean<Items>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������
		
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
