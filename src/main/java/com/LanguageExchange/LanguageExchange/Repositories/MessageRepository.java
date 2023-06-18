package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
