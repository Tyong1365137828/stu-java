package edu.hebeu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

/**
 * 连接池创建、连接
 * @author think
 *
 */
public class ConectPoolFactory {
	private static ConectPoolFactory connectPoolFactory = null;

	private ConectPoolFactory() {
		init();
	}
	
	public void init(){
		InputStream is=ConectPoolFactory.class.getResourceAsStream("/proxool.properties");
		Properties properties=new Properties();
		try{
			properties.load(is);
			PropertyConfigurator.configure(properties);
		}catch(Exception e){
			
		}
	}
	
	//创建连接池
	public static ConectPoolFactory getInstance(){
		if(null==connectPoolFactory){
			connectPoolFactory=new ConectPoolFactory();//生成连接池
		}
		return connectPoolFactory;
	}
	
	//创建连接
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.DB");
		}catch(Exception e){
			
		}
		return conn;
	}

}
