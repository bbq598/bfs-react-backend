package com.bfs.employee_coreserver.repository;


import com.bfs.employee_coreserver.model.Contact;

import java.util.List;

public interface ContactInterface {

    List<Contact> getAllContacts();

    void addContact(Contact contact);

    Contact getContactById(Integer id);

    Contact getContactByUserId(Integer id);
}