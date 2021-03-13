package MyTest;

import com.li.dao.UserDao;
import com.li.pojo.QueryBean;
import com.li.pojo.User;
import com.li.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class mytest02 {

    @Test
    public void testfindByQueryBean()
    {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("一");
        List<User> byQueryBean = userdao.findByQueryBean(new QueryBean(user));
        for (User user1 : byQueryBean) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);



    }
}
