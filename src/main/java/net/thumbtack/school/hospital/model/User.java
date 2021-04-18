package net.thumbtack.school.hospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Getter
@JsonDeserialize(as = User.class)
@Jacksonized
public abstract class User {
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    public void logIn() {

    }
    public User() {

    }



}
