package org.code4everything.demo.jdbc;

import java.sql.*;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class JdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 连接数据库
        String url = "jdbc:mysql://192.168.1.234/practice?user=practice&password=practice";
        Connection connection = DriverManager.getConnection(url);

        // 创建语句声明
        Statement statement = connection.createStatement();
        // 执行查询，获取结果集
        ResultSet resultset = statement.executeQuery("select * from test_dept");
        // 打印结果
        while (resultset.next()) {
            System.out.println(resultset.getString("name"));
        }

        // 调用存储过程，参考：https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-statements-callable.html
        CallableStatement callableStatement = connection.prepareCall("{call no_procedure(?)}");
        callableStatement.setString(1, "test");

        // 获取插入时的自增值
        statement.executeUpdate("insert into test_dept(dept,name,salary) values(3,'test',3000)",
                Statement.RETURN_GENERATED_KEYS);
        resultset = statement.getGeneratedKeys();
        while (resultset.next()) {
            System.out.println("generated key: " + resultset.getInt(1));
        }
    }
}
