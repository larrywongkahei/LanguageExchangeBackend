package com.LanguageExchange.LanguageExchange.Model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Messages")
public class Message {

    @Id
    private String id;
    private String time;
    private String fromId;
    private String toId;
    private String messageType;

    private String messageBase64 = null;
    private Binary message = null;

    public Message(String id, String time, String fromId, String toId, String messageType) {
        this.id = id;
        this.time = time;
        this.fromId = fromId;
        this.toId = toId;
        this.messageType = messageType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Binary getMessage() {
        return message;
    }

    public void setMessage(Binary message) {
        this.message = message;
    }

    public String getMessageBase64() {
        return messageBase64;
    }

    public void setMessageBase64(String messageBase64) {
        this.messageBase64 = messageBase64;
    }
}
