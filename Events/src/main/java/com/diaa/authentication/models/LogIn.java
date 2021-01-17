package com.diaa.authentication.models;

import javax.validation.constraints.Email;

public class LogIn {
    @Email
    private String registeredEmail;
    private String registeredPassword;

    public LogIn() {
    }

    public LogIn(String registeredEmail, String registeredPassword) {
        this.registeredEmail = registeredEmail;
        this.registeredPassword = registeredPassword;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public void setRegisteredPassword(String registeredPassword) {
        this.registeredPassword = registeredPassword;
    }
}
