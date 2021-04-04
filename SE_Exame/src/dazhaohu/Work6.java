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
		
		jLabel = new JLabel("姓名:");
		
		button = new JButton("招呼");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		frame.setLayout(new GridLayout(2,1));//对界面使用2行1列的网格布局
		p1.setLayout( new FlowLayout());//对p1使用流式布局
		p2.setLayout(new BorderLayout());//对p2使用边界布局
		
		frame.add(p1);
		frame.add(p2);
		
		p1.add(jLabel);
		p1.add(field);
		p2.add(button);
		
		frame.setSize(400, 100);
		frame.setVisible(true);
		
		button.addMouseListener(new MouseAdapter() {//使用适配器的方法进行监听button

			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(field.getText().equals("软件工程")) {//文本框的值等于软件工程
					button.setText("180650223汤勇我喜爱软件开发！");
				}
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new Work6();
	}
	
}
