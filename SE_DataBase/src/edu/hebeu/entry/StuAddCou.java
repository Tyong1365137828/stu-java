package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class StuAddCou implements ActionListener {
	JFrame addcouFrame = new JFrame("��ӿγ̽���");
	
	JPanel p1, p2, p3, p4, p5, p6, p7;
	JLabel couLabel, coudataLabel, placeLabel, placedataLabel, periodLabel, perioddataLabel;
	
	JButton addButton, upButton, downButton;

	int count;
	int row = 1;
	
	public StuAddCou() {
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		
		couLabel = new JLabel("��ѡ�γ�");
		coudataLabel = new JLabel("", 10);
		placeLabel = new JLabel("�ص�");
		placedataLabel = new JLabel("", 10);
		periodLabel = new JLabel("��ʱ");
		perioddataLabel = new JLabel("", 10);

		addButton = new JButton("��ӿγ�");
		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");

		addcouFrame.setLayout(new GridLayout(7, 1));

		addcouFrame.add(p1);
		addcouFrame.add(p2);
		addcouFrame.add(p3);
		addcouFrame.add(p4);
		addcouFrame.add(p5);
		addcouFrame.add(p6);
		addcouFrame.add(p7);

		p2.add(couLabel);
		p2.add(coudataLabel);
		p3.add(placeLabel);
		p3.add(placedataLabel);
		p4.add(periodLabel);
		p4.add(perioddataLabel);
		p5.add(upButton);
		p5.add(downButton);
		p5.add(addButton);
		
		chaXun();
		addcouFrame.setSize(600, 700);
		
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		addButton.addActionListener(this);

		addcouFrame.setVisible(true);

	}

	private void chaXun() {
		ResultSet resultSet = null;

		try {
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

			resultSet = courseDaoImpl.SelectCou();
			resultSet.last();
			count = resultSet.getRow();

			if (resultSet.absolute(row)) {
				String coures = resultSet.getString(2);
				String period = resultSet.getString(3);
				String place = resultSet.getString(4);

				coudataLabel.setText(coures);
				perioddataLabel.setText(period);
				placedataLabel.setText(place);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upButton) {
			row--;
			chaXun();
			downButton.setEnabled(true);
			if (row <= 1) {
				upButton.setEnabled(true);
				row = 1;
			}
		}
		
		if(e.getSource() == downButton) {
			row++;
			chaXun();
			upButton.setEnabled(true);
			if(row>=count) {
				row = count;
				downButton.setEnabled(false);
			}
		}
		
		if(e.getSource() == addButton) {
			String coures = coudataLabel.getText();
			String account = MemoryXianShi();
			int count = 0;
			
			try {
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				String sql = "select * from stu_id_cou_key where stu_id ='"+account+"'"
						+"and stu_cou ='"+coures+"'";
				Statement statement = connection.createStatement();
				ResultSet resultSet =statement.executeQuery(sql);
				while(resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			
			
			if(count==0) {
				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				courseDaoImpl.InsertCou(account, coures);
				JOptionPane.showMessageDialog(p3, "'"+account+"'ͬѧ,��Ŀγ�' " + coures + "'��ӳɹ�������", "��Ϣ��ʾ",
						JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(p3, "����ѡ�������ſΣ������ظ�ѡ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	String MemoryXianShi() {//���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				account = resultSet.getString(1);//�������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	public static void main(String[] args) {
		new StuAddCou();
	}
	
}
