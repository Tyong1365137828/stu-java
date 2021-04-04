package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;

public class AdmAddStu implements ActionListener{
	
	JFrame addFrame = new JFrame("���ѧ������");
	
	JLabel idLabel , passwordLabel;
	
	JTextField idField , passwordField;
	
	JButton addButton ;
	
	JPanel p1,p2,p3;
	
	public AdmAddStu() {
		
		idLabel = new JLabel("�˺�");
		passwordLabel = new JLabel("����");
		
		idField = new JTextField(15);
		passwordField = new JTextField(15);
		
		addButton = new JButton("���");
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		addFrame.setLayout(new GridLayout(3,1));
		
		p1.add(idLabel);
		p1.add(idField);
		p2.add(passwordLabel);
		p2.add(passwordField);
		p3.add(addButton);
		
		addFrame.add(p1);
		addFrame.add(p2);
		addFrame.add(p3);
		
		addFrame.setBounds(250, 350, 550, 400);
		addFrame.setVisible(true);
		
		addButton.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			if(idField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "�˺ſ�����Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}else if(passwordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "���������Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}else {
				String id = idField.getText();
				String password = passwordField.getText();
				
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				
				administratorDaoImpl.AddStu(id, password);
				
				JOptionPane.showMessageDialog(p2, "idΪ'"+id+"'��ѧ������ӳɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
}
