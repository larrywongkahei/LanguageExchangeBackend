package com.LanguageExchange.LanguageExchange.Model;

import com.LanguageExchange.LanguageExchange.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.Base64;
import java.util.Dictionary;
import java.util.HashMap;

@Document("User")
public class User {

    @Autowired
    UserRepository userRepository;

    @Id
    private String id;

    public byte[] profilePicture;
    private String email;
    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String bio;

    private String gender;

    private String countryOfResidence;

    private String motherTongue;

    private HashMap<String, LanguageLevel> learningLanguage;

    public User(String email, String firstName, String lastName, String dateOfBirth, String gender, String countryOfResidence, String motherTongue, HashMap<String, LanguageLevel> learningLanguage) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.countryOfResidence = countryOfResidence;
        this.motherTongue = motherTongue;
        this.learningLanguage = learningLanguage;
        this.bio = null;
        this.profilePicture = null;

    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public HashMap<String, LanguageLevel> getLearningLanguage() {
        return learningLanguage;
    }

    public void setLearningLanguage(HashMap<String, LanguageLevel> learningLanguage) {
        this.learningLanguage = learningLanguage;
    }
}
