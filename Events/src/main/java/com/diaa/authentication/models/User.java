package com.diaa.authentication.models;


import org.springframework.web.accept.AbstractMappingContentNegotiationStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "First name should be At least 3 characters")
    private String first_name;
    @NotBlank
    @Size(min = 3, message = "Last name should be At least 3 characters")
    private String last_name;
    @Email
    private String email;
    @NotBlank
    private String location;
    @Size(min = 2, max = 2)
    private String state;
    @Size(min = 8, message = "At least 8 characters")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9]).{8}$",message = "Weak")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_joins",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> going;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<Event> hosted;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> messages;

    public User() {
    }

    public User(String first_name,String last_name,String email, String location,String state, String password, String passwordConfirmation) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.location = location;
        this.state = state;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Event> getGoing() {
        return going;
    }

    public void setGoing(List<Event> going) {
        this.going = going;
    }

    public List<Event> getHosted() {
        return hosted;
    }

    public void setHosted(List<Event> hosted) {
        this.hosted = hosted;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
