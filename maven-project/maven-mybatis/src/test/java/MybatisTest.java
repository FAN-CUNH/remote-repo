import com.fch.bean.Blog;
import com.fch.mapper.BlogMapper;
import com.fch.utils.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @packageName PACKAGE_NAME
 * @ClassName Mybatis
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/25 10:54
 * @Version 1.0
 */
@Slf4j
public class MybatisTest {
    @Test
    public void mybatis() {
        // 读取 mybatis 配置文件
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 反射创建blog类对象
            //List<Blog> blogs = session.selectList("com.fch.mapper.BlogMapper.selectBlog");

            // sqlSession 自动帮你创建一个XXXMapper接口的实现类
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);

            // 插入

            // 第一种
            // blogMapper.insertBlog(new Blog(1, "标题一", "内容一"));

            // 第二种
            // blogMapper.insertBlog(2,"标题2","内容2");

            // 更新
            // blogMapper.updateBlog(new Blog(1, "标题一", "内容一"));

            // 删除
            // blogMapper.deleteBlog(1);

            // 手动提交
            session.commit();

            List<Blog> blogs = blogMapper.selectBlog();
            blogs.forEach(blog -> {
                log.info("{}, {}", blog.getTitle(), blog.getContent());
            });
        }
    }
}
