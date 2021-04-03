package net.thumbtack.school.hospital.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.SneakyThrows;
import net.thumbtack.school.hospital.server.Server;
import net.thumbtack.school.hospital.service.UserService;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
public class Doctor extends User implements UserService {
        public final String speciality;
        public final String token;
        public List<Patient> thisDoctorsPatients = new ArrayList<>();

    public Doctor(String firstName, String lastName, String login, String password, String speciality, String token) {
        super(firstName, lastName, login, password);
        this.speciality = speciality;
        this.token = token;
    }

    @SneakyThrows
    @Override
    public String signUp() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите имя: ");
            String thisFirstName = reader.readLine();

            System.out.println("Введите фамилию: ");
            String thisLastName = reader.readLine();


            System.out.println("Введите логин: ");
            String thisLogin = reader.readLine();

            if (Server.containsLogin(thisLogin)) {
                System.out.println("Пользователь с логином " + thisLogin + " уже существует.");
                signUp();
            }

            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();

        System.out.println("Введите специальность: ");
        String thisSpeciality = reader.readLine();

            String thisToken = UUID.randomUUID().toString();

            Server.doctors.add(new Doctor(thisFirstName, thisLastName, thisLogin, thisPassword, thisSpeciality, thisToken));
            Server.currentDoctor = Server.getDoctorByLogin(thisLogin);
            System.out.println("Пользователь зарегистрирован.");
            System.out.println("1: Регистрация нового пользователя");
            System.out.println("2: Вход");
            System.out.println("Другая клавиша: Выход");
            String s = reader.readLine();
            if (s.equals("1")) {
                signUp();
            }
            if (s.equals("2")) {
                logIn();
            }
            Gson gson = new Gson();
            return gson.toJson(String.join("|", thisFirstName, thisLastName,
                    thisLogin, thisPassword, thisSpeciality, thisToken));
        }

        @SneakyThrows
        @Override
        public void logIn() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите логин: ");
            String thisLogin = reader.readLine();
            if (!Server.containsLogin(thisLogin)) {
                System.out.println("Неверный логин");
                logIn();
            }

            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();
            if (!Server.getDoctorByLogin(thisLogin).getPassword().equals(thisPassword)) {
                System.out.println("Неверный пароль");
                logIn();
            }
            Server.currentDoctor = Server.getDoctorByLogin(thisLogin);

            System.out.println("Вход выполнен");
            System.out.println("1: Регистрация нового пользователя");
            System.out.println("2: Вход с другого аккаунта");
            System.out.println("3: Зарегистрировать нового пациента");
            System.out.println("4: Просмотреть список моих пациентов");
            System.out.println("Другая клавиша: Выход");
            String s = reader.readLine();
            switch (s) {
                case "1" : signUp();
                case "2" : logIn();
                case "3" : registerPatient();
                case "4" :
                    for (Patient patient : Server.currentDoctor.thisDoctorsPatients) {
                        System.out.println(patient.getFirstName() + " " + patient.getLastName()
                        + " " + patient.getDiagnosis());
                    }
//                Server.patients.
//                        stream()
//                        .filter(patient -> patient.getDoctor().equals(Server.currentDoctor))
//                        .forEach(System.out::println);
            }
        }


        @SneakyThrows
        public void registerPatient() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя пациента: ");
            String firstName = reader.readLine();
            System.out.println("Введите фамилию пациента: ");
            String lastName = reader.readLine();
            System.out.println("Введите логин пациента: ");
            String login = reader.readLine();
            System.out.println("Введите пароль пациента: ");
            String password = reader.readLine();
            System.out.println("Введите диагноз: ");
            String diagnosis = reader.readLine();

            Server.patients.add(new Patient(firstName, lastName, login, password, Server.currentDoctor, diagnosis));

            Server.savePatient();
        }



}
