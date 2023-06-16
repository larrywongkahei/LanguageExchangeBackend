package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.LanguageLevel;
import com.LanguageExchange.LanguageExchange.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public ResponseEntity<User> index(){
        HashMap themap = new HashMap<String, LanguageLevel>();
        themap.put("Larry", LanguageLevel.BEGINNER);
        User newuser = new User("fasef", "fasef", "fasef", "fasef", "fasef", "fasef", "fasef", themap);
        System.out.println(newuser);
        return new ResponseEntity<>(newuser, HttpStatus.OK);

    }
}
