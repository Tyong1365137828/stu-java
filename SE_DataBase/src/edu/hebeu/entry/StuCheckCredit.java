package edu.hebeu.entry;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class StuCheckCredit {
	
	JFrame creditFrame = new JFrame("����ѧ�ֲ�ѯ");
	
	JScrollPane jScrollPane;
	
	JTable creditTable;
	
	JPanel p1;
	
	String title[] = {"��Ŀγ�","���ѧ��"};
	
	public StuCheckCredit() {
		
		jScrollPane = new JScrollPane();
		
		p1 = new JPanel();
		
		creditFrame.setLayout(new GridLayout(1,1));
		
		String id = MemoryXianShi();
//		String name = null;
		System.out.println("id = "+id);
//		
//		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		
		try {
			
			StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//			
			ResultSet resultSet =studentDaoImpl.FindCreditByName(id);
			
			int count = 0;
			
			while(resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();
			System.out.println("count=="+count);

			Object[][] info = new Object[count][2];//���ñ�Ϊ4������Ϊcount
			count = 0;
			while(resultSet.next()) {
				info[count][0] = resultSet.getString(2);
				info[count][1] = resultSet.getString(3);
				count++;
			}
			
			creditTable = new JTable(info,title);
			creditTable.getTableHeader();
			jScrollPane.getViewport().add(creditTable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		creditFrame.add(p1);
		p1.add(jScrollPane);
		
		creditFrame.setBounds(150, 230, 550, 450);
		creditFrame.setVisible(true);
	}
	

	String MemoryXianShi() {//���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String id = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				id = resultSet.getString(1);//�������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}
