package edu.hebeu.entry;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Name_Key;

public class StuInformation {
	
	JFrame informationFrame = new JFrame("个人信息查看");
	
	JLabel nameLabel,idLabel,telLabel,depLabel,addressLabel,ageLabel,sexLabel,namedataLabel,iddataLabel,teldataLabel,depdataLabel,addressdataLabel,agedataLabel,sexdataLabel;
	
	JPanel p1,p2,p3,p4,p5;
	
	public StuInformation() {
		
		nameLabel = new JLabel("姓名：");
		namedataLabel = new JLabel("", 10);
		idLabel = new JLabel("id：");
		iddataLabel = new JLabel("", 10);
		telLabel = new JLabel("电话：");
		teldataLabel = new JLabel("", 10);
		depLabel = new JLabel("系名：");
		depdataLabel = new JLabel("", 10);
		addressLabel = new JLabel("地址：");
		addressdataLabel = new JLabel("", 10);
		ageLabel = new JLabel("年龄：");
		agedataLabel = new JLabel("",10);
		sexLabel = new JLabel("性别：");
		sexdataLabel = new JLabel("",10);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		informationFrame.setLayout(new GridLayout(5,1));
		
		informationFrame.add(p1);
		informationFrame.add(p2);
		informationFrame.add(p3);
		informationFrame.add(p4);
		informationFrame.add(p5);
		
		p1.add(nameLabel);
		p1.add(namedataLabel);
		p1.add(sexLabel);
		p1.add(sexdataLabel);
		p2.add(idLabel);
		p2.add(iddataLabel);
		p2.add(ageLabel);
		p2.add(agedataLabel);
		p3.add(telLabel);
		p3.add(teldataLabel);
		p4.add(depLabel);
		p4.add(depdataLabel);
		p5.add(addressLabel);
		p5.add(addressdataLabel);
		
		informationFrame.setBounds(800, 200, 550, 450);
		informationFrame.setVisible(true);
		
		String id = MemoryXianShi();
		String name = null;
		String depid = null;
		String depname = null;
		String tel = null;
		String address = null;
		String age = null;
		String sex = null;
		
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		
		try {
			ResultSet resultSet = studentDaoImpl.FindStuById(id);
		
			int count =0;
			while(resultSet.next()) {
				count++;
			}
			System.out.println("count="+count);
			resultSet.beforeFirst();
			
			count = 0;
			while(resultSet.next()) {
				name = resultSet.getString("stu_name");
				depid = resultSet.getString("stu_depid");
			}
			System.out.println("id="+id);
			System.out.println("name="+name);
			System.out.println("depid="+depid);
			
			StudentDaoImpl studentDaoImpl2 = new StudentDaoImpl();
			Dep_Id_Key dep_Id_Key = studentDaoImpl2.FindDepByDepid(depid);
			depname = dep_Id_Key.getDep_name();
			System.out.println("depname"+depname);
			
			StudentDaoImpl studentDaoImpl3 = new StudentDaoImpl();
			Stu_Name_Key stu_Name_Key = studentDaoImpl3.FindStuByName(name);
			tel = stu_Name_Key.getStu_tel();
			address = stu_Name_Key.getStu_address();
			age = stu_Name_Key.getStu_age();
			sex = stu_Name_Key.getStu_sex();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		namedataLabel.setText(name);
		sexdataLabel.setText(sex);
		iddataLabel.setText(id);
		agedataLabel.setText(age);
		teldataLabel.setText(tel);
		depdataLabel.setText(depname);
		addressdataLabel.setText(address);
		
	}
	
	
	
	String MemoryXianShi() {//将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String id = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				id = resultSet.getString(1);//将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
}
