package com.LanguageExchange.LanguageExchange.Model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Messages {

    @Id
    private String id;
    private String dateTime;
    private String fromId;
    private String toId;
    private Binary textMessage;
    private Binary voiceMessage;
    private Binary imageMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public Binary getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(Binary textMessage) {
        this.textMessage = textMessage;
    }

    public Binary getVoiceMessage() {
        return voiceMessage;
    }

    public void setVoiceMessage(Binary voiceMessage) {
        this.voiceMessage = voiceMessage;
    }

    public Binary getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(Binary imageMessage) {
        this.imageMessage = imageMessage;
    }
}
