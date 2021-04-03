package net.thumbtack.school.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class User {
    public final String firstName;
    public final String lastName;
    private final String login;
    private String password;

}
