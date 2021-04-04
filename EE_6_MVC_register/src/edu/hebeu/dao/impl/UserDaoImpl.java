package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import edu.hebeu.dao.UserDao;
import edu.hebeu.entity.User;
import edu.hebeu.util.DBUtils;

public class UserDaoImpl implements UserDao {

	private Connection conn = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;
	private Statement statement = null;

	public UserDaoImpl() {
		conn = DBUtils.getConnection();
	}

	@Override
	public User FindAllByIdAndPasswd(String id, String passwd) {
		User user = null;

		try {
			String sql = "select * from user where num='" + id + "' and password='" + passwd + "'";
			statement = conn.prepareStatement(sql);

			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 最后关闭连接
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}

		return user;
	}

	@Override
	public int save(User user){
//
		int n = 0;

		try {
			String sql = "insert into user (num,name,password,age,score,registerdate,hobbies) values (?,?,?,?,?,?,?)";
			prepareStatement = conn.prepareStatement(sql);

			prepareStatement.setString(1, user.getNum());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setInt(4, user.getAge());
			prepareStatement.setDouble(5, user.getScore());
			prepareStatement.setDate(6, (java.sql.Date) user.getRegisterdate());
			prepareStatement.setString(7, user.getHobbies());

			n = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 最后关闭连接
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return n;
		
	}

}
