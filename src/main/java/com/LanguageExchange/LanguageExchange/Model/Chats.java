package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document("Chats")
public class Chats {

    @Id
    private String id;
    private List<String> userIdList;
    private HashMap<String, String> dateAndMessageId;

    public Chats(List<String> userIdList, HashMap<String, String> dateAndMessageId) {
        this.userIdList = userIdList;
        this.dateAndMessageId = dateAndMessageId;
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

    public HashMap<String, String> getDateAndMessageId() {
        return dateAndMessageId;
    }

    public void setDateAndMessageId(HashMap<String, String> dateAndMessageId) {
        this.dateAndMessageId = dateAndMessageId;
    }
}
