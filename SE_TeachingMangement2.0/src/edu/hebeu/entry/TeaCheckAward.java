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

import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class TeaCheckAward {
	
	JFrame teaAwardFrame = new JFrame("我的奖励");

	JScrollPane jScrollPane;

	JTable awardTable;

	JPanel p1;

	String title[] = { "学号", "姓名", "我的奖励", "获得时间" };

	String account;
	int count = 0;
	
	public TeaCheckAward() {
		
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;

		jScrollPane = new JScrollPane();

		p1 = new JPanel();

		teaAwardFrame.setLayout(new GridLayout(1, 1));

		account = MemoryXianShi();
		
		try {
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		
		resultSet = teacherDaoImpl.FindAwardByNum(account);
		
			while (resultSet.next()) {
				count++;
			}
			
			resultSet.beforeFirst();

			int i;
			Object[][] info = new Object[count][4];
			for (i = 0; i < count; i++) {
				resultSet.next();
				info[i][0] = resultSet.getString(1);
				info[i][2] = resultSet.getString(2);
				info[i][3] = resultSet.getString(3);

				TeacherDaoImpl teacherDaoImpl2 = new TeacherDaoImpl();
				resultSet2 = teacherDaoImpl2.SelectTea(account);
				
				resultSet2.next();
				info[i][1] = resultSet2.getString(2);
				
				awardTable = new JTable(info, title);
				awardTable.getTableHeader();
				jScrollPane.getViewport().add(awardTable);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		teaAwardFrame.add(p1);

		p1.add(jScrollPane);

		teaAwardFrame.setSize(800, 900);
		teaAwardFrame.setVisible(true);

	}
	
	String MemoryXianShi() {// 将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// 将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	public static void main(String[] args) {
		new TeaCheckAward();
	}
	
}
