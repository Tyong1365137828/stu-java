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
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Department;

public class TeaInformationAll {

	JFrame cheInformationFrame = new JFrame("��ʦ������Ϣ�鿴");

	JLabel namLabel, numLabel, telLabel, genderLabel, idcardLabel, ageLabel, depLabel, classLabel;
	JLabel namLabel2, numLabel2, telLabel2, genderLabel2, idcardLabel2, ageLabel2, depLabel2, classLabel2;

	JPanel p1, p2, p3, p4, p5, p6;

	String num = findAccount(), name = null, tel = null, sex = null, idcard = null, age = null, address = null,
			depnum = null, depnam = null;

	public TeaInformationAll() {

		namLabel = new JLabel("	���֣�");
		namLabel2 = new JLabel("", 10);
		numLabel = new JLabel("	ѧ�ţ�");
		numLabel2 = new JLabel("", 10);
		telLabel = new JLabel("	�绰�ţ�");
		telLabel2 = new JLabel("", 10);
		genderLabel = new JLabel("	�Ա�");
		genderLabel2 = new JLabel("", 10);
		idcardLabel = new JLabel("	���֤�ţ�");
		idcardLabel2 = new JLabel("", 10);
		ageLabel = new JLabel("	���䣺");
		ageLabel2 = new JLabel("", 10);
		depLabel = new JLabel("	����ϵ��");
		depLabel2 = new JLabel("", 10);
		classLabel = new JLabel("�οΣ�");
		classLabel2 = new JLabel("", 10);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();

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
		p6.add(classLabel);
		p6.add(classLabel2);
		
		information();

		cheInformationFrame.setSize(600, 800);
		cheInformationFrame.setVisible(true);

	}

	private void information() {

		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		num = findAccount();

		try {
			ResultSet resultSet = teacherDaoImpl.SelectTea(num);
//			while (resultSet.next()) {
//				count++;
//			}
//			resultSet.beforeFirst();//��resultSet��ָ���ÿ�
//			
//			count = 0;//��count��0���Ի�ȡresultSet������
			while (resultSet.next()) {
				name = resultSet.getString("tea_name");//��ĵ�һ��ȡstu_name��
				sex = resultSet.getString("tea_gender");
				depnum = resultSet.getString("tea_depnum");
				age = resultSet.getString("tea_age");
				tel=resultSet.getString("tea_tel");//��ĵ�����ȡstu_tel��
				idcard = resultSet.getString("tea_idcard");
			}
			
			/*
			 * 
			 * ��ѯ����ϵ
			 * 
			 * */
			Department department = new Department();
			department.setDepnum(depnum);
			department.setDepaddress(null);
			department.setDepnam(null);
			department.setDeptel(null);
			System.out.println("depnum="+depnum);
			System.out.println("depnam="+depnam);
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			depnam = courseDaoImpl.FindDepNam(department);
			
			/*
			 * 
			 * ��ѯ��ʦ���ڿ�
			 * 
			 * */
			String classes = null;
			CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
			ResultSet resultSet2 = courseDaoImpl2.FindCouInformationByTea(num);
			while(resultSet2.next()) {
				classes = resultSet2.getString(2);
			}
			
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
			telLabel2.setText(tel);
			idcardLabel2.setText(idcard);
			classLabel2.setText(classes);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String findAccount() {

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
		new TeaInformationAll();
	}
}
