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


@RestController
@RequestMapping("/user")

@SuppressWarnings("rawtypes")
public class UserController {

    @Autowired
    UserServiceImpl service;

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

    @GetMapping("/find/all")
    public ResponseEntity findAll(HttpServletRequest req){
        HttpSession session = req.getSession();
        List<User> users = service.findAll();
        if (!users.isEmpty()){
            return ResponseEntity.ok().body(users);
        } else return ResponseEntity.internalServerError().body("You must validate login first");   
    }
}
