package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.po.Student;

public class UserDelete {
    /*
	public static void main(String[] args) {
		new DeleteFrame();

	}
	*/

}

class DeleteFrame implements ActionListener {
	JFrame frame = new JFrame("删除学生页面");
	JButton queryButton, deleteButton, restButton;
	JLabel queryLable;
	JTextField queryText;
	JPanel p1, p2, p3, p4, p5, p6, p7;
	JLabel numLable, nameLable, deptLable;
	JLabel numText, nameText, deptText;

	public DeleteFrame() {

		queryLable = new JLabel("请输入要查询的学号：");
		queryText = new JTextField(15);
		queryButton = new JButton("查询");
		queryButton.addActionListener(this);
		deleteButton = new JButton("删除");
		deleteButton.addActionListener(this);
		deleteButton.setVisible(false);
		restButton = new JButton("重置");
		restButton.addActionListener(this);
		restButton.setVisible(false);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();

		p2.add(queryLable);
		p2.add(queryText);
		p2.add(queryButton);
		p6.add(deleteButton);
		p6.add(restButton);

		numLable = new JLabel();
		numText = new JLabel();
		nameLable = new JLabel();
		nameText = new JLabel();
		deptLable = new JLabel();
		deptText = new JLabel();

		p3.add(numLable);
		p3.add(numText);
		p4.add(nameLable);
		p4.add(nameText);
		p5.add(deptLable);
		p5.add(deptText);

		frame.setLayout(new GridLayout(7, 1));

		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		frame.add(p5);
		frame.add(p6);
		frame.add(p7);

		// frame.add(queryButton);
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(queryButton)) {
			if (queryText.getText().length() == 0) {
				JOptionPane.showMessageDialog(frame, "输入不能为空！", "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String num = queryText.getText();
				UserDaoImpl userDao = new UserDaoImpl();
				Student stu = userDao.findUserByNum(num);
				System.out.println(stu.getSno());
				if (stu.getSno() != null) {
					numLable.setText("学号：");
					nameLable.setText("姓名：");
					deptLable.setText("系部：");
					numText.setText(stu.getSno());
					nameText.setText(stu.getSname());
					deptText.setText(stu.getSdept());

					deleteButton.setVisible(true);
					restButton.setVisible(true);
					userDao.close();
				} else {
					JOptionPane.showMessageDialog(frame, "查无此人", "警告提示框",
							JOptionPane.WARNING_MESSAGE); // 给出提示信息
				}
			}

		}
		if (e.getSource().equals(deleteButton)) {
			String num = queryText.getText();
			UserDaoImpl userDao = new UserDaoImpl();
			Object [ ]options={"ok","cancle"};
			int n=JOptionPane.showOptionDialog(null,"click ok to continue",	"warning",JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE,null,
				options,options[0]);
            if(n==0){
			userDao.deleteUser(num);
			userDao.close();
			JOptionPane.showMessageDialog(frame, "删除成功！", "",
					JOptionPane.CLOSED_OPTION);
			
            }
		}
		
		if (e.getSource().equals(restButton)) {
			queryText.setText("");
			numLable.setText("");
			nameLable.setText("");
			deptLable.setText("");
			numText.setText("");
			nameText.setText("");
			deptText.setText("");
		}
	}

}
