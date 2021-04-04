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

	JFrame studelcouFrame = new JFrame("删除课程");
	
	JPanel p1n, p2, p3;
	JPanel p11, p12, p13;
	
	JLabel jLabel, couLabel, periodLabel, placeLabel, coudataLabel, periodataLabel, placedataLabel;
	
	JButton upButton, downButton, deleteButton;

	int row = 1;// 代表指针，用于获取所查表的第一条记录
	int count, count1;// 用于获取表的最大记录数
	String account;

	public StuDeleteCou() {
		
		p1n = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();

		jLabel = new JLabel("你好");
		couLabel = new JLabel("课程名");
		coudataLabel = new JLabel("", 10);
		periodLabel = new JLabel("学时");
		periodataLabel = new JLabel("", 10);
		placeLabel = new JLabel("上课地点");
		placedataLabel = new JLabel("", 10);

		upButton = new JButton("上一个");
		downButton = new JButton("下一个");
		deleteButton = new JButton("删除");

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
		
		try {
			
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			
			account = MemoryXianShi();
			resultSet = courseDaoImpl.FindCreditBynumber(account);
			
			//查出非空的学生课程，再将结果想办法转入到FindCreditBynumber方法中；
			
//			int count = 0;
//			while(resultSet.next()) {
//				count++;
//			}
//			resultSet.beforeFirst();
//			System.out.println("count="+count);
//			String[] cou = new String[6];//定义一个长度为count的数组
//			cou[0]=null;
//			cou[1]=null;
//			cou[2]=null;
//			cou[3]=null;
//			cou[4]=null;
//			cou[5]=null;
//			for(int i=0;i<=count-1;i++) {//i小于等于count-1，即（0到count-1）长度为count的数组
//				resultSet.next();
//				cou[i]=resultSet.getString(3);
//			}
//			
//			System.out.println("count=" + count);
//			
//			System.out.println("q3twer=" + cou[0]);
//			System.out.println("q3twer=" + cou[1]);
//			
//			StuAndCou stuAndCou = new StuAndCou(null, cou[0], cou[1], cou[2], cou[3], cou[4], cou[5]);//每人最多选6门课
			
//			resultSet1 = courseDaoImpl.FindInformationByCou(stuAndCou);
			
			resultSet.last();
			count = resultSet.getRow();
			
			if (resultSet.absolute(row)) {
				String coures = resultSet.getString(2);
				String teaId = resultSet.getString(4);
				
				
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				resultSet1 = courseDaoImpl2.FindCouInformation(coures,teaId);
				
				resultSet1.next();//关键步骤
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
			JOptionPane.showMessageDialog(p2, "'"+account+"'学生，删除课程'"+coures+"'成功！","消息提示",JOptionPane.WARNING_MESSAGE);
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
	
	public static void main(String[] args) {
		new StuDeleteCou();
	}

}
