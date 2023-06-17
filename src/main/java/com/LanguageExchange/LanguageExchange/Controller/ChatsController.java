package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Chats;
import com.LanguageExchange.LanguageExchange.Model.Messages;
import com.LanguageExchange.LanguageExchange.Repositories.ChatsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chats")
public class ChatsController {

    @Autowired
    ChatsRepository chatsRepository;

    @GetMapping("")
    public ResponseEntity<List<Chats>> getAllChats(){
        return new ResponseEntity<>(chatsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chats> getChatById(@PathVariable String id){
        return new ResponseEntity<>(chatsRepository.findByid(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Chats> createChat(@RequestBody List<String> userIdList){
        LocalDateTime now = LocalDateTime.now();
        Chats newChat = new Chats(userIdList, new HashMap<String, String>(Map.of(now.toString().substring(now.toString().indexOf("T") - 1)), new ));
        while (true){
            String newId = new ObjectId().toString();
            if(chatsRepository.existsById(newId) == false) {
                newChat.setId(newId);
                break;
            }
        }
        chatsRepository.save(newChat);
        return new ResponseEntity<>(newChat, HttpStatus.OK);
    }
}
