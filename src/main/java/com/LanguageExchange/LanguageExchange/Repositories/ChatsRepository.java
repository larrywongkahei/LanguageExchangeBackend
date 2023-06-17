package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.Chats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatsRepository extends MongoRepository<Chats, String> {
}
