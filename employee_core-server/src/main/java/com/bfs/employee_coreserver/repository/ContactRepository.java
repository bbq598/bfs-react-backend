package com.bfs.employee_coreserver.repository;

import com.bfs.employee_coreserver.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findContactByUserId(Integer userId);
}
