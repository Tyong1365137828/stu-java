package dazhaohu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Work6 {
	
	JFrame frame = new JFrame();
	
	JTextField field ;
	
	JLabel jLabel;
	
	JButton button;
	
	JPanel p1,p2;
	
	public Work6() {
		
		field = new JTextField(30);
		
		jLabel = new JLabel("����:");
		
		button = new JButton("�к�");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		frame.setLayout(new GridLayout(2,1));//�Խ���ʹ��2��1�е����񲼾�
		p1.setLayout( new FlowLayout());//��p1ʹ����ʽ����
		p2.setLayout(new BorderLayout());//��p2ʹ�ñ߽粼��
		
		frame.add(p1);
		frame.add(p2);
		
		p1.add(jLabel);
		p1.add(field);
		p2.add(button);
		
		frame.setSize(400, 100);
		frame.setVisible(true);
		
		button.addMouseListener(new MouseAdapter() {//ʹ���������ķ������м���button

			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(field.getText().equals("�������")) {//�ı����ֵ�����������
					button.setText("180650223������ϲ�����������");
				}
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new Work6();
	}
	
}
