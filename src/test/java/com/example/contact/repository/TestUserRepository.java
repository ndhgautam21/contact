package com.example.contact.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    void getUserByID() {

        assertThat(0).isEqualTo(userRepository.deleteUserById(111));
        assertThat(0).isEqualTo(userRepository.deleteUserById(112));
        assertThat(0).isEqualTo(userRepository.deleteUserById(113));
    }
}
