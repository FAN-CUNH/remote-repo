import com.fch.bean.Score;
import com.fch.mapper.ScoreMapper;
import com.fch.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @packageName PACKAGE_NAME
 * @ClassName ScoreTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/27 11:45
 * @Version 1.0
 */
public class ScoreTest {
    @Test
    public void selectAllMess() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装载
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            //3. 调用 scoreMapper 的方法
            List<Score> scores = scoreMapper.selectAll();

            //4. 输出结果
            scores.forEach(System.out::println);
        }
    }

    @Test
    public void insert() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装载
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            //3. 调用 scoreMapper 的方法
            List<Score> scores = Arrays.asList(
                    new Score("006", "003", "001", 80, null),
                    new Score("007", "003", "002", 80, null),
                    new Score("008", "003", "003", 80, null));
            scoreMapper.insert(scores);

            //4. 提交结果
            session.commit();
        }
    }

    @Test
    public void deleteByScoNos() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装载
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            //3. 调用 scoreMapper 的方法
            List<String> scoNos = Arrays.asList("006", "007", "008");
            scoreMapper.deleteByScoNos(scoNos);

            //4. 提交结果
            session.commit();
        }
    }

    @Test
    public void selectByCondition() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装载
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            //3. 调用 scoreMapper 的方法
            List<Score> scores = scoreMapper.selectByCondition("001", "001");

            //4. 输出结过
            scores.forEach(System.out::println);
        }
    }

    @Test
    public void updateByScoNo() {
        //0. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        //1. 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //2. 自动装载
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            //3. 调用 scoreMapper 的方法
            scoreMapper.updateByScoNo(new Score("001", null, null, 100, null));

            //4. 提交
            session.commit();
        }
    }
}
