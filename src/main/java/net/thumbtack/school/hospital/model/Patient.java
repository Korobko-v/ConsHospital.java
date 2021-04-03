package net.thumbtack.school.hospital.model;
import lombok.Getter;
import lombok.Setter;
import net.thumbtack.school.hospital.service.UserService;

import java.util.ArrayList;

@Getter
@Setter
public class Patient extends User implements UserService {
    public final String diagnosis;
    public ArrayList<Prescription> prescriptions;
    public Doctor doctor;

    public Patient(String firstName, String lastName, String login, String password, String diagnosis) {
        super(firstName, lastName, login, password);
        this.diagnosis = diagnosis;
    }

    @Override
    public String signUp() {
        return null;
    }

    @Override
    public void logIn() {

    }
}
