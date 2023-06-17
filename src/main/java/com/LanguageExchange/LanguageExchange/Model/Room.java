package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document("Rooms")
public class Room {

    @Id
    private String id;
    private List<String> userIdList;
    private HashMap<String, String> dateAndChatId;

    public Room(List<String> userIdList, HashMap<String, String> dateAndChatId) {
        this.userIdList = userIdList;
        this.dateAndChatId = dateAndChatId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public HashMap<String, String> getDateAndChatId() {
        return dateAndChatId;
    }

    public void setDateAndChatId(HashMap<String, String> dateAndChatId) {
        this.dateAndChatId = dateAndChatId;
    }
}
