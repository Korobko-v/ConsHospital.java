package net.thumbtack.school.hospital.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.jackson.Jacksonized;
import net.thumbtack.school.hospital.server.Server;
import net.thumbtack.school.hospital.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Getter
@Setter
@JsonDeserialize(as = Patient.class)
@Jacksonized
public class Patient extends User {
    @JsonProperty("diagnosis")
    public String diagnosis;
//   @JsonProperty("doctor")
    @JsonIgnore
    public Doctor doctor;
    @JsonProperty("password")
    private String password;
    @JsonProperty("medicines")
    private Map<String, Integer> medicines;
    @JsonProperty("procedures")
    private Map<String, TreeSet<Day>> procedures;


    public Patient() {

    }


    public Patient(String firstName, String lastName, String login, String password, Doctor doctor, String diagnosis) {
        super(firstName, lastName, login,password);
        this.diagnosis = diagnosis;
        this.password = password;
        setDoctor(doctor);
        this.medicines = new HashMap<>();
        this.procedures = new HashMap<>();
    }


    @Override
    @SneakyThrows
    public void logIn() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите логин: ");
        String thisLogin = reader.readLine();
        if (!Server.containsPatientsLogin(thisLogin)) {
            System.out.println("Неверный логин");
            logIn();
        }
        else {
            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();
            if (!Server.getPatientByLogin(thisLogin).getPassword().equals(thisPassword)) {
                System.out.println("Неверный пароль");
                logIn();
            } else {
                Server.currentPatient = Server.getPatientByLogin(thisLogin);
                System.out.println("Вход выполнен");
                System.out.println(Server.currentPatient.getFirstName() + " " + Server.currentPatient.getLastName());
                System.out.println("==============================");
                patientsMenu();
            }
        }
    }

    @SneakyThrows
    public void patientsMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1: Мой доктор");
        System.out.println("2: Мои назначения");
        System.out.println("3: Вход с другого аккаунта(доктор)");
        System.out.println("4: Вход с другого аккаунта(пациент)");
        System.out.println("5: Сменить пароль");
        System.out.println("6: Удалить аккаунт");
        System.out.println("Другая клавиша: Выход");
        String s = reader.readLine();


        switch (s) {
            case "1":
                viewCurrentPatientsDoctor();
                patientsMenu();
                break;
            case "2":
                Server.currentPatient.viewMyPrescriptions();
                break;
            case "3":
                Server.doctors.get(0).logIn();
                patientsMenu();
                break;
            case "4":
                Server.currentPatient.logIn();
                patientsMenu();
                break;
            case "5":
                changePassword();
                patientsMenu();
                break;

            case "6":
                removePatient();
                break;
        }

    }

    public void viewCurrentPatientsDoctor() {
        System.out.println("Мой доктор:");
        System.out.println(Server.currentPatient.getDoctor().getFirstName() + " "
                + Server.currentPatient.getDoctor().getLastName() + " " + Server.currentPatient.getDoctor().getSpeciality());
        System.out.println("==============================");
    }

    @SneakyThrows
    public void changePassword() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите новый пароль");
        String newPassword = reader.readLine();

        if (newPassword.equals(Server.currentPatient.getPassword())) {
            System.out.println("Введён другой пароль: ");
            changePassword();
        }
        else {
            Server.getPatientByLogin(Server.currentPatient.getLogin()).setPassword(newPassword);
//            Server.updatePatients();
            System.out.println("Пароль успешно изменён");
            System.out.println("==============================");
        }
    }

    public void removePatient() {
        Server.patients.remove(Server.getPatientByLogin(Server.currentPatient.getLogin()));
//        Server.updatePatients();
        System.out.println("Пациент удалён");
        System.out.println("==============================");
    }

    public void viewMyPrescriptions() {
        System.out.println("Мои лекарства:");
        for (Map.Entry<String, Integer> entry : getMedicines().entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("==============================");
        System.out.println("Мои процедуры:");
        for (Map.Entry<String, TreeSet<Day>> entry : getProcedures().entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (Day day: entry.getValue()) {
                System.out.println(day.getDay());
            }
        }
    }
}
