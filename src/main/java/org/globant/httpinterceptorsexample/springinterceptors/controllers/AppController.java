package org.globant.httpinterceptorsexample.springinterceptors.controllers;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/main")
    public Map<String, String> main(){
        return Collections.singletonMap("Message", "Message main sent from the controller");
    }

    @GetMapping("/variable")
    public Map<String, String> variable(){
        return Collections.singletonMap("Message", "Message variable sent from the controller");
    }

    @GetMapping("/const")
    public Map<String, String> constant(){
        return Collections.singletonMap("Message", "Message const sent from the controller");
    }
}
