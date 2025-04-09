package com.packages.Authentication.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("")
    public static String greet(){
        return "Hello!!";
    }

}
