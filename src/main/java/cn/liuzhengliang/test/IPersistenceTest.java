package cn.liuzhengliang.test;

import cn.liuzhengliang.io.Resources;
import cn.liuzhengliang.sqlSession.SqlSession;
import cn.liuzhengliang.sqlSession.SqlSessionFactory;
import cn.liuzhengliang.sqlSession.SqlSessionFactoryBuilder;
import cn.liuzhengliang.dao.IUserDao;
import cn.liuzhengliang.pojo.User;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }



}
