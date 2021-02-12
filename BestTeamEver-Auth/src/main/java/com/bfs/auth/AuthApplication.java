package com.bfs.auth;

import com.bfs.auth.config.HibernateConfig;
import com.bfs.auth.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Query<UserRole> query = session.createQuery("from UserRole");
//        List<UserRole> userList = query.list();
//        System.out.println(userList.toString());
//        transaction.commit();
//        UserDAO dao = (UserDAO) context.getBean("userDAO");
//        System.out.println(dao.checkUser("te","123"));
//        Test t = new Test("testname", "testage");
//        Gson gson = new Gson();
//        gson.toJson(t);
//        System.out.println();



    }

}
