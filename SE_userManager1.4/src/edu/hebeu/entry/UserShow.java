package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import edu.hebeu.jdbc.GetConn;



public class UserShow implements ActionListener{
	JFrame frame = new JFrame("显示用户信息界面");
	JTabbedPane showPanel;//分页总面板
	JPanel mb1, mb2, mb3;//分页面板
	JPanel mb12,mb13,mb14,mb15;
	JScrollPane tableScrollPane;// 声明一个滚动杠对象
	JLabel userNameLable, userPasswordLable, userNameLableData, userPasswordLableData;
	JButton firstButton,upButton,downButton,lastButton,exitButton;
	AbstractTableModel user_table_model;// 声明一个类AbstractTableModel对象
	JTable user_table;// 声明一个类JTable对象
	Vector<Vector<String>> userVect;// 声明一个向量对象
	String title[] = { "用户名", "密    码"};
	int row1 = 1;//记录当前页面
	int count;  //记录数
	
	//构造方法，组织页面，组织显示数据
	public UserShow() {
		showPanel=new JTabbedPane();//“用户信息展示”字体
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		
		ShowPanel mb11=new ShowPanel();
		mb12=new JPanel();
		mb13=new JPanel();
		mb14=new JPanel();
		mb14.setBackground(Color.gray);
		mb15=new JPanel();
		
		userNameLable=new JLabel("用户名：");
		userPasswordLable=new JLabel("密    码：");
		userNameLableData=new JLabel(" ",10);
		userPasswordLableData=new JLabel(" ",10);
		firstButton=new JButton("首页");
		firstButton.addActionListener(this);
		upButton=new JButton("上一页");
		upButton.addActionListener(this);
		downButton=new JButton("下一页");
		downButton.addActionListener(this);
		lastButton=new JButton("尾页");
		lastButton.addActionListener(this);
		exitButton=new JButton("退回");
		exitButton.addActionListener(this);
		mb1.setLayout(new GridLayout(5, 1));
		mb1.add(mb11);
		mb1.add(mb12);
		mb1.add(mb13);
		mb1.add(mb14);
		mb1.add(mb15);
		mb12.add(userNameLable);
		mb12.add(userNameLableData);
		mb13.add(userPasswordLable);
		mb13.add(userPasswordLableData);
		mb15.add(firstButton);
		mb15.add(upButton);
		mb15.add(downButton);
		mb15.add(lastButton);
		mb15.add(exitButton);
		InitTableData();//卡片显示
		getTableData();//表格
		showPanel.addTab("逐条显示", new ImageIcon("imangs/xsxx.jpg"),mb1);
		showPanel.addTab("列表显示", new ImageIcon("imangs/syxx.png"),mb2);
		frame.add(showPanel);
		frame.setSize(500, 300);
		frame.setResizable(false);
		firstData();
		
		frame.setVisible(true);
	}
	
	void firstData(){
		try {
			GetConn getConn = new GetConn(); // 创建包含有数据库连接类对象
			Connection conn = getConn.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_11");
			rs.last();
			count = rs.getRow();
			if (rs.absolute(row1)) {
				
				String userName = rs.getString("usename");
				String passWord = rs.getString("password");
				
				userNameLableData.setText(userName);
				userPasswordLableData.setText(passWord);
				
			}
		} catch (Exception e) {
		}
	}
	
	//表格数据初始化
	void InitTableData(){
		userVect = new Vector<Vector<String>>();// 实例化向量
		user_table_model = new AbstractTableModel() {
			public int getColumnCount() {
				return title.length;
			}// 取得表格列数

			public int getRowCount() {
				return userVect.size();
			}// 取得表格行数

			public Object getValueAt(int row, int column) {
				if (!userVect.isEmpty())
					return ((Vector<?>) userVect.elementAt(row)).elementAt(column);
				else
					return null;
			}// 取得单元格中的属性值

			public String getColumnName(int column) {
				return title[column];
			}// 设置表格列名

			public void setValueAt(Object value, int row, int column) {
				row = 100;
				column = 100;
			}

			// 数据模型不可编辑，该方法设置为空
			public Class<? extends Object> getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}// 取得列所属对象类

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 设置单元格不可编辑，为缺省实现
		};
		user_table = new JTable(user_table_model);// 生成自己的数据模型
		user_table.setGridColor(frame.getForeground().BLACK);
		//jg_table.setBounds(50, 50, 500, 400);
		user_table.setToolTipText("显示全部查询结果");// 设置帮助提示
		//user_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// 设置表格调整尺寸模式,不自动调整列的宽度；使用滚动条。
		user_table.setCellSelectionEnabled(false);// 设置单元格选择方式
		user_table.setShowVerticalLines(true);// 设置是否显示单元格间的分割线
		///jg_table.col
		user_table.setShowHorizontalLines(true);
		tableScrollPane = new JScrollPane(user_table);// 给表格加上滚动杠
		//user_table.setBounds(100, 30, 200, 200);
		mb3.add(tableScrollPane);
		mb2.add(mb3);
	}
	
	//获取库表数据的方法给表格
	void getTableData(){
		try {
			GetConn getConn = new GetConn(); // 创建包含有数据库连接类对象
			Connection conn = getConn.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_11");
			userVect.removeAllElements();// 初始化向量对象
			user_table_model.fireTableStructureChanged();// 更新表格内容
			while (rs.next()) {
				Vector rec_vector = new Vector();
				// 从结果集中取数据放入向量rec_vector中
				rec_vector.addElement(rs.getString(1));
				rec_vector.addElement(rs.getString(2));
				
				userVect.addElement(rec_vector);// 向量rec_vector加入向量vect中
			}
			user_table_model.fireTableStructureChanged();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(firstButton)) {
			row1 = 1;
			try {
				lastButton.setEnabled(true);
				GetConn getConn = new GetConn(); // 创建包含有数据库连接类对象
				Connection conn = getConn.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from user_11");
				userVect.removeAllElements();// 初始化向量对象
				user_table_model.fireTableStructureChanged();// 更新表格内容
				if (rs.first()) {
					String userName = rs.getString("usename");
					String passWord = rs.getString("password");
					
					userNameLableData.setText(userName);
					userPasswordLableData.setText(passWord);
					
				}
			} catch (Exception ess) {
			}
		}
		if (e.getSource().equals(upButton)) {
			row1 -= 1;
			firstData();
			if (row1 <= 1) {
				firstButton.setEnabled(false);
				row1 = 1;
			}
			lastButton.setEnabled(true);

		}
		if (e.getSource().equals(downButton)) {
			row1++;
			firstData();
			if (row1 >= count) {
				row1 = count;
				lastButton.setEnabled(false);
			}
			firstButton.setEnabled(true);

		}
		if (e.getSource().equals(lastButton)) {
			row1 = count;
			try {
				firstButton.setEnabled(true);
				GetConn getConn = new GetConn(); // 创建包含有数据库连接类对象
				Connection conn = getConn.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from user_11");
				userVect.removeAllElements();// 初始化向量对象
				user_table_model.fireTableStructureChanged();// 更新表格内容
				if (rs.last()) {
					String userName = rs.getString("usename");
					String passWord = rs.getString("password");
					
					userNameLableData.setText(userName);
					userPasswordLableData.setText(passWord);
				}
			} catch (Exception ess) {
			}
		}
		if (e.getSource().equals(exitButton)) {
			frame.dispose();
		}
		
	}
	
	/*
	public static void main(String[] args) {
		new UserShow();
	}
	*/
	
	public static void main(String[] args) {
		new UserShow();
	}

}

class ShowPanel extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 20));
			g.setColor(Color.red);
			g.drawString("用户信息展示", 180, 20);
	}
}
