package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatsRepository extends MongoRepository<Chat, String> {
    @Query("{'id' : ?0}")
    Chat findByid(String id);

    @Query("{'date' : ?0}")
    List<Chat> findByDate(String date);

    @Query("{'id' : ?0, 'date' : ?1}")
    Chat findByIdAndDate(String id, String date);
}
