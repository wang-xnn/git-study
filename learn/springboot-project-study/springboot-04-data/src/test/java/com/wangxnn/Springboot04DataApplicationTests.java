package com.wangxnn;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源   class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //xxxxTemplate springboot已经配好的模板bean,拿来用即可
        // jdbc   org目录下JdbcTemplateConfiguration.java
        // redis

        //测试
        DruidDataSource druidDataSource=(DruidDataSource) dataSource;
        System.out.println("druidDataSource数据池最大连接数"+druidDataSource.getMaxActive());
        System.out.println("druidDataSource数据池初始化连接数"+druidDataSource.getInitialSize());
        //关闭连接
        connection.close();

    }

}
