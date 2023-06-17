package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document("Rooms")
public class Room {

    @Id
    private String id;
    private String userOne;
    private String userTwo;
    private HashMap<String, String> dateAndChatId;

    public Room(String userOne, String userTwo, HashMap<String, String> dateAndChatId) {
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.dateAndChatId = dateAndChatId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserOne() {
        return userOne;
    }

    public void setUserOne(String userOne) {
        this.userOne = userOne;
    }

    public String getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(String userTwo) {
        this.userTwo = userTwo;
    }

    public HashMap<String, String> getDateAndChatId() {
        return dateAndChatId;
    }

    public void setDateAndChatId(HashMap<String, String> dateAndChatId) {
        this.dateAndChatId = dateAndChatId;
    }
}
