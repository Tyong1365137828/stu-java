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

public class StuDeleteCou implements ActionListener{
	JFrame studelcouFrame = new JFrame("ɾ���γ�");

	JPanel p1n, p2n, p3;
	JPanel p11, p12, p13;
	JPanel p21,p22,p23;
	
	JLabel jLabel, couLabel, periodLabel, placeLabel, coudataLabel, periodataLabel, placedataLabel,testLabel,testdataLabel;

	JButton upButton, downButton, deleteButton;

	int row = 1;// ����ָ�룬���ڻ�ȡ�����ĵ�һ����¼
	int count, count1;// ���ڻ�ȡ�������¼��
	String account;

	public StuDeleteCou() {
		p1n = new JPanel();
		p2n = new JPanel();
		p3 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		
		p21 = new JPanel();
		p22 = new JPanel();
		p23 = new JPanel();

		jLabel = new JLabel("���");
		couLabel = new JLabel("�ҵĿγ�");
		coudataLabel = new JLabel("", 10);
		periodLabel = new JLabel("ѧʱ");
		periodataLabel = new JLabel("", 10);
		placeLabel = new JLabel("�Ͽεص�");
		placedataLabel = new JLabel("", 10);
		testLabel = new JLabel("����ʱ��");
		testdataLabel = new JLabel("",10);
		
		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");
		deleteButton = new JButton("ɾ��");

		studelcouFrame.setLayout(new GridLayout(3, 1));

		studelcouFrame.add(p1n);
		studelcouFrame.add(p2n);
		studelcouFrame.add(p3);

		p1n.setLayout(new GridLayout(3, 1));
		p1n.add(p11);
		p1n.add(p12);
		p1n.add(p13);
		
		p2n.setLayout(new GridLayout(3,1));
		p2n.add(p21);
		p2n.add(p22);
		p2n.add(p23);

		p11.add(couLabel);
		p11.add(coudataLabel);
		p12.add(periodLabel);
		p12.add(periodataLabel);
		p13.add(placeLabel);
		p13.add(placedataLabel);
		p22.add(testLabel);
		p22.add(testdataLabel);
		p3.add(upButton);
		p3.add(downButton);
		p3.add(deleteButton);
		
		firstData();// �����Լ�����Ĳ�ѯ����
		studelcouFrame.setSize(800, 900);

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		deleteButton.addActionListener(this);

		studelcouFrame.setVisible(true);
	}
	
	private void firstData() {// ���в�ѯ�ķ���

		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		
		
//		cou1 = null, cou2 = null, cou3 = null, cou4 = null, cou5 = null, cou6 = null;
		
		try {
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditBynumber(account);
			
			resultSet.last();
			count = resultSet.getRow();
			
			if (resultSet.absolute(row)) {
				String coures = resultSet.getString(2);
				
				
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				resultSet1 = courseDaoImpl2.FindCouInformation(coures);
				
				resultSet1.next();//�ؼ�����
				String period = resultSet1.getString(3);
				String place = resultSet1.getString(4);
				String test = resultSet1.getString(5);
				System.out.println("cou" + coures);
				System.out.println("period" + period);
				
				coudataLabel.setText(coures);
				periodataLabel.setText(period);
				placedataLabel.setText(place);
				testdataLabel.setText(test);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	String MemoryXianShi() {// ���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteButton) {
			
			String coures = coudataLabel.getText();
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			courseDaoImpl.DeleteCou(coures, account);
			JOptionPane.showMessageDialog(p21, "'"+account+"'ѧ����ɾ���γ�'"+coures+"'�ɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		
		if (e.getSource().equals(upButton)) {// ������"��һ��"��ť
			row--;// ָ��ֵ��һ
			firstData();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			downButton.setEnabled(true);
			if (row <= 1) {// ��ָ��ֵС��һʱ����������ѯ�����Сָ�뻹С
				upButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
				row = 1;// ��ʱָ��ֵʼ��Ϊһ
			}
		}
		
		if (e.getSource().equals(downButton)) {// ������"��һ��"��ť
			row++;// ָ��ֵ��һ
			firstData();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			upButton.setEnabled(true);
			if (row >= count) {// ��ָ��ֵ����countֵʱ����������ѯ������ָ�뻹��
				row = count;// ��ʱָ��ֵʼ��Ϊ����ѯ������ָ��ֵcount
				downButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
			}
		}

	}
	
}
