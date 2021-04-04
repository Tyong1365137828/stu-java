package edu.hebeu.entry;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Department;

public class StudentInformationAll {

	JFrame cheInformationFrame = new JFrame("学生个人信息查看");

	JLabel namLabel,numLabel,telLabel,genderLabel,idcardLabel,ageLabel,depLabel,addressLabel;
	JLabel namLabel2,numLabel2,telLabel2,genderLabel2,idcardLabel2,ageLabel2,depLabel2,addressLabel2;
	
	JPanel p1, p2,p3,p4,p5,p6;
	
	String  num = findAccountStudent(),name =null,tel=null,sex = null,
			idcard = null,age = null,address =null,depnum=null,depnam = null;
	
	public StudentInformationAll() {
		
		namLabel = new JLabel("	名字：");
		namLabel2 = new JLabel("",10);
		numLabel = new JLabel("	学号：");
		numLabel2 = new JLabel("",10);
		telLabel = new JLabel("	电话号：");
		telLabel2 = new JLabel("",10);
		genderLabel = new JLabel("	性别：");
		genderLabel2 = new JLabel("",10);
		idcardLabel = new JLabel("	身份证号：");
		idcardLabel2 = new JLabel("",10);
		ageLabel = new JLabel("	年龄：");
		ageLabel2 = new JLabel("",10);
		depLabel = new JLabel("	所在系：");
		depLabel2 = new JLabel("",10);
		addressLabel = new JLabel("	地址：");
		addressLabel2 = new JLabel("",10);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		System.out.println("asgdfghcgmxfhgfar");

//		numberJLabel.setText(findAccountStudent() + "您好！！");
		
		cheInformationFrame.setLayout(new GridLayout(6, 1));
		
		cheInformationFrame.add(p1);
		cheInformationFrame.add(p2);
		cheInformationFrame.add(p3);
		cheInformationFrame.add(p4);
		cheInformationFrame.add(p5);
		cheInformationFrame.add(p6);

		p2.add(namLabel);
		p2.add(namLabel2);
		p2.add(genderLabel);
		p2.add(genderLabel2);
		p3.add(numLabel);
		p3.add(numLabel2);
		p3.add(depLabel);
		p3.add(depLabel2);
		p4.add(idcardLabel);
		p4.add(idcardLabel2);
		p4.add(ageLabel);
		p4.add(ageLabel2);
		p5.add(telLabel);
		p5.add(telLabel2);
		p6.add(addressLabel);
		p6.add(addressLabel2);
		
		information();
		
		cheInformationFrame.setSize(600, 800);
		cheInformationFrame.setVisible(true);
		


	}
	
	private void information() {
		
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		num = findAccountStudent();
		System.out.println(num);
		try {
			ResultSet resultSet = studentDaoImpl.FindAllStudentByNumber(num);
//			int count = 0;
//			while (resultSet.next()) {//获取resultSet的记录数，即行数
//				count++;
//			}
//			System.out.println("count is:"+count);
//			resultSet.beforeFirst();//将resultSet的指针置空
//			
//			count = 0;//将count变0，以获取resultSet的内容
			while (resultSet.next()) {
				name = resultSet.getString("stu_name");//表的第一列取stu_name列
				sex = resultSet.getString("stu_gender");
				depnum = resultSet.getString("stu_depnum");
				age = resultSet.getString("stu_age");
				address=resultSet.getString("stu_address");//表的第二列取stu_address列
				tel=resultSet.getString("stu_tel");//表的第四列取stu_tel列
				idcard = resultSet.getString("stu_idcard");
			}
			
			Department department = new Department();
			department.setDepnum(depnum);
			department.setDepaddress(null);
			department.setDepnam(null);
			department.setDeptel(null);
			System.out.println("depnum="+depnum);
			System.out.println("depnam="+depnam);
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			depnam = courseDaoImpl.FindDepNam(department);
			
			System.out.println(num);
			System.out.println(name);
			System.out.println(sex);
			System.out.println(depnam);
			System.out.println(age);
			System.out.println(address);
			System.out.println(tel);
			System.out.println(idcard);
			
			numLabel2.setText(num);
			namLabel2.setText(name);
			genderLabel2.setText(sex);
			depLabel2.setText(depnam);
			ageLabel2.setText(age);
			addressLabel2.setText(address);
			telLabel2.setText(tel);
			idcardLabel2.setText(idcard);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	String findAccountStudent() {

		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select * from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				account = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	public static void main(String[] args) {
		new StudentInformationAll();
	}
	
}
