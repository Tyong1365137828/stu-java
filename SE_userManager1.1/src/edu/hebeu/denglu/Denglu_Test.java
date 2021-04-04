package edu.hebeu.denglu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//这是登录的一个思路，也是写sql程序的思路，可参照。思路清晰才能写数据库应用程序，
//涉及到数据来源--去哪处理(哪个方法中，需要代入什么参数，你就给人家什么类型的参数)---处理结果是什么（方法返回值类型）---谁用这个结果、在哪用结果
//各种SQL语句的写法（数据库操作过程：连接---车---sql语句---执行）
//User类与表对应
//GetConn类是连接数据的类，自己定的，具有通用性
public class Denglu_Test {

	public static void main(String[] args) {
        new Denglu_frame();		

	}

}
//这是基本类的设计，里面包括很多方法，为了简化，很多情况把有些方法就拿出去了，放在一个新类中
//你上课看到的就是拿出去了findUsers方法，以后还会有很多查询、删除、增加、更新等要求，都是把这些从主程序中拿出去了
//目的：程序结构简单，分模块处理，宜于合作、检查、升级维护，与不同的界面配合数据，如输入界面。
class Denglu_frame {
	JFrame frame=new JFrame();//界面的底
	JTextField t1;//定义组件
	JTextField t2;//定义组件
	JButton b1;
	JButton b2;
	//1.构造方法，生成界面
	public Denglu_frame() {
		frame.setSize(500, 200);
		
		//生成组件对象
		t1=new JTextField(15);
		t2=new JTextField(15);
		b1=new JButton("确定");
		//事件处理，包括注册、执行方法一体化，即第4种方法。
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//代码量大时，把代码写入一个方法，在此处调用方法
				enterjButtonActionPerformed(e);//在后面定义
				
			}
		});
		b2=new JButton("重置");
		//以下为加入界面，自己完成
		
		frame.setVisible(true);
	}
	
	//2.打包（要查询）数据，准备往车上（Statement、PreparedStatement）放，准备送入数据库
	//下面模拟一个用户名、密码，后期要从界面上取出来，即输入的两个值
	User user=new User("admin", "123456");
	
	//3.建立数据库的通道conn，这是进入数据库的必由之路，通过自己定义的GetConn类的某个方法获得。
	//此方法可以被多处重复利用，否则就得从加载数据库驱动开始，重复写这一部分代码
	GetConn getconn=new GetConn();//生成该类的一个对象 
	//调用该类中的方法，得到连接，即通道，然后就可以在此通道上执行任何数据库的操作了。
	Connection conn=getconn.getConnection();
	
	//4.写查询的SQL语句，执行查询，看看库中是否有此用户，因为这个过程代码较多，因此多写入一个方法中
	//既然是方法，就要考虑返回值、参数。对于查询特定用户，只存在有、没有两种情况，因此返回值用生成一个用户
	//的方式来证明，做标志。如果生成了用户对象，就说明在库中存在该用户，如果没有生成，则说明没有该用户。
	//方法参数采用封装好的user传入
	public User findUsers(User users) { // 以Users作为参数
		String sql = "select * from user_11 where usename=? and password = ?"; // 定义数据查询SQL语句
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			//PreparedStatement statement = connection.prepareStatement(sql); // 创建PreparedStatement对象
			statement.setString(1, users.getUsename()); // 设置SQL语句参数
			statement.setString(2, users.getPassword());
			ResultSet rest = statement.executeQuery(); // 执行查询SQL语句，获取查询SQL结果集
			while (rest.next()) { // 循环遍历查询结果集
				user = new User();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user; // 返回Users对象,从库中进行查询后，把此信息传回主程序
		
	}
	
	//5.根据传回来的user的存在与否来判断用户是否合法
	//由于过程代码也比较多，因此该部分内容也写入一个方法
	public void enterjButtonActionPerformed(ActionEvent evt) {
		//FindUsers findUsers = new FindUsers(); // 创建包含有按用户名与密码检索用户类对象
		// 用户是否输入"用户名"与"密码",如果是空值，则提示输入
		if (t1.getText().equals("") || (String.valueOf(t2.getText()).equals(""))) {
			// 给出提示信息 
			return; // 退出程序
		} else {
			//下面注释的是封装查询数据，即第2步
			//第3步，是通用过程，只要有数据库操作，就要用到该步
//			User user = new User(); // 创建与数据表对应的Java Bean类User对象
//			user.setUsename(String.valueOf(t1.getText())); // 设置该对象的用户名属性
//			user.setPassword(String.valueOf(t2.getText())); // 创建该对象的密码属性
			User users = findUsers(user); // 调用检索用户方法，即第4步
			if ((users != null)) { // 如果检索出的用户不为null并且编号不为0   第5步
				//正确后要做什么
				//new Zjm();//调入新界面
				frame.dispose();//原界面消失
			} else {
				// 给出提示信息
			}
		}

	}
}
