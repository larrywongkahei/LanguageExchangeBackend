package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Chats")
public class Chat {
    @Id
    private String id;
    private String date;
    private List<Messages> messageList;

    public Chat(String date) {
        this.date = date;
        this.messageList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Messages> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Messages> messageList) {
        this.messageList = messageList;
    }
}
