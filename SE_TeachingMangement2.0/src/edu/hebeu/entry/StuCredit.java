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

import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class StuCredit {
	
	JFrame creditFrame = new JFrame("����ѧ�ֲ�ѯ");
	
	JScrollPane jScrollPane;
	
	JTable creditTable;
	
	JPanel p1;
	
	String title[] = {"�ҵĿγ�","����ѧ��","�ον�ʦid","�ον�ʦ"};
	
	String account;
	
	
	public StuCredit() {
		jScrollPane = new JScrollPane();
		
		p1 = new JPanel();
		creditFrame.setLayout(new GridLayout(5,1));
		
		try {
			ResultSet resultSet = null;
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
		
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditBynumber(account);
			
			int count = 0;
			while(resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();
			
			Object[][] info = new Object[count][4];
			count = 0;
			while(resultSet.next()) {
				info[count][0] = resultSet.getString(2);
				info[count][1] = resultSet.getString(3);
				info[count][2] = resultSet.getString(4);
				
				String teaId=resultSet.getString(4);
				TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
				ResultSet result2 = null;
				result2 = teacherDaoImpl.SelectTea(teaId);
				result2.next();
				info[count][3] = result2.getString(2);
				
				count ++ ;
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
		
		creditFrame.setSize(800, 900);
		creditFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new StuCredit();
	}
	
	String MemoryXianShi() {//���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				account = resultSet.getString(1);//�������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
}
