package edu.hebeu.entry;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class UserFindList implements ActionListener{
	JFrame frame = new JFrame("显示用户信息界面");
	
	JPanel mb1,mb2;//分页面板
	
	JScrollPane tableScrollPane;// 声明一个滚动杠对象
		
	JTable user_table;// 声明一个类JTable对象
	
	String title[] = { "用户名", "密    码"};
	
	JLabel nameLable;
	JTextField nameText;
	JButton findButton;
	public UserFindList() {
		
        mb1=new JPanel();
		mb2=new JPanel();
		
		nameLable=new JLabel("输入姓名：");
		nameText=new JTextField(15);
		findButton=new JButton("查找");
		findButton.addActionListener(this);
		mb1.add(nameLable);
		mb1.add(nameText);
		mb1.add(findButton);
				
		frame.add(BorderLayout.NORTH,mb1);
	    frame.add(mb2);
	    
		frame.setSize(500, 500);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.tableScrollPane = new JScrollPane();
		this.tableScrollPane.setBounds(100, 50, 300, 270);
		
		UserDaoImpl userDao=new UserDaoImpl();
		
		String name=nameText.getText();
		System.out.println("ttt");
		try {
			ResultSet rs=userDao.findUserByNameResult(name);
		    System.out.println("yyy");
		    //userDao.close();
//			// 获得连接
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC", "root", "root");
//			// 建立查询条件
//			String sql = "select * from user_11 ";
//			PreparedStatement pstm = conn.prepareStatement(sql);
//			// 执行查询
//			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while (rs.next()) {
				count++;
			}
			System.out.println(count);
			rs.beforeFirst();
			//rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][2];
			count = 0;
			while (rs.next()) {
//				info[count][0] = Integer.valueOf(rs.getInt("id"));
				
				info[count][0] = rs.getString("usename");
				info[count][1] = rs.getString("password");
				count++;
			}
			// 定义表头
			//String[] title = { "姓名", "密码"};
			// 创建JTable
			this.user_table = new JTable(info, title);
			this.user_table.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.tableScrollPane.getViewport().add(user_table);
			mb2.add(tableScrollPane);
			//f1.setVisible(true);
			//rs.close();
			userDao.close();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new UserFindList();
	}

}
