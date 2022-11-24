package com.technical.userapp.repository;

import com.technical.userapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Creating a repository for the User class.
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

}
