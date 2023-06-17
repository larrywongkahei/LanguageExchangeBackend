package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ChatsRepository extends MongoRepository<Room, String> {
    @Query("{'id' : ?0}")
    Room findByid(String id);
}
