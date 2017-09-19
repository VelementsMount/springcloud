package org.liuzhilin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value( "${profilename}" )
    private String profileName;

    @Value( "${pass}" )
    private String pass;

    @GetMapping("/")
    public String hello() {
        return profileName+pass;
    }
}