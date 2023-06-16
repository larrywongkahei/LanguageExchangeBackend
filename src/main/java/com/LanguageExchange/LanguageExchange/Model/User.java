package com.LanguageExchange.LanguageExchange.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;
import java.util.Dictionary;
import java.util.HashMap;

@Document("User")
public class User {

    private String email;
    private String firstName;

    private String lastName;

    private String dateOfBirth;

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

    public String getDataOfBirth() {
        return dateOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dateOfBirth = dataOfBirth;
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
