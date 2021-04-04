package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.AdmDao;
import edu.hebeu.entity.Administrator;
import edu.hebeu.util.ConectPoolFactory;

public class AdmDaoImpl implements AdmDao{
	private Connection conn = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;
	private Statement statement = null;
//	private ConectPoolFactory connectPoolFactory=ConectPoolFactory.getInstance();//创建连接池
	
	public AdmDaoImpl() {
		ConectPoolFactory.getInstance();//创建连接池
		conn = ConectPoolFactory.getConnection();//static方法.直接用类产生连接
	}

	
	@Override
	public Administrator FindAllByNumAndPasswd(String num, String passwd) {
		Administrator administrator = null;
		
		String sql = "select * from administrator where num='"+num+"'and password='"+passwd+"'";
		
		try {
			statement=conn.prepareStatement(sql);
			
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()){
				String num_impl = resultSet.getString(1);
				String pwd_impl = resultSet.getString(2);
				String name_impl = resultSet.getString(3);
				
				administrator = new Administrator(num_impl,pwd_impl,name_impl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConectPoolFactory.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return administrator;
	}

	@Override
	public int save(Administrator administrator) {
		// TODO Auto-generated method stub
		return 0;
	}

}
