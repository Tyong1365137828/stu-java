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

public class StuDeleteCou implements ActionListener {

	JFrame studelcouFrame = new JFrame("ɾ���γ�");
	
	JPanel p1n, p2, p3;
	JPanel p11, p12, p13;
	
	JLabel jLabel, couLabel, periodLabel, placeLabel, coudataLabel, periodataLabel, placedataLabel;
	
	JButton upButton, downButton, deleteButton;

	int row = 1;// ����ָ�룬���ڻ�ȡ�����ĵ�һ����¼
	int count, count1;// ���ڻ�ȡ�������¼��
	String account;

	public StuDeleteCou() {
		
		p1n = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();

		jLabel = new JLabel("���");
		couLabel = new JLabel("�γ���");
		coudataLabel = new JLabel("", 10);
		periodLabel = new JLabel("ѧʱ");
		periodataLabel = new JLabel("", 10);
		placeLabel = new JLabel("�Ͽεص�");
		placedataLabel = new JLabel("", 10);

		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");
		deleteButton = new JButton("ɾ��");

		studelcouFrame.setLayout(new GridLayout(3, 1));

		studelcouFrame.add(p1n);
		studelcouFrame.add(p2);
		studelcouFrame.add(p3);

		p1n.setLayout(new GridLayout(3, 1));
		p1n.add(p11);
		p1n.add(p12);
		p1n.add(p13);

		p11.add(couLabel);
		p11.add(coudataLabel);
		p12.add(periodLabel);
		p12.add(periodataLabel);
		p13.add(placeLabel);
		p13.add(placedataLabel);
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
		
		try {
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditBynumber(account);
			
			//����ǿյ�ѧ���γ̣��ٽ������취ת�뵽FindCreditBynumber�����У�
			
//			int count = 0;
//			while(resultSet.next()) {
//				count++;
//			}
//			resultSet.beforeFirst();
//			System.out.println("count="+count);
//			String[] cou = new String[6];//����һ������Ϊcount������
//			cou[0]=null;
//			cou[1]=null;
//			cou[2]=null;
//			cou[3]=null;
//			cou[4]=null;
//			cou[5]=null;
//			for(int i=0;i<=count-1;i++) {//iС�ڵ���count-1������0��count-1������Ϊcount������
//				resultSet.next();
//				cou[i]=resultSet.getString(3);
//			}
//			
//			System.out.println("count=" + count);
//			
//			System.out.println("q3twer=" + cou[0]);
//			System.out.println("q3twer=" + cou[1]);
//			
//			StuAndCou stuAndCou = new StuAndCou(null, cou[0], cou[1], cou[2], cou[3], cou[4], cou[5]);//ÿ�����ѡ6�ſ�
			
//			resultSet1 = courseDaoImpl.FindInformationByCou(stuAndCou);
			
			resultSet.last();
			count = resultSet.getRow();
			
			if (resultSet.absolute(row)) {
				String coures = resultSet.getString(2);
				String teaId = resultSet.getString(4);
				
				
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				resultSet1 = courseDaoImpl2.FindCouInformation(coures,teaId);
				
				resultSet1.next();//�ؼ�����
				String period = resultSet1.getString(3);
				String place = resultSet1.getString(4);
				System.out.println("cou" + coures);
				System.out.println("period" + period);
				
				coudataLabel.setText(coures);
				periodataLabel.setText(period);
				placedataLabel.setText(place);
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
			JOptionPane.showMessageDialog(p2, "'"+account+"'ѧ����ɾ���γ�'"+coures+"'�ɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
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
	
	public static void main(String[] args) {
		new StuDeleteCou();
	}

}
