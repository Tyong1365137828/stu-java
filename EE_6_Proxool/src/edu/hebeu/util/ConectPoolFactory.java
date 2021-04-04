package edu.hebeu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

/**
 * 连接池创建、连接
 * @author gbj
 *体现点一、单例的创建(一个池子一个对象)		体现点二、连接
 */
public class ConectPoolFactory {
	private static ConectPoolFactory connectPoolFactory = null;//构造自己的对象变量，单例模式特有

	private ConectPoolFactory() {//私有构造函数，单例特有
		init();
	}
	
	public void init(){
		InputStream is=ConectPoolFactory.class.getResourceAsStream("/proxool.properties");//从proxool.properties配置文件中获取的资源变成流，这里是反射机制
		Properties properties=new Properties();
		try{
			properties.load(is);//把流放入
			PropertyConfigurator.configure(properties);//加载,链接对象，，修路，，物理连接(连接池与数据库连接)做好
		}catch(Exception e){
			
		}
	}
	
	//创建连接池
	public static ConectPoolFactory getInstance(){
		if(null==connectPoolFactory){//如果连接池为空,即第一次使用
			connectPoolFactory=new ConectPoolFactory();//生成连接池
		}
		return connectPoolFactory;//否则,即连接池不为空,直接返回
	}
	
	//创建连接
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");//变成连接池驱动
			conn=DriverManager.getConnection("proxool.DB");
		}catch(Exception e){
			
		}
		return conn;
	}

}
