package com.linuxea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Linuxea on 10/22/17.
 */

@RestController
public class HelloController {

    @GetMapping(value = "/home")
    String home(){
        return "home";
    }

}
