package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Chats")
public class Chats {

    @Id
    private String id;
    private String userOneId;
    private String userTwoId;
    private List<Messages> messages;


}
