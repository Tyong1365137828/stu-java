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
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class TeaSelectStu {

	JFrame myStuFrame = new JFrame("�ҵ�ѧ��");

	JScrollPane jScrollPane;

	JTable classTable;

	JPanel p1;

	String title[] = { "�γ�", "ѧ��id", "ѧ������", "ѧ���绰", "ѧ��" };

	String account;
	int count = 0;

	public TeaSelectStu() {

		jScrollPane = new JScrollPane();

		p1 = new JPanel();

		myStuFrame.setLayout(new GridLayout(1, 1));

		try {
			ResultSet resultSet = null;
			ResultSet resultSet2 = null;

			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditByTeanumber(account);
			while (resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();
			
			int i;
			Object[][] info = new Object[count][5];
			for(i=0;i<count;i++) {
				
				resultSet.next();
				
				String stuId = resultSet.getString(1);
				System.out.println("="+stuId);
				
				info[i][0] = resultSet.getString(2);
				info[i][1] = resultSet.getString(1);
				info[i][4] = resultSet.getString(3);
				
				
				/*
				 * 
				 * ��ѯ��ѡ�˿ε�ѧ����Ϣ
				 * 
				 * */
				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				resultSet2 = studentDaoImpl.FindAllStudentByNumber(stuId);
				
				resultSet2.next();
				info[i][2] = resultSet2.getString(2);
				info[i][3] = resultSet2.getString(8);
				
				classTable = new JTable(info,title);
				classTable.getTableHeader();
				jScrollPane.getViewport().add(classTable);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myStuFrame.add(p1);
		p1.add(jScrollPane);
		myStuFrame.setSize(500, 600);
		myStuFrame.setVisible(true);
		
	}

	String MemoryXianShi() {// ���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	public static void main(String[] args) {
		new TeaSelectStu();
	}
	
}
