package edu.hebeu.util;

import java.sql.Connection;

/**
 * 连接池创建测试
 * @author think
 *
 */
public class TestConectPoolFactory {

	public static void main(String[] args) {
		//创建连接池
		ConectPoolFactory cef=ConectPoolFactory.getInstance();
		//Connection conn=(Connection) cef.getConnection();
		//创建连接
        Connection conn=cef.getConnection();
        System.out.println("conn产生为:"+conn);
	}

}
