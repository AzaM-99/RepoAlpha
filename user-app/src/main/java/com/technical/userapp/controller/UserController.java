package com.technical.userapp.controller;

import com.technical.userapp.dto.UserBasic;
import com.technical.userapp.service.UserService;
import com.technical.userapp.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * A controller class that handles the requests for the user.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * It gets a user by id and returns a response entity with the user's basic information
     * 
     * @param id The id of the user to retrieve
     * @return A ResponseEntity with a UserBasic object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserBasic> getUser(@PathVariable Long id) {

        log.info("REST request to get User : {}", id);

        return ResponseEntity.ok(service.getBasic(id));
    }

    /**
     * The function takes a UserBasic object as a parameter, saves it to the database, and returns a
     * ResponseEntity object with the saved UserBasic object as the body
     * 
     * @param userReq The object that will be created.
     * @return A ResponseEntity with a body of type UserBasic.
     */
    @PostMapping
    public ResponseEntity<UserBasic> createUser(@Valid @RequestBody UserBasic userReq) {

        log.info("REST request to save User : {}", userReq);

        UserBasic result = service.save(userReq);

        return ResponseEntity.ok()
                .headers(HeaderUtil.createAlert("Utilisateur a été créer avec succées : "+result.getId()))
                .body(result);
    }
}
