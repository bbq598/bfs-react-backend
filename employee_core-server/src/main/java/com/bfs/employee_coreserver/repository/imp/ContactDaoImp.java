package com.bfs.employee_coreserver.repository.imp;

import com.bfs.employee_coreserver.model.Contact;
import com.bfs.employee_coreserver.repository.AbstractHibernateDao;
import com.bfs.employee_coreserver.repository.ContactInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImp extends AbstractHibernateDao<Contact> implements ContactInterface {

    public ContactDaoImp() {
        setClazz(Contact.class);
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) getCurrentSession().createQuery("from Contact").getResultList();
    }

    @Override
    public void addContact(Contact contact) {
        getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public Contact getContactById(Integer id) {
        return findById(id);
    }

    @Override
    public Contact getContactByUserId(Integer userId) {
        List<Contact> list = getCurrentSession().createQuery("from AddressDomain where userid =" + userId).getResultList();
        return list.get(0);
    }


}
