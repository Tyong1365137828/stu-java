package danci;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Work2Test {

	public static void main(String[] args) {
		new Work2();
	}

}


class Work2 extends JFrame{

	String [] danci=new String[] {"Hello","Good","What","How","Why"};

	JLabel l1=new JLabel("Hello");
	JLabel l2=new JLabel("Good");
	JLabel l3=new JLabel("What");
	JLabel l4=new JLabel("How");
	JLabel l5=new JLabel("Why");
	
	Font f=new Font(null, Font.BOLD, 100);		//新建字体大小标签的对象
	
	JButton b1;
	JButton b2;
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	CardLayout c=new CardLayout();		//为卡片布局CardLayout创建一个对象，以使容器p1引用它
	
	public Work2() {
		
		setTitle("单词浏览");
		setSize(600, 600);
		
		b1=new JButton("上一个");
		b2=new JButton("下一个");
		
		l1.setFont(f);		//l1,2,3,4,5引用字体的大小
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		
		l1.setForeground(Color.BLACK);		//给组件lable字体设置颜色
		l2.setForeground(Color.RED);
		l3.setForeground(Color.YELLOW);
		l4.setForeground(Color.BLUE);
		l5.setForeground(Color.GREEN);
		
		l1.setHorizontalAlignment(0);		//将l1，2，3，4，5的文本居中
		l2.setHorizontalAlignment(0);
		l3.setHorizontalAlignment(0);
		l4.setHorizontalAlignment(0);
		l5.setHorizontalAlignment(0);
		
		p1.setLayout(c);			//容器p1通过对象c将自身放入卡片容器
//		p1.setLayout(new CardLayout());
		
		p1.add(l1);					//l1，2，3，4，5放入p1
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);					//因为p1在卡片布局中，则l1，2，3，4，5放入是有顺序的，只不过是分次显示
		p2.add(b1);
		p2.add(b2);
			
		add(BorderLayout.CENTER,p1);
		add(BorderLayout.SOUTH,p2);
		
		MyAction m=new MyAction();		//注册监听器
		b1.addActionListener(m);		//b1引用监听器
		b2.addActionListener(m);		//b2引用监听器
		
		setVisible(true);
		
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {			//如果按b1建，则
				c.previous(p1);				//显示上一个
			}
			if(e.getSource()==b2) {			//如果按b2建，则
				c.next(p1);					//显示下一个
			}			
		}
	}
}