package edu.hebeu.entry;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.User;



public class UserFind implements ActionListener{
	JFrame frame = new JFrame("显示用户信息界面");
	JTabbedPane showPanel;//分页总面板
	JPanel mb1,mb2, mb3;//分页面板
	
	JScrollPane tableScrollPane;// 声明一个滚动杠对象
	
	AbstractTableModel user_table_model;// 声明一个类AbstractTableModel对象
	JTable user_table;// 声明一个类JTable对象
	Vector userVect;// 声明一个向量对象
	String title[] = { "用户名", "密    码"};
	
	JLabel nameLable;
	JTextField nameText;
	JButton findButton;
	
	//构造方法，组织页面，组织显示数据
	public UserFind() {
		
		mb1=new JPanel();
		
		mb2=new JPanel();
		mb3=new JPanel();
		nameLable=new JLabel("输入姓名：");
		nameText=new JTextField(15);
		findButton=new JButton("查找");
		findButton.addActionListener(this);
		mb1.add(nameLable);
		mb1.add(nameText);
		mb1.add(findButton);
		InitTableData();
		
		frame.add(BorderLayout.NORTH,mb1);
	    frame.add(mb2);
		frame.setSize(500, 500);
		frame.setResizable(false);
	
		frame.setVisible(true);
	}
		
	//表格数据初始化
	void InitTableData(){
		userVect = new Vector();// 实例化向量
		user_table_model = new AbstractTableModel() {
			public int getColumnCount() {
				return title.length;
			}// 取得表格列数

			public int getRowCount() {
				return userVect.size();
			}// 取得表格行数

			public Object getValueAt(int row, int column) {
				if (!userVect.isEmpty())
					return ((Vector) userVect.elementAt(row)).elementAt(column);
				else
					return null;
			}// 取得单元格中的属性值

			public String getColumnName(int column) {
				return title[column];
			}// 设置表格列名

			public void setValueAt(Object value, int row, int column) {
				row = 500;
				column = 100;
			}

			// 数据模型不可编辑，该方法设置为空
			public Class getColumnClass(int c) {
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
		
		user_table.setShowHorizontalLines(true);
		tableScrollPane = new JScrollPane(user_table);// 给表格加上滚动杠
		
		mb3.add(tableScrollPane);
		mb2.add(mb3);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		String sname=nameText.getText();
		UserDaoImpl userDao=new UserDaoImpl();
		userVect=userDao.findUserByName(sname);
		userDao.close();
		user_table_model = new AbstractTableModel() {
			public int getColumnCount() {
				return title.length;
			}// 取得表格列数

			public int getRowCount() {
				return userVect.size();
			}// 取得表格行数

			public Object getValueAt(int row, int column) {
				if (!userVect.isEmpty())
					return ((Vector) userVect.elementAt(row)).elementAt(column);
				else
					return null;
			}// 取得单元格中的属性值

			public String getColumnName(int column) {
				return title[column];
			}// 设置表格列名

			public void setValueAt(Object value, int row, int column) {
				row = 500;
				column = 100;
			}

			// 数据模型不可编辑，该方法设置为空
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}// 取得列所属对象类

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 设置单元格不可编辑，为缺省实现
		};
		
		user_table = new JTable(user_table_model);// 生成自己的数据模型
		user_table.setGridColor(frame.getForeground().BLACK);
		
		user_table.setToolTipText("显示全部查询结果");// 设置帮助提示
		//user_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// 设置表格调整尺寸模式,不自动调整列的宽度；使用滚动条。
		user_table.setCellSelectionEnabled(false);// 设置单元格选择方式
		user_table.setShowVerticalLines(true);// 设置是否显示单元格间的分割线
		
		user_table.setShowHorizontalLines(true);
		tableScrollPane = new JScrollPane(user_table);// 给表格加上滚动杠
		
		mb3.add(tableScrollPane);
		mb2.add(mb3);
				
	}
	
	public static void main(String[] args) {
		new UserFind();
	}
	

}


