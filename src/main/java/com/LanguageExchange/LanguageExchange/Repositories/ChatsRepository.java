package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.Chats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ChatsRepository extends MongoRepository<Chats, String> {
    @Query("{'id' : ?0}")
    Chats findByid(String id);
}
