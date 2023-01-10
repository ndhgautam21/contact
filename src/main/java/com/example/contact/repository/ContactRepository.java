package com.example.contact.repository;

import com.example.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "SELECT * FROM contact WHERE user_id=:user_id and id=:id", nativeQuery = true)
    Contact getContactById(@Param("user_id") Integer userId, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contact WHERE user_id=:user_id and id=:id", nativeQuery = true)
    int deleteContact(@Param("user_id") Integer userId, @Param("id") Integer id);
}
