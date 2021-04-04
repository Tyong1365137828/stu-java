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
	JFrame studelcouFrame = new JFrame("删除课程");

	JPanel p1n, p2n, p3;
	JPanel p11, p12, p13;
	JPanel p21,p22,p23;
	
	JLabel jLabel, couLabel, periodLabel, placeLabel, coudataLabel, periodataLabel, placedataLabel,testLabel,testdataLabel;

	JButton upButton, downButton, deleteButton;

	int row = 1;// 代表指针，用于获取所查表的第一条记录
	int count, count1;// 用于获取表的最大记录数
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

		jLabel = new JLabel("你好");
		couLabel = new JLabel("我的课程");
		coudataLabel = new JLabel("", 10);
		periodLabel = new JLabel("学时");
		periodataLabel = new JLabel("", 10);
		placeLabel = new JLabel("上课地点");
		placedataLabel = new JLabel("", 10);
		testLabel = new JLabel("考试时间");
		testdataLabel = new JLabel("",10);
		
		upButton = new JButton("上一个");
		downButton = new JButton("下一个");
		deleteButton = new JButton("删除");

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
		
		firstData();// 调用自己定义的查询方法
		studelcouFrame.setSize(800, 900);

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		deleteButton.addActionListener(this);

		studelcouFrame.setVisible(true);
	}
	
	private void firstData() {// 进行查询的方法

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
				
				resultSet1.next();//关键步骤
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
	
	
	String MemoryXianShi() {// 将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// 将是数据库表中的最后一条记录
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
			JOptionPane.showMessageDialog(p21, "'"+account+"'学生，删除课程'"+coures+"'成功！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		
		if (e.getSource().equals(upButton)) {// 如果点击"上一个"按钮
			row--;// 指针值减一
			firstData();// 调用自定义的查询方法，以将row值引用
			downButton.setEnabled(true);
			if (row <= 1) {// 当指针值小于一时，即比所查询表的最小指针还小
				upButton.setEnabled(false);// 此时"上一个"按钮不可选中
				row = 1;// 此时指针值始终为一
			}
		}
		
		if (e.getSource().equals(downButton)) {// 如果点击"下一个"按钮
			row++;// 指针值加一
			firstData();// 调用自定义的查询方法，以将row值引用
			upButton.setEnabled(true);
			if (row >= count) {// 当指针值大于count值时，即比所查询表的最大指针还大
				row = count;// 此时指针值始终为所查询表的最大指针值count
				downButton.setEnabled(false);// 此时"上一个"按钮不可选中
			}
		}

	}
	
}
