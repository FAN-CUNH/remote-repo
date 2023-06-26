# SQL语句中参数传递的五种方法

    通过Mybatis的使用，开发人员只需要专心提供SQL语句即可，这篇文章介绍了SQL语句中参数传递的问题。大致有以下几种方式：

## 1. 单个参数传递
   ```
   // 在接口中定义放法，参数形式如下
   // 使用单个参数
   Student selectById(int id);
 
<!--
    使用单个参数查询：
    parameterType：表示参数数据类型（可不写）
    使用  #{参数名} 获取参数的值
    对参数名称无要求
-->
<select id="selectById" parameterType="int" resultType="cn.krain.domain.Student">
    select * from student where id = #{id}
</select>

// 调用方法时只需要传入相应类型的单个值即可
Student student = dao.selectById(2);
```

## 2.使用@param为参数命名传递多个参数
```
/**  在接口文件的对应方法形参中，使用以下格式进行命名
 *   多个参数：为参数命名，在形参前加上  @Param("自定义参数名")
 * /
List<Student> selectMultiParam(@Param("myname") String name,
                                @Param("myage") Integer age);

// 调用时传入对应的参数值
List<Student> students = dao.selectMultiParam("康康",23);

<!--
    多个参数：使用param命名 使用为参数起得名称 eg：#{命名}
-->
<select id="selectMultiParam" resultType="cn.krain.domain.Student">
    select * from student where name=#{myname} or age=#{myage}
</select>
```

## 3. 使用Java对象作为方法的参数
```
// 在接口中定义放法，参数形式如下
// 多个参数：使用java对象作为方法的参数
List<Student> selectMultiObject(QueryParam queryParam);

<!--
    多个参数：使用java对象的属性值作为参数实际值
    原始语法：#{属性名, javaType=java中类型名称, jdbcType=数据库中的类型名}
    eg:  #{queryName, javaType=String, jdbcType=Varchar}
        #{queryAge, javaType=Integer, jdbcType=Integer}
    简写：#{属性名}
-->
<select id="selectMultiObject" resultType="cn.krain.domain.Student">
    select * from student where name=#{queryName} or age=#{queryAge}
</select>

// 调用时传入相应对象
List<Student> students = dao.selectMultiObject(queryParam);
```

## 4. 使用位置传参
```
// 在方法的参数中，形参的顺序对应映射文件中参数的顺序，arg0指形参中第一个值，arg1代表第二个，以此类推。
// 在接口中定义放法，参数形式如下
// 多个参数：使用位置传参
List<Student> selectMultiPosition(String name, Integer age);

<!--根据参数位置传参    arg后面的数字代表参数所在的位置-->
<select id="selectMultiPosition" resultType="cn.krain.domain.Student">
    select * from student where name=#{arg0} or age=#{arg1}
</select>

//调用代码
List<Student> students = dao.selectMultiPosition("康康", 23);
```

## 5. 使用map传参
```
// 在接口中定义放法，参数形式如下
// 使用Map传递多个参数
List<Student> selectMultiMap(Map<String, Object> map);

<!--使用Map键值对传参，形式：#{key名}-->
<select id="selectMultiMap" resultType="cn.krain.domain.Student">
    select * from student where name=#{mapName} or age=#{mapAge}
</select>

// 调用
Map<String,Object> data = new HashMap<String,Object>();
data.put("mapName","krain");
data.put("mapAge",23);
List<Student> students = dao.selectMultiMap(data);
```