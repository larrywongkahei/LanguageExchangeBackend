package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Room;
import com.LanguageExchange.LanguageExchange.Repositories.RoomsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chats")
public class RoomsController {

    @Autowired
    RoomsRepository roomsRepository;

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllChats(){
        return new ResponseEntity<>(roomsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getChatById(@PathVariable String id){
        return new ResponseEntity<>(roomsRepository.findByid(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Room> createChat(@RequestParam String userOne, @RequestParam String userTwo){
        LocalDateTime now = LocalDateTime.now();
        Room newChat = new Room(userOne, userTwo, new HashMap<String, String>(Map.of("fsaef", "fasef")));
        while (true){
            String newId = new ObjectId().toString();
            if(roomsRepository.existsById(newId) == false) {
                newChat.setId(newId);
                break;
            }
        }
        roomsRepository.save(newChat);
        return new ResponseEntity<>(newChat, HttpStatus.OK);
    }
}