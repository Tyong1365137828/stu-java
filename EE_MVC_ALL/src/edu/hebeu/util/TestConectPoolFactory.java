package edu.hebeu.util;

import java.sql.Connection;

/**
 * 自定义的连接池创建测试
 * @author think
 *
 */
public class TestConectPoolFactory {

	public static void main(String[] args) {
		//创建连接池
		ConectPoolFactory.getInstance();
		//Connection conn=(Connection) cef.getConnection();
		//创建连接
        Connection conn=ConectPoolFactory.getConnection();
        System.out.println("创建连接为:"+conn);
	}

}
