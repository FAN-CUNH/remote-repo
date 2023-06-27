import com.fch.bean.Student;
import com.fch.mapper.StudentMapper;
import com.fch.utils.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * @packageName PACKAGE_NAME
 * @ClassName StudentTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/26 16:37
 * @Version 1.0
 */

@Slf4j
public class StudentTest {

    @Test
    public void selectAllStudent() {
        //0. 获取 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取sqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用 Mapper接口的方法
            List<Student> students = studentMapper.selectAllStudent("stu_no");

            //4. 输出结果
            students.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selectByStuNo() {
        //0. 获取 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用Mapper接口方法
            Student student = studentMapper.selectByStuNo("001");

            //4. 输出查询结果
            log.info("查询到的学生信息：{}", student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertStudent() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用Mapper接口方法
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = simpleDateFormat.parse("1998-11-12");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            //studentMapper.insertStudent(new Student("003", "123456", "王二", 25, date));

            //4. 提交事务
            session.commit();
        }
    }


    @Test
    public void deleteByStuNo() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用Mapper接口方法
            studentMapper.deleteByStuNo("003");

            //4. 提交事务
            session.commit();
        }
    }

    @Test
    public void updateByStuNo() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用Mapper接口方法
            try {
                // 格式化字符串成日期
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse("2000-11-12");

                // java.sql.Date sql包下的Data类型 调用valueOf方法
                java.sql.Date date1 = java.sql.Date.valueOf("2000-11-12");
                //studentMapper.updateByStuNo(new Student("002", "0001", "lisi", 23, date1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //4. 提交事务
            session.commit();
        }
    }

    @Test
    public void selectAllMess() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装配 Mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            //3. 调用Mapper接口方法
            List<Student> students;
            try {
                students = studentMapper.selectAllMess();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //4. 输出结果
            students.forEach(System.out::println);
        }
    }
}
