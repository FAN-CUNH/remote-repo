# 1. 什么是JDBC
- JDBC(Java Database Connectivity)是一个独立于特定数据库管理系统（DBMS）、通用的SQL数据库存取和操作的公共接口（一组API），定义了用来访问数据库的标准Java类库，使用这个类库可以以一种标准的方法、方便地访问数据库资源。
---
# 2. JDBC api
-  JDBC API是一系列的接口，它统一和规范了应用程序与数据库的连接、执行SQL语句，并到得到返回结果等各类操作。声明在java.sql与javax.sql包中。
---
# 3. JDBC程序编写步骤
  1. 注册驱动
  2. 获取连接
  3. 执行增删改查
  4. 释放资源
  --- 
# 4. JDBC操作步骤
  1、 加载并注册驱动
  1. 加载驱动，把驱动类加载到内存
  2. 注册驱动，把驱动类的对象交给DriverManager管理，用于后面创建连接等使用。
  3. 调用 Class 类的静态方法 forName()，向其传递要加载的 JDBC 驱动的全类名
     
    //通过反射，加载与注册驱动类，解耦合（不直接依赖）
    Class.forName("com.mysql.jdbc.Driver");

  2、 获取数据库连接对
  
    //1、加载与注册驱动		
    Class.forName("com.mysql.jdbc.Driver");				
    //2、获取数据库连接		
    String url = "jdbc:mysql://localhost:3306/test0510";	
    Connection conn = DriverManager.getConnection(url, "root", "root");
  3、 操作或访问数据库
  - 数据库连接被用于向数据库服务器发送命令和SQL语句，并接受数据库服务器返回的结果。其实一个数据库连接就是一个Socket连接。