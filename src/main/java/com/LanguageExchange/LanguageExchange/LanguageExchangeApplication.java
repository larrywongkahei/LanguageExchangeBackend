package com.LanguageExchange.LanguageExchange;

import com.LanguageExchange.LanguageExchange.Model.LanguageLevel;
import com.LanguageExchange.LanguageExchange.Model.User;
import com.LanguageExchange.LanguageExchange.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class LanguageExchangeApplication implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(LanguageExchangeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.deleteAll();
		HashMap hashmap = new HashMap<String, LanguageLevel>();
		hashmap.put("larry", LanguageLevel.BEGINNER);
		User user = new User("fasdf", "larry", "fasef", "afesf", "faesfa", "fasef", "faefs", hashmap);
		userRepository.save(user);
	}
}
