package net.thumbtack.school.hospital.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.SneakyThrows;
import net.thumbtack.school.hospital.server.Server;
import net.thumbtack.school.hospital.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

@Getter
public class Doctor extends User implements UserService {
        public final String speciality;
        public final String token;

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
            Server.currentDoctor = thisLogin;
            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();
            if (!Server.getDoctorByLogin(thisLogin).getPassword().equals(thisPassword)) {
                System.out.println("Неверный пароль");
                logIn();
            }
            System.out.println("Вход выполнен");
            System.out.println("1: Регистрация нового пользователя");
            System.out.println("2: Вход");
            System.out.println("3: Зарегистрировать нового пациента");
            System.out.println("Другая клавиша: Выход");
            String s = reader.readLine();
            if (s.equals("1")) {
                signUp();
            }
            if (s.equals("2")) {
                logIn();
            }
            if (s.equals("3")) {
                registerPatient();
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

            Server.patients.add(new Patient(firstName, lastName, login, password, diagnosis));
            Server.savePatient();
        }



}
