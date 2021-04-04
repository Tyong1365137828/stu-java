package edu.hebeu.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 自定义的连接池与传统连接进行连接关闭数据库效率测试
 * @author think
 *
 */
public class TestPool {
    public static void main(String[] args) throws Exception {
    	//连接池方式--逻辑连接，用于高并发
		long start=System.currentTimeMillis();
		for(int i=0;i<1000;i++){//即做100次建立，关闭连接
			ConectPoolFactory.getInstance();//创建连接池
			Connection conn=ConectPoolFactory.getConnection();//创建连接
			conn.close();
		}
		long end=System.currentTimeMillis();
		System.out.println("逻辑连接方式耗时"+(end-start));
		System.out.println("--------");
		//物理连接方式，用于低并发
		start=System.currentTimeMillis();
		for(int i=0;i<1000;i++){//即做100次建立，关闭连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_mvc_test?serverTimezone=UTC","root","072731");
			conn1.close();
		}
		end=System.currentTimeMillis();
		System.out.println("物理连接方式耗时"+(end-start));
	}
 }
