package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.UserDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User findUserByNameAndPassword(String username, String password) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		User user=null;
		try {
			// 加载驱动、获取连接
	        conn=new GetConn().getConnection();
			//建立命令发送器（小车）
			stmt=conn.createStatement();
			//发送命令并得到结果
			rs=stmt.executeQuery("select * from user_11 where "
					+ "usename='"+username+"' and password='"+password+"'");
			//"select * from user_11 where username='"+admin+"' and password='"+00000+"'"";
			//处理结果
			if(rs.next()){
				String name=rs.getString("usename");
				String pwd=rs.getString("password");
				user=new User(name,pwd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//返回内容
		return user;
	}

}
