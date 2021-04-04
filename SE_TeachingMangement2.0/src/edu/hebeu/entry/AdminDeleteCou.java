package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;

public class AdminDeleteCou implements ActionListener{
	
	JFrame admindelecouFrame = new JFrame("ɾ���γ�");
	
	JTabbedPane showPane;
	JPanel p1, p2;
	
	/*
	 * 
	 * ��һҳ
	 * 
	 * */
	JPanel p11, p12,p13,p14,p15,p16;
	JLabel checkLabel, teaIdLabel, teaNamLabel, teaIddataLabel, teaNamdataLabel, couLabel, coudataLabel;
	
	JButton checkButton, deleteButton;
	
	JTextField checkField;
	
	public AdminDeleteCou() {
		
		showPane = new JTabbedPane();
		
		/*
		 * 
		 * 
		 * ��һҳ
		 * 
		 */
		
		p1 = new JPanel();
		
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();
		
		checkLabel = new JLabel("��ѯ�ον�ʦ���˺�");
		teaIdLabel = new JLabel("��ʦid");
		teaIdLabel.setVisible(false);
		teaIddataLabel = new JLabel("",10);
		teaNamLabel = new JLabel("��ʦ����");
		teaNamLabel.setVisible(false);
		teaNamdataLabel = new JLabel("",10);
		couLabel = new JLabel("�����γ�");
		couLabel.setVisible(false);
		coudataLabel = new JLabel("",10);
		
		checkButton = new JButton("��ѯ");
		deleteButton = new JButton("ɾ��");
		deleteButton.setVisible(false);
		
		checkField = new JTextField(10);
		
		admindelecouFrame.add(p1);
		
		p1.setLayout(new GridLayout(6,1));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
		p1.add(p15);
		p1.add(p16);
		
		p11.add(checkLabel);
		p11.add(checkField);
		p11.add(checkButton);
		p12.add(teaIdLabel);
		p12.add(teaIddataLabel);
		p13.add(teaNamLabel);
		p13.add(teaNamdataLabel);
		p14.add(couLabel);
		p14.add(coudataLabel);
		p15.add(deleteButton);
		
		showPane.addTab("��ѯ�ον�ʦ", p1);
		
		checkButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		
		/*
		 * 
		 * ��ҳ���
		 * 
		 */
		
		admindelecouFrame.add(showPane);
		admindelecouFrame.setSize(600, 800);
		
		admindelecouFrame.setVisible(true);

		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == checkButton) {
			if(checkField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p13, "����Ϊ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}else {
				
				ResultSet resultSet = null;
				
				String teaId = checkField.getText();
				
				try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				resultSet = administratorDaoImpl.JSelectTeaByNum(teaId);
				
				int count = 0;
					while(resultSet.next()) {
						count++;
					}
					if(count == 0) {
						JOptionPane.showMessageDialog(p13, "û�иý�ʦ", "������ʾ", JOptionPane.ERROR_MESSAGE);
					}else {
						
						ResultSet resultSet2 = null;
						AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
						
						resultSet2 = administratorDaoImpl2.JSelectCouByTeaNum(teaId);
						int count2 = 0;
						while(resultSet2.next()) {
							count2++;
						}
						if(count2 == 0) {
							JOptionPane.showMessageDialog(p13, "�ý�ʦû�пγ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
						}else {
							resultSet.beforeFirst();
							resultSet2.beforeFirst();
							
							resultSet.next();
							String teaNam = resultSet.getString(2);
							
							resultSet2.next();
							String couNam = resultSet2.getString(2);
							
							teaIddataLabel.setText(teaId);
							teaNamdataLabel.setText(teaNam);
							coudataLabel.setText(couNam);
							
							teaIdLabel.setVisible(true);
							teaNamLabel.setVisible(true);
							couLabel.setVisible(true);
							deleteButton.setVisible(true);
						}
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource() == deleteButton) {
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			
			String teaId = teaIddataLabel.getText();
			administratorDaoImpl.deleteCou(teaId);
			JOptionPane.showMessageDialog(p13, "ɾ���ý�ʦ�γ̳ɹ�", "������ʾ", JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	public static void main(String[] args) {
		new AdminDeleteCou();
	}
	
}
