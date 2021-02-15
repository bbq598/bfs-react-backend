package com.bfs.employee_coreserver.repository;

import com.bfs.employee_coreserver.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findContactByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("update Contact c set c.phone = ?1, c.email = ?2, c.homeAddress = ?3," +
           "c.ec1FirstName = ?4, c.ec1LastName = ?5, c.ec1Phone = ?6," +
           "c.ec2FirstName = ?7, c.ec2LastName = ?8, c.ec2Phone = ?9, c.floatingDay = ?10 where c.userId = ?11")
    Integer updateContactById(String phone, String email, String homeAddress,
                              String ec1FirstName, String ec1LastName, String ec1Phone,
                              String ec2FirstName, String ec2LastName, String ec2Phone, Integer floatingDay, Integer userId);
}
