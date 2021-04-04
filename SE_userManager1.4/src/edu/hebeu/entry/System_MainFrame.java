package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class System_MainFrame extends JFrame {
	JMenuBar menubar;
	JMenu userMenu;
	JMenu helpMenu;
	JMenu studentMenu;
	JMenu exitMenu;
	JMenuItem j1,j11;
	JMenuItem j2;
	JMenuItem j3;
	JMenuItem j4;
	JMenuItem j41;
	JMenuItem j5;
	JMenuItem exit1;
	private JScrollPane scpDemo;
	private JTable tabDemo;
	JFrame f;
	int screenWidth,screenHgiht;
	
	public System_MainFrame() {

		Toolkit tk = getToolkit();
		Dimension screenSize = tk.getScreenSize();
		screenWidth = screenSize.width;
		screenHgiht = screenSize.height;
        
		f=new JFrame("学生管理系统");
		f.setSize(screenWidth, screenHgiht);
		f.setResizable(false);
		final Zjmpanel p1 = new Zjmpanel();
		f.add(p1);
		
		menubar = new JMenuBar();
		userMenu = new JMenu("用户信息管理");
		userMenu.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 18));
		studentMenu=new JMenu("学生信息管理");
		studentMenu.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 18));
		helpMenu=new JMenu("帮助");
		helpMenu.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 18));
		exitMenu=new JMenu("退出");
		exitMenu.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 18));
				
		j1 = new JMenuItem("用户信息显示--表格");
		j1.setFont(new Font("楷体", Font.PLAIN, 16));
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userTableShow();
			}
		});
		
		j11 = new JMenuItem("用户信息显示--页框");
		j11.setFont(new Font("楷体", Font.PLAIN, 16));
		j11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new UserShow();
			}
		});
		
		j2 = new JMenuItem("用户信息注册");
		j2.setFont(new Font("楷体", Font.PLAIN, 16));
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserGegister();
			}
		});
		j3 = new JMenuItem("用户密码修改");
		j3.setFont(new Font("楷体", Font.PLAIN, 16));
		j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateUserPassword();
				
			}
		});
		
		j4 = new JMenuItem("用户信息查询---Vector");
		j4.setFont(new Font("楷体", Font.PLAIN, 16));
		j4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserFind();
				
			}
		});
		
		j41 = new JMenuItem("用户信息查询---ResultSet");
		j41.setFont(new Font("楷体", Font.PLAIN, 16));
		j41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserFindList();
				
			}
		});
		
		j5 = new JMenuItem("用户信息删除");
		j5.setFont(new Font("楷体", Font.PLAIN, 16));
		j5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p1.setBackground(Color.green);
				new DeleteFrame();
			}
		});
		exit1 = new JMenuItem("退出");
		exit1.setFont(new Font("楷体", Font.PLAIN, 16));
		exit1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		userMenu.add(j1);
		userMenu.add(j11);
		userMenu.addSeparator();
		userMenu.add(j2);
		userMenu.add(j3);
		userMenu.addSeparator();
		userMenu.add(j4);
		userMenu.add(j41);
		userMenu.addSeparator();
		userMenu.add(j5);
		exitMenu.add(exit1);
		menubar.add(userMenu);
		menubar.add(studentMenu);
		menubar.add(helpMenu);
		menubar.add(exitMenu);
		f.setJMenuBar(menubar);

		f.setVisible(true);
	}
	
	public void userTableShow(){
		//f.dispose();
		JFrame f1=new JFrame();
		f1.setSize(500, 500);
		f1.setLocation((screenWidth-500)/2, (screenHgiht-500)/2);
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		try {
			// 获得连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC", "root", "root");
			// 建立查询条件
			String sql = "select * from user_11";
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 执行查询
			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
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
			String[] title = { "姓名", "密码"};
			// 创建JTable
			this.tabDemo = new JTable(info, title);
			this.tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.scpDemo.getViewport().add(tabDemo);
			f1.add(scpDemo);
			f1.setVisible(true);
			rs.close();
			conn.close();
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

}

class Zjmpanel extends JPanel {
	public Zjmpanel() {
		setBackground(Color.cyan);
		// setBackground(getBackground());
	}
}
