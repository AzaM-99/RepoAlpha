package com.technical.userapp.service;

import com.technical.userapp.config.AbstractH2Test;
import com.technical.userapp.dto.UserBasic;
import com.technical.userapp.enumeration.Gender;
import com.technical.userapp.exception.EntityNotFoundException;
import com.technical.userapp.exception.ManagementException;
import com.technical.userapp.model.User;
import com.technical.userapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest  extends AbstractH2Test {

    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repository;

    User initUser = new User("User For Test", LocalDate.now().minus(20, ChronoUnit.YEARS),"FRANCE","445566677", Gender.MALE);

    UserBasic userBasic = new UserBasic();


    @BeforeEach
    void setUp() {
        userBasic.setName("userBasic");
        userBasic.setCountry("FRANCE");
        userBasic.setPhone("4566665556");
        userBasic.setGender(Gender.FEMALE);
        userBasic.setBirthDate(LocalDate.now().minus(20, ChronoUnit.YEARS));
        initUser = repository.saveAndFlush(initUser);
    }

    @AfterEach
    void tearDown() {
        repository.delete(initUser);
    }

    @Test
    void save_Success() {
        Assertions.assertNotNull(service.save(userBasic));
    }

   @Test
    void save_fail_young_user() {
        userBasic.setBirthDate(LocalDate.now());
       ManagementException exception = assertThrows(ManagementException.class,() -> service.save(userBasic));
       assertNotNull(exception);
    }

   @Test
    void save_fail_foreign_user() {
       userBasic.setCountry("TUNISIA");
       ManagementException exception = assertThrows(ManagementException.class,() -> service.save(userBasic));
       assertNotNull(exception);
    }

   @Test
    void save_fail_invalid_user() {
       userBasic.setId(2L);
       ManagementException exception = assertThrows(ManagementException.class,() -> service.save(userBasic));
       assertNotNull(exception);
    }

    @Test
    void save_fail_invalid_data() {
        userBasic.setName(null);
        ManagementException exception = assertThrows(ManagementException.class,() -> service.save(userBasic));
        assertNotNull(exception);
    }

    @Test
    void getBasic_Not_found() {
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,() -> service.getBasic(5L));
        assertNotNull(exception.getMessage());
    }

    @Test
    void getBasic_Success() {
        assertNotNull(service.getBasic(1L));
    }
}