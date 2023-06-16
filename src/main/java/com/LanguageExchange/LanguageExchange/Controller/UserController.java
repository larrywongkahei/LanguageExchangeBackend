package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.LanguageLevel;
import com.LanguageExchange.LanguageExchange.Model.User;
import com.LanguageExchange.LanguageExchange.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if(id != null){
            return new ResponseEntity<>(userRepository.findByid(id), HttpStatus.OK);
        } else if (firstName != null) {
            return new ResponseEntity<>(userRepository.findByfirstName(firstName), HttpStatus.OK);
        } else if (lastName != null) {
            return new ResponseEntity<>(userRepository.findBylastName(lastName), HttpStatus.OK);
        } else if (language != null) {
            return new ResponseEntity<>(userRepository.findBylanguage(language), HttpStatus.OK);
        } else if (gender != null) {
            return new ResponseEntity<>(userRepository.findBygender(gender), HttpStatus.OK);
        } else if (dateOfBirth != null) {
            return new ResponseEntity<>(userRepository.findBydateOfBirth(dateOfBirth), HttpStatus.OK);
        } else if (countryOfResidence != null) {
            return new ResponseEntity<>(userRepository.findBycountryOfResidence(countryOfResidence), HttpStatus.OK);
        } else if (motherTongue != null) {
            return new ResponseEntity<>(userRepository.findBymotherTongue(motherTongue), HttpStatus.OK);
        }
//        HashMap<String, String> paramsHashmap = new HashMap<>();
//        paramsHashmap.put("id", id);
//        paramsHashmap.put("firstName", firstName);
//        paramsHashmap.put("lastName", lastName);
//        paramsHashmap.put("language", language);
//        paramsHashmap.put("gender", gender);
//        paramsHashmap.put("dateOfBirth", dateOfBirth);
//        paramsHashmap.put("countryOfResidence", countryOfResidence);
//        paramsHashmap.put("motherTongue", motherTongue);
//
//        Set<String> paramKeys = paramsHashmap.keySet();
//        String paramWithData = paramKeys.stream()
//                .filter(each -> paramsHashmap.get(each) != null)
//                .collect(Collectors.joining());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity<List<User>> createUser(@RequestBody User user){
        HashMap hashmap = new HashMap<String, LanguageLevel>();
        hashmap.put("larry", LanguageLevel.BEGINNER);
        while (true){
            String newId = new ObjectId().toString();
            if(userRepository.findByid(newId).isEmpty()){
                user.setId(newId);
                break;
            }
        }
        userRepository.save(user);
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
