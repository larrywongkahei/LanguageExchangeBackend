package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Chat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat")
public class ChatsController {

    @GetMapping("")
    public ResponseEntity<Chat> getChatByValue(@RequestParam(required = false) String id, @RequestParam(required = false) String date){
        return ResponseEntity<>()
    }
}
