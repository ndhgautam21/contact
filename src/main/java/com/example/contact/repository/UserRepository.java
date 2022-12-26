package com.example.contact.repository;

import com.example.contact.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "DELETE from user WHERE id =:id", nativeQuery = true)
    int deleteUserById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM user WHERE id=:id", nativeQuery = true)
    User getUserById(@Param("id") Integer id);


}
