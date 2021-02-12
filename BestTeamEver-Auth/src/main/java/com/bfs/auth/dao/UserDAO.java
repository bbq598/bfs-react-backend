package com.bfs.auth.dao;


import com.bfs.auth.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class UserDAO {
    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public User checkUser(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        cr.where(cb.equal(root.get("userName"), userName), cb.equal(root.get("password"), password));
        Query<User> query = session.createQuery(cr);
        List<User> userList = query.getResultList();
        if (userList.size() != 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }


}
