package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import edu.hebeu.dao.UserDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Student;
import edu.hebeu.po.User;

/**
 * @author gong
 *
 */
public class UserDaoImpl implements UserDao{
	private Connection conn;
	
	Vector<Object> userVect;// 声明一个向量对象
	ResultSet rs;
	
	public UserDaoImpl() {
		
		conn=new GetConn().getConnection();
		if(conn!=null){
			System.out.println("数据库连接成功！");
		}
	}

	@Override
	public User findUserByNameAndPassword(User user) {
		//GetConn getConn = new GetConn();						//创建包含有数据库连接类对象
		//Connection connection = getConn.getConnection();		//获取数据库连接
		PreparedStatement statement=null;
		User user12 = null;
		String sql = "select * from user_11 where usename=? and password = ?"; // 定义数据查询SQL语句
			try {
				statement=conn.prepareStatement(sql);
				//PreparedStatement statement = connection.prepareStatement(sql); // 创建PreparedStatement对象
				statement.setString(1, user.getUsename()); // 设置SQL语句参数
				statement.setString(2, user.getPassword());
				ResultSet rest = statement.executeQuery(); // 执行查询SQL语句，获取查询SQL结果集
				while (rest.next()) { // 循环遍历查询结果集
					user12 = new User();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user12; // 返回Users对象
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public Vector findUserByName(String name) {
		userVect=new Vector<Object>();
		try{
	    
		Statement stmt = conn.createStatement();
		String sql="select * from user_11 where usename like '%"+name+"%'";
		//String sql = "select * from tb_books where book_date like '2009%'";
		ResultSet rs = stmt.executeQuery(sql);
		userVect.removeAllElements();// 初始化向量对象
		//user_table_model.fireTableStructureChanged();// 更新表格内容
		while (rs.next()) {
			Vector rec_vector = new Vector();
			// 从结果集中取数据放入向量rec_vector中
			rec_vector.addElement(rs.getString(1));
			rec_vector.addElement(rs.getString(2));
			
			userVect.addElement(rec_vector);// 向量rec_vector加入向量vect中
		}
		//user_table_model.fireTableStructureChanged();
	} catch (Exception e) {
    }
		return userVect;
    }
	@Override
	public ResultSet findUserByNameResult(String name) {
		
		try {
			Statement stmt = conn.createStatement();
			String sql="select * from user_11 where usename like '%"+name+"%'";
			//String sql = "select * from tb_books where book_date like '2009%'";
			rs = stmt.executeQuery(sql);
			
			
			/*
			while(rs.next()){
				System.out.println("000000");
			}*/
		}catch(SQLException e){
			
		}
		return rs;
	}

	@Override
	public int insertUser(User user) {
		int count=0;
		//Connection conn=new GetConn().getConnection();
		String sql="insert into user_11 values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsename());
			ps.setString(2, user.getPassword());
			count=ps.executeUpdate();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void deleteUser(String number) {
		PreparedStatement statement = null;
		String sql = "delete  from studen1t where sno=?"; // 定义数据查询SQL语句
			try {
				PreparedStatement ps = conn.prepareStatement(sql); // 创建PreparedStatement对象
				ps.setString(1, number); // 设置SQL语句参数
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void updateUser(String name,String password) {
		String sql="update user_11 set password='"+password+"'"+" where usename=?";
		//String sql = "update _user set gongzi = gongzi +200 where" + " name = '" + department + "'";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student findUserByNum(String sno) {
		Student stu=new Student();
		String sql = "select * from studen1t where sno=? "; // 定义数据查询SQL语句
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			//PreparedStatement statement = connection.prepareStatement(sql); // 创建PreparedStatement对象
			statement.setString(1, sno); // 设置SQL语句参数
			ResultSet rest = statement.executeQuery(); // 执行查询SQL语句，获取查询SQL结果集
			while (rest.next()) { // 循环遍历查询结果集
				stu.setSno(rest.getString(1));
				stu.setSname(rest.getString(2));
				stu.setSdept(rest.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}
	
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void main(String[] args) {
		UserDaoImpl a=new UserDaoImpl();
		a.findUserByNameResult("a");
	}*/

}
