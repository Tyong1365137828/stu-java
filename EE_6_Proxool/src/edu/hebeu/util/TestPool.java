package edu.hebeu.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库连接池效率测试
 * @author think
 *
 */
public class TestPool {
    public static void main(String[] args) throws Exception {
    	//连接池方式--逻辑连接，用于高并发
		long start=System.currentTimeMillis();
		for(int i=0;i<100;i++){//即做100次建立，关闭连接
			Connection conn=ConectPoolFactory.getInstance().getConnection();
			conn.close();
		}
		long end=System.currentTimeMillis();
		System.out.println("逻辑连接方式耗时"+(end-start));
		System.out.println("--------");
		//物理连接方式，用于低并发
		start=System.currentTimeMillis();
		for(int i=0;i<100;i++){//即做100次建立，关闭连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/webtest?serverTimezone=UTC","root","072731");
			conn1.close();
		}
		end=System.currentTimeMillis();
		System.out.println("物理连接方式耗时"+(end-start));
	}
 }
