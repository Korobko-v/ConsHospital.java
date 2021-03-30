package net.thumbtack.school.hospital.server;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Doctor {
        public final String firstName;
        public final String lastName;
        public final String speciality;
        private final String login;
        private final String password;
        public final String token;



        public static String signUp() throws IOException, NullPointerException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите имя: ");
            String thisFirstName = reader.readLine();

            System.out.println("Введите фамилию: ");
            String thisLastName = reader.readLine();

            System.out.println("Введите специальность: ");
            String thisSpeciality = reader.readLine();

            System.out.println("Введите логин: ");
            String thisLogin = reader.readLine();

            if (Server.containsLogin(thisLogin)) {
                System.out.println("Пользователь с логином " + thisLogin + " уже существует.");
                signUp();
            }

            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();

            String thisToken = UUID.randomUUID().toString();

            Server.doctors.add(new Doctor(thisFirstName, thisLastName, thisSpeciality, thisLogin, thisPassword, thisToken));
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
            return gson.toJson(String.join("|", thisFirstName, thisLastName, thisSpeciality,
                    thisLogin, thisPassword, thisToken));
        }
        public static void logIn() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите логин: ");
            String thisLogin = reader.readLine();
            if (!Server.containsLogin(thisLogin)) {
                System.out.println("Неверный логин");
                logIn();
            }
            System.out.println("Введите пароль: ");
            String thisPassword = reader.readLine();
            if (!Server.getDoctorByLogin(thisLogin).password.equals(thisPassword)) {
                System.out.println("Неверный пароль");
                logIn();
            }
            System.out.println("Вход выполнен");
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
        }

        public void registerPatient() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя пациента: ");
            String firstName = reader.readLine();
            System.out.println("Введите фамилию пациента: ");
            String lastName = reader.readLine();
            System.out.println("Введите диагноз: ");
            String diagnosis = reader.readLine();
            System.out.println("Введите логин пациента: ");
            String login = reader.readLine();
            System.out.println("Введите пароль пациента: ");
            String password = reader.readLine();
        }



}
