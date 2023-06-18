package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Chat;
import com.LanguageExchange.LanguageExchange.Repositories.ChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat")
public class ChatsController {

    @Autowired
    ChatsRepository chatsRepository;

    @GetMapping("")
    public ResponseEntity<?> getChatByValue(@RequestParam(required = false) String id, @RequestParam(required = false) String date){
        if(id != null & date == null){
            return new ResponseEntity<>(chatsRepository.findByid(id), HttpStatus.OK);
        } else if (id == null & date != null) {
            return new ResponseEntity<>(chatsRepository.findByDate(date), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chatsRepository.findByIdAndDate(id, date), HttpStatus.OK);
        }
    }
}
