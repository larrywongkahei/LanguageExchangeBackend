package com.LanguageExchange.LanguageExchange.Controller;

import com.LanguageExchange.LanguageExchange.Model.Message;
import com.LanguageExchange.LanguageExchange.Repositories.MessageRepository;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("")
    public ResponseEntity<List<Message>> getAllMessage(){
        return new ResponseEntity<>(messageRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Message> sendAMessage(@RequestBody Message newMessage){
        while (true) {
            String newId = new ObjectId().toString();
            if (messageRepository.existsById(newId) == false) {
                Message message = new Message(newId,
                        newMessage.getTime(),
                        newMessage.getFromId(),
                        newMessage.getToId(),
                        newMessage.getMessageType());
                String theBase64Message = newMessage.getMessageBase64();
                message.setMessage(new Binary(Base64.getDecoder().decode(theBase64Message.substring(theBase64Message.indexOf(",") + 1)));
                messageRepository.save(message);
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            }
    }
}
