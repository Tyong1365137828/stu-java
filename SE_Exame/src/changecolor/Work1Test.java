package changecolor;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Work1Test {

	public static void main(String[] args) {
		new Work1();
	}

}

class Work1 extends JFrame {

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	JTextField t1;
	JTextField t2;
	JTextField t3;

	public Work1() {

		setTitle("合成颜色");
		setSize(600, 300);
		setLayout(new GridLayout(4, 1));

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);

		JLabel l1 = new JLabel("Red");
		JLabel l2 = new JLabel("Green");
		JLabel l3 = new JLabel("Blue");

		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		setVisible(true);

		MyListener m = new MyListener();
		t3.getDocument().addDocumentListener(m);
		
	}

	class MyListener implements DocumentListener {//生成一个个类中类
	
		@Override
		public void insertUpdate(DocumentEvent e) {
			int a = Integer.parseInt(t1.getText());			//获得文本框的值并将其转换为int型
			int b = Integer.parseInt(t2.getText());
			int c = Integer.parseInt(t3.getText());

			p2.setBackground(new Color(a, b, c));			//将此前的值作为背景颜色参数做出反应
			p3.setBackground(new Color(a, b, c));
			p4.setBackground(new Color(a, b, c));
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}

	}
}
