package com.LanguageExchange.LanguageExchange.Repositories;

import com.LanguageExchange.LanguageExchange.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'id' : ?0}")
    List<User> findByid(String id);
    @Query("{'firstName' : ?0}")
    List<User> findByfirstName(String firstName);

    @Query("{'lastName' : ?0}")
    List<User> findBylastName(String lastName);

    @Query("{'language' : ?0}")
    List<User> findBylanguage(String language);

    @Query("{'gender' : ?0}")
    List<User> findBygender(String gender);

    @Query("{'dateOfBirth' : ?0}")
    List<User> findBydateOfBirth(String dateOfBirth);

    @Query("{'countryOfResidence' : ?0}")
    List<User> findBycountryOfResidence(String countryOfResidence);

    @Query("{'motherTongue' : ?0}")
    List<User> findBymotherTongue(String motherTongue);
}
