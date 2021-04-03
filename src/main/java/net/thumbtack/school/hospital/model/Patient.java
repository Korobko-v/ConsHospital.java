package net.thumbtack.school.hospital.model;
import lombok.Getter;
import lombok.Setter;
import net.thumbtack.school.hospital.server.Server;
import net.thumbtack.school.hospital.service.UserService;

import javax.print.Doc;
import java.util.ArrayList;

@Getter
@Setter
public class Patient extends User implements UserService {
    public final String diagnosis;
    public ArrayList<Prescription> prescriptions;
    public Doctor doctor;

    public Patient(String firstName, String lastName, String login, String password, Doctor doctor, String diagnosis) {
        super(firstName, lastName, login, password);
        this.diagnosis = diagnosis;
        setDoctor(doctor);
    }

    @Override
    public String signUp() {
        return null;
    }

    @Override
    public void logIn() {

    }
}
