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
import edu.hebeu.jdbc.GetConn;

public class StuCheckCou {
	
	JFrame stuclassFrame = new JFrame("我的课程");
	
	JScrollPane jScrollPane;
	
	JTable classTable;
	
	JPanel p1;
	
	String title[] = {"我的课程","学时","上课地点","考试时间","教师"};
	
	String account;
	int count=0;
	
	public StuCheckCou() {
		
		jScrollPane = new JScrollPane();
		
		p1 = new JPanel();
		
		stuclassFrame.setLayout(new GridLayout(1,1));
		
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		
		try {
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditBynumber(account);
			while(resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();
			
			int i;
			Object[][] info = new Object[count][5];
			for(i=0;i<count;i++) {
				
				resultSet.next();
				info[i][0] = resultSet.getString(2);
				String coures = resultSet.getString(2);
				String teaId = resultSet.getString(4);
				
				resultSet2 = courseDaoImpl.FindCouInformation(coures,teaId);
				
				resultSet2.next();
				info[i][1] = resultSet2.getString(3);
				info[i][2] = resultSet2.getString(4);
				info[i][3] = resultSet2.getString(5);
				
				ResultSet resultSet3 = null;
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				
				String sql = "select * from teacher where tea_id='"+teaId+"'";
				
				Statement statement = connection.createStatement();
				
				resultSet3 = statement.executeQuery(sql);
				resultSet3.next();
				info[i][4] = resultSet3.getString(2);
				
				classTable = new JTable(info,title);
				classTable.getTableHeader();
				jScrollPane.getViewport().add(classTable);
				
			}
			
			
//			StuAndCou stuAndCou = new StuAndCou(null,cou[0], cou[1], cou[2], cou[3], cou[4], cou[5]);
//			
//			resultSet2 = courseDaoImpl.FindInformationByCou(stuAndCou);
//			
//			int count = 0;
//			while(resultSet2.next()) {
//				count++;
//			}
//			resultSet2.beforeFirst();
//			
//			Object[][] info = new Object[count][4];
//			count = 0;
//			while(resultSet2.next()) {
//			info[count][0] = resultSet2.getString(2);
//			info[count][1] = resultSet2.getString(3);
//			info[count][2] = resultSet2.getString(4);
//			info[count][3] = resultSet2.getString(5);
//			count ++;
//		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		stuclassFrame.add(p1);
		
		p1.add(jScrollPane);
		
		stuclassFrame.setSize(800, 900);
		stuclassFrame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new StuCheckCou();
	}

	String MemoryXianShi() {//将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				account = resultSet.getString(1);//将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	
		
}
