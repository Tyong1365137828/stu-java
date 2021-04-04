package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;

public class AdmShowStu implements ActionListener {

	JFrame showFrame = new JFrame("显示用户信息界面");

	JPanel p1;

	JScrollPane jScrollPane;// 声明一个滚动杠

	JTable stu_table;// 声明一个类JTable对象

	String title[] = { "姓名", "id", "所在系", "学生电话" };

	public AdmShowStu() {

		p1 = new JPanel();

		jScrollPane = new JScrollPane();

		showFrame.setLayout(new GridLayout(1, 1));

		AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
		String stu_name = null;
		String stu_id = null;
		String depid = null;
		String depname = null;

		try {
			ResultSet resultSet = administratorDaoImpl.Findstu();
			int count = 0;
			while (resultSet.next()) {// 获取resultSet的记录数，即行数
				count++;
			}
			System.out.println("count=" + count);

			resultSet.beforeFirst();// 将resultSet的指针置空

			Object[][] info = new Object[count][4];
			count = 0;
			while(resultSet.next()) {
				info[count][0] = resultSet.getString("stu_name");
				
				stu_name = resultSet.getString("stu_name");
				
				AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
				Stu_Id_Key stu_Id_Key = administratorDaoImpl2.FindById(stu_name);
				stu_id = stu_Id_Key.getStu_id();
				depid = stu_Id_Key.getStu_depid();

				AdministratorDaoImpl administratorDaoImpl3 = new AdministratorDaoImpl();
				Dep_Id_Key dep_Id_Key = administratorDaoImpl3.FindDepByDepid(depid);
				depname = dep_Id_Key.getDep_name();
				
				info[count][1] = stu_id;
				info[count][2] = depname;
				info[count][3] = resultSet.getString("stu_tel");
				count ++;
			}
			
			stu_table = new JTable(info, title);
			stu_table.getTableHeader();
			jScrollPane.getViewport().add(stu_table);// 将JTable加入到带滚动条的面板中
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showFrame.add(p1);

		p1.add(jScrollPane);

		showFrame.setBounds(250, 20, 550, 400);
		showFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
