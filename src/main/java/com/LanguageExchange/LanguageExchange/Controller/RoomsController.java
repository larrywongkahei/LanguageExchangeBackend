package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Chat;
import com.LanguageExchange.LanguageExchange.Model.Messages;
import com.LanguageExchange.LanguageExchange.Model.Room;
import com.LanguageExchange.LanguageExchange.Model.User;
import com.LanguageExchange.LanguageExchange.Repositories.ChatsRepository;
import com.LanguageExchange.LanguageExchange.Repositories.RoomsRepository;
import com.LanguageExchange.LanguageExchange.Repositories.UserRepository;
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
    @Autowired
    UserRepository userRepository;

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
        //        Create a new chat
        Chat newChat = new Chat(now.toString().split("T")[0]);
        while (true) {
            String newId = new ObjectId().toString();
            if (chatsRepository.existsById(newId) == false) {
                newChat.setId(newId);
                //              Add chatId to userOne
                User newUserOne = userRepository.findByid(userOne).get(0);
                List<String> newUserOneList = newUserOne.getRoomIdList();
                newUserOneList.add(newId);
                newUserOne.setRoomIdList(newUserOneList);
                userRepository.save(newUserOne);
                //              Add chatId to userTwo
                User newUserTwo = userRepository.findByid(userTwo).get(0);
                List<String> newUserTwoList = newUserTwo.getRoomIdList();
                newUserTwoList.add(newId);
                newUserTwo.setRoomIdList(newUserTwoList);
                userRepository.save(newUserTwo);
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
