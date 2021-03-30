package net.thumbtack.school.hospital.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Doctor> doctors = new ArrayList<>();

    public static boolean containsLogin(String login) {
        for (Doctor doctor : doctors) {
            try {
                if (doctor.getLogin().equals(login)) {
                    return true;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }

    public static Doctor getDoctorByLogin(String login) {
        for (Doctor doctor : doctors) {
            if (doctor.getLogin().equals(login)) {
                return doctor;
            }
        }
        return null;
    }

    public void startServer(String savedDataFileName) throws IOException {
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(savedDataFileName));
        while (bufferedFileReader.ready()) {
            String[] arr = bufferedFileReader.readLine().split("\\|");
            if (arr.length >= 6) {
                doctors.add(new Doctor(arr[0], arr[1],
                        arr[2], arr[3], arr[4], arr[5]));
            }
        }
        bufferedFileReader.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1: Регистрация");
        System.out.println("2: Вход");
        System.out.println("Другая клавиша: Выход");
        String s = reader.readLine();
        if (s.equals("1")) {
            Doctor.signUp();
        }
        if (s.equals("2")) {
            Doctor.logIn();
        }
        else {
            stopServer(savedDataFileName);
        }
    }

    public void stopServer(String savedDataFileName) throws IOException {
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(savedDataFileName));
        for (Doctor doctor : doctors) {
            bufferedFileWriter.write(String.join("|", doctor.getFirstName(), doctor.getLastName(), doctor.getSpeciality(),
                    doctor.getLogin(), doctor.getPassword(), doctor.getToken()) + "\n");
        }
        bufferedFileWriter.close();
    }
}
