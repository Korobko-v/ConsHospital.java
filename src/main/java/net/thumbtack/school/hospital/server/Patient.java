package net.thumbtack.school.hospital.server;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor

public class Patient {
    public final String firstName;
    public final String lastName;
    public final String diagnosis;
    private final String login;
    private String password;
    public ArrayList<Prescription> prescriptions;
}
