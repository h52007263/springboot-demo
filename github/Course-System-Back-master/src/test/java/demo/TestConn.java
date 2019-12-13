package demo;

import cn.ltysyn.bean.Student;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestConn {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void test1(){
        int stuId=1;
        System.out.println(sessionFactory);
//        Student student = (Student) sessionFactory.getCurrentSession().
//                createQuery("from Student where id = ?").setParameter(0, stuId).uniqueResult();
//        System.out.println(student);
    }
}
