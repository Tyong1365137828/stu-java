package edu.hebeu.tang3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Work2 {

	public static void main(String[] args) {
		new Work2();
	}
	
	JFrame frame = new JFrame("求两数平均数");
	
	JPanel p1 , p2 , p3 , p4;
	JLabel number1Label , number2Label , resultLabel;
	
	JTextField number1Field , number2Field , resultField;
	
	JButton jisuanButton;
	
	public Work2() {
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
	
		number1Label = new JLabel("第一个整数");
		number2Label = new JLabel("第二个整数");
		resultLabel = new JLabel("两数平均值");
		
		number1Field = new JTextField(15);
		number2Field = new JTextField(15);
		resultField = new JTextField(15);
		
		jisuanButton = new JButton("计算");
		
		jisuanButton.setPreferredSize(new Dimension(600,150));
		
		frame.setLayout(new GridLayout(4,1));
		
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		
		p1.add(number1Label);
		p1.add(number1Field);
		p2.add(number2Label);
		p2.add(number2Field);
		p3.add(resultLabel);
		p3.add(resultField);
		p4.add(jisuanButton);
		
		frame.setSize(600, 600);
		frame.setVisible(true);
		
		jisuanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int a = Integer.parseInt(number1Field.getText());
				int b = Integer.parseInt(number2Field.getText());
				
				double c = (a+b)/2;
				
				resultField.setText(String.valueOf(c));
				
			}
		});
		
		
	}
}


