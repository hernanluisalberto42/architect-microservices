package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/userServiceFallBack")
    public String userFallBack(RuntimeException ex){
        return "User service is not working now, excuse me";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentFallBack(){
        return "Department service is not working now, excuse me";
    }
}
