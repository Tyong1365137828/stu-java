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

	JFrame showFrame = new JFrame("��ʾ�û���Ϣ����");

	JPanel p1;

	JScrollPane jScrollPane;// ����һ��������

	JTable stu_table;// ����һ����JTable����

	String title[] = { "����", "id", "����ϵ", "ѧ���绰" };

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
			while (resultSet.next()) {// ��ȡresultSet�ļ�¼����������
				count++;
			}
			System.out.println("count=" + count);

			resultSet.beforeFirst();// ��resultSet��ָ���ÿ�

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
			jScrollPane.getViewport().add(stu_table);// ��JTable���뵽���������������
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
