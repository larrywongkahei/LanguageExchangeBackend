package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Chat;
import com.LanguageExchange.LanguageExchange.Model.Messages;
import com.LanguageExchange.LanguageExchange.Model.Room;
import com.LanguageExchange.LanguageExchange.Repositories.ChatsRepository;
import com.LanguageExchange.LanguageExchange.Repositories.RoomsRepository;
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
@RequestMapping("room")
public class RoomsController {

    @Autowired
    RoomsRepository roomsRepository;

    @Autowired
    ChatsRepository chatsRepository;

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
        Chat newChat = new Chat(now.toString().split("T")[0]);
        while (true) {
            String newId = new ObjectId().toString();
            if (chatsRepository.existsById(newId) == false) {
                newChat.setId(newId);
                break;
            }
        }
        chatsRepository.save(newChat);
        Room newRoom = new Room(userOne, userTwo, new HashMap<String, String>(Map.of(now.toString().split("T")[0], newChat.getId())));
        while (true){
            String newId = new ObjectId().toString();
            if(roomsRepository.existsById(newId) == false) {
                newRoom.setId(newId);
                break;
            }
        }
        roomsRepository.save(newRoom);
        return new ResponseEntity<>(newRoom, HttpStatus.OK);
    }
}
