package edu.hebeu.jdbc;

import java.sql.*;

/**
 * 程序的耦合：
 *      耦合：指程序之间的依赖关系；包括 类之间的依赖、方法间的依赖；
 *      解耦：降低程序间的依赖关系；
 *          解耦的思路：
 *              在实际开发中，应该做到编译期不依赖，运行时依赖；
 *              第一步、通过反射机制来创建对象，而避免使用 new关键字；
 *              第二步、通过读取配置文件 来获取创建的对象 的全限定类名；
 *
 */
public class JDBCDemo {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            // 1、注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // 2、获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy_spring", "root", "072731");

            // 3、获取操作数据库的预处理对象
            statement = connection.createStatement();

            // 4、执行SQL语句
            String sql = "SELECT id, name, money FROM account;";

            // 5、处理查询结果集(DQL语句才有这一步)
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double money = resultSet.getDouble("money");

                System.out.println("id = " + id + ", name = " + name + ", money = " + money + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
