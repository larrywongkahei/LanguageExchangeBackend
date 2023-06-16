package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.LanguageLevel;
import com.LanguageExchange.LanguageExchange.Model.User;
import com.LanguageExchange.LanguageExchange.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("find")
    public ResponseEntity<List<User>> getByValue(@RequestParam(required = false) String id,
                                           @RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName,
                                           @RequestParam(required = false) String language,
                                           @RequestParam(required = false) String gender,
                                           @RequestParam(required = false) String dateOfBirth,
                                           @RequestParam(required = false) String countryOfResidence,
                                           @RequestParam(required = false) String motherTongue){

        return new ResponseEntity<>(userRepository.findByfirstName(firstName), HttpStatus.OK);

    }
}
