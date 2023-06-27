import com.fch.bean.Score;
import com.fch.mapper.ScoreMapper;
import com.fch.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

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
}
