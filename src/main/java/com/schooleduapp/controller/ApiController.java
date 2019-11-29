package com.schooleduapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController
{
    @GetMapping("/")
    public String list(){
        return "Api is working";
    }
}
