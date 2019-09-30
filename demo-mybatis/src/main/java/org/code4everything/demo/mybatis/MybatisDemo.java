package org.code4everything.demo.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class MybatisDemo {

    public static void main(String[] args) {
        SqlSession sqlSession = buildSqlSessionFactoryWithoutXml().openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.selectList());
        sqlSession.close();
    }

    public static SqlSessionFactory buildSqlSessionFactoryFromXml() {
        return null;
    }

    public static SqlSessionFactory buildSqlSessionFactoryWithoutXml() {
        final String user = "practice";
        String url = "jdbc:mysql://192.168.1.234/" + user + "?useSSL=false";
        DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver", url, user, user);
        Environment environment = new Environment("development", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(DeptMapper.class);
        configuration.addInterceptor(new PageInterceptor());
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
