package com.toy.sy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
public class MainController {

    public String main() {
        return "main";
    }



}