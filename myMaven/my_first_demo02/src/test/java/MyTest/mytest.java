package MyTest;

import com.li.dao.UserDao;
import com.li.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class mytest {
    private UserDao userDao;
    private InputStream is;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2. 读取核心配置文件，转换成字节输入流
        is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //3. 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        //4. 创建SqlSession对象
       sqlSession = sessionFactory.openSession();
        //5. 创建UserDao的代理对象
       userDao = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void testFindAll(){
        //测试执行findAll()方法
        //6. 调用你想执行的方法
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }
@Test
    public void testAddUser()
    {
        User user = new User();
        user.setUsername("李一一");
    user.setSex("女");
    user.setAddress("广州");
    user.setBirthday(new Date());
    userDao.addUser(user);}
    @Test
    public void testDeleteById()
    {
        userDao.deleteById(5);
    }
    @Test
    public void testAddUserAndReturnId()
    {
        User user = new User();
        user.setUsername("苍老师");
        user.setSex("女");
        user.setAddress("广州");
        user.setBirthday(new Date());
        int i = userDao.addUserAndReturnId(user);
        System.out.println(i);

    }
    @Test
    public void  testSearchByUsername()
    {
        /**
         * 这怎么就返回一个map?
         */
        List<User> list = userDao.searchByUsername("丽");
        for (User user : list) {
            System.out.println(user);
        }

    }

    @After
    public void destroy() throws IOException {
        //提交事务!!!!!!!!!!!!!
        sqlSession.commit();
        //7. 关闭资源
        sqlSession.close();
        is.close();
    }
}
