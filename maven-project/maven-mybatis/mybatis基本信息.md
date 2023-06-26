# 一.什么是 MyBatis？
MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射

# 二.mybatis安装

``` java
<!-- maven依赖注入 -->
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis</artifactId>
  <version>3.5.13</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
<!--阿里巴巴的druid数据源-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.16</version>
</dependency>
```

# 三.mybatis的配置和使用

## 1.mybatis-config.xml文件的配置

``` java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 读取或者设置配置文件db.properties的参数 -->
    <properties resource="db.properties"></properties>

    <!--别名-->
    <typeAliases>
		<!-- 利用包名直接将bean包下所有的实体类按类名来起别名 -->
        <package name="com.sun.niit.mybatis.bean"/>
    </typeAliases>
    
    <!-- 数据库环境配置 default="development" 默认使用哪个数据库环境 -->
    <environments default="development">
        <!-- 单个环境 -->
        <environment id="development">
            <!--事务处理方式 jdbc|managed 我们一般使用jdbc来处理事务 -->
            <transactionManager type="JDBC"/>
            <!-- 数据源配置：POOLED|JNDI 使用连接池方式来操作 -->
            <dataSource type="com.sun.niit.mybatis.utils.DruidDataSourceFactory">
                <!-- 驱动 ,当我们使用druid的时候，原本的driver属性会失效，我们使用driverClassName -->
                <property name="driverClassName" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
		<!-- 自动读取当前包名下的所有XXXMapper.xml文件 -->
        <package name="com.sun.niit.mybatis.mapper"/>
    </mappers>
</configuration>
```

## 2.设置db.properties配置文件中数据库连接的参数

``` java
#8.0com.mysql.cj.jdbc.Driver
driver=com.mysql.jdbc.Driver
#8.0的注意设置时区问题serverTimeZone=UTC
#character encoding问题  设置 useUnicode=true&characterEncoding=utf8
url=jdbc:mysql:///niit_sx
username=root
password
```

## 3.创建实体类

``` java
//对应数据库要查询的表
//例如：
package com.sun.niit.mybatis.bean;

import lombok.Data;

/**
*  blog对应数据库中的blog表
*/
@Data
public class Blog {
    private Integer id;
    private String title;
    private String content;
}
```

## 4.创建对应的实体类Mapper.java文件

``` java
//接口命名一般以表名为主,例如Blog,那我们一般命名为BlogMapper
package com.sun.niit.mybatis.mapper;

import com.sun.niit.mybatis.bean.Blog;

import java.util.List;

public interface BlogMapper {
    /**
     * 查询所有Blog的方法
     * 这个方法和BlogMapper.xml中select的id值相同
     * @return
     */
    List<Blog> selectBlog();
}
```


## 5.创建对应的XXXMapper.xml映射文件
### 注意：XXXMapper.xml名字要和XXXMapper.java的名字要相同,namespace的值要和XXXMapper.java的全路径相同，id要和接口中方法名相同

``` java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace 我们需要对应mapper包中的接口对象 -->
<mapper namespace="com.sun.niit.mybatis.mapper.BlogMapper">
    <select id="selectBlog" resultType="Blog">
        select * from Blog
    </select>
</mapper>
```

## 6.由于使用了自己设置的druid的datasource，我们追加一个DruidDataSourceFactory这个类来管理数据源

``` java
package com.sun.niit.mybatis.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * 配置Druid的数据源
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }

}
```


## 7.那根据SQLSessionFactory，SQLSessionFactoryBuilder,SqlSession他们的生命周期，那我们采用单例模式来创建SQLSessionFactory的连接

``` java
package com.sun.niit.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 开启SqlSessionFactory
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory=null;

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if(sqlSessionFactory==null){
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //装配
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }

}
```

# 四.简单的测试案例

``` java
package com.sun.niit.mybatis;

import com.sun.niit.mybatis.bean.Blog;
import com.sun.niit.mybatis.mapper.BlogMapper;
import com.sun.niit.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //启用mybatis
        //我们要读取的mybatis配置文件的信息

        //装配
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //sqlSession自动帮你创建一个XXXMapper接口的实现类
            BlogMapper blogMapper=session.getMapper(BlogMapper.class);
            List<Blog> blogs=blogMapper.selectBlog();
            /*List<Blog> blogs=session.selectList("org.mybatis.example.BlogMapper.selectBlog");*/
            for (Blog blog:blogs) {
                System.out.println(blog.getTitle()+"--"+blog.getContent());
            }
        }
        
    }
}
```