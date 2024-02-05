package org.globant.httpinterceptorsexample.springinterceptors.controllers;

import java.util.List;
import java.util.Optional;

import org.globant.httpinterceptorsexample.springinterceptors.models.User;
import org.globant.httpinterceptorsexample.springinterceptors.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * 
* @author FatFrogDev
* <p>Handles all the petitions for the exercise.</p>
 */
@RestController
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserController {

    @Autowired
    UserServiceImpl service;

    /**
     * Save an user into the database when correct and valid args are given.
     * @param user
     * @param req HttpServletRequest
     * @return ResponseEntity declaring user was saved correctly.
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user){
        service.save(user);
        return ResponseEntity.ok().body("User saved correctly");
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody User user){
        service.save(user);
        return ResponseEntity.ok().body("User edited correctly");
    }

    /**
     * Allows an user to log in to the system to unlock the special route {@link findAll}
     * @param user
     * @param req
     * @return ResponseEntity giving feedback whether the petition was correctly or no.
     */
    @PostMapping("/login") 
    public ResponseEntity login(@RequestBody User user, HttpServletRequest req){
        Optional<User> foundUser = service.findByEmailAndPassword(user.getEmail(), user.getPassword());
        HttpSession session = req.getSession();

        if (foundUser.isPresent()){
            session.setAttribute("validated", true);
            System.out.println("SESSION: " + session.getAttribute("validated"));
            System.out.println(session.getId());
            return ResponseEntity.ok(service.findByEmailAndPassword(user.getEmail(), user.getPassword()));
        } else {
            req.setAttribute("validated", false);
            return ResponseEntity.internalServerError().body("User not found");
        }
    }


    /**
     * Allows an user to see all the registered users when previously logged in.
     * @param user
     * @param req HttpServletRequest
     * @return List <User> registered | Internal server error.
     */
    @GetMapping("/find/all")
    public ResponseEntity findAll(HttpServletRequest req){
        List<User> users = service.findAll();
        if (!users.isEmpty()){
            return ResponseEntity.ok().body(users);
        } else return ResponseEntity.internalServerError().body("You must validate login first");   
    }
}
