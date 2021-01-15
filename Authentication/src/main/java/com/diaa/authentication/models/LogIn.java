package com.diaa.authentication.models;


import javax.validation.constraints.Email;

public class LogIn {
    @Email
    private String existingEmail;
    private String hash;

    public LogIn() {
    }

    public LogIn(String existingEmail, String hash) {
        this.existingEmail = existingEmail;
        this.hash = hash;
    }

    public String getExistingEmail() {
        return existingEmail;
    }

    public void setExistingEmail(String existingEmail) {
        this.existingEmail = existingEmail;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
