package net.thumbtack.school.hospital.server;

import lombok.SneakyThrows;
import net.thumbtack.school.hospital.model.Doctor;
import net.thumbtack.school.hospital.model.Patient;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Patient> patients = new ArrayList<>();
    public static Doctor currentDoctor;

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

    public static Doctor getDoctorByToken(String token) {
        for (Doctor doctor : doctors) {
            if (doctor.getToken().equals(token)) {
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
        loadPatients();
        bufferedFileReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1: Регистрация");
        System.out.println("2: Вход");
        System.out.println("Другая клавиша: Выход");
        String s = reader.readLine();
        if (s.equals("1")) {
            doctors.get(0).signUp();
        }
        if (s.equals("2")) {
            doctors.get(0).logIn();
        }
        else {
            stopServer(savedDataFileName);
        }
    }

    public void stopServer(String savedDataFileName) throws IOException {
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(savedDataFileName));
        for (Doctor doctor : doctors) {
            bufferedFileWriter.write(String.join("|", doctor.getFirstName(), doctor.getLastName(),
                    doctor.getLogin(), doctor.getPassword(),doctor.getSpeciality(), doctor.getToken()) + "\n");
        }
        bufferedFileWriter.close();
//        savePatients();
    }

    @SneakyThrows
    public void loadPatients() {
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader("patients.txt"));
        while (bufferedFileReader.ready()) {
            String[] arr = bufferedFileReader.readLine().split("\\|");
            if (arr.length >= 5) {
                Patient currentPatient = new Patient(arr[0], arr[1],
                        arr[2], arr[3], getDoctorByToken(arr[6]), arr[4]);
                patients.add(currentPatient);
                for (Doctor doctor: doctors) {
                    if (arr[6].equals(doctor.getToken())) {
                        doctor.thisDoctorsPatients.add(currentPatient);
                    }
                }
            }
        }
        bufferedFileReader.close();
    }

    @SneakyThrows
    public static void savePatient() {
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter("patients.txt", true));
        Patient currentPatient  = patients.get(patients.size()-1);
            bufferedFileWriter.write(String.join("|", currentPatient.getFirstName(),
                    currentPatient.getLastName(), currentPatient.getLogin(), currentPatient.getPassword(),
                    currentPatient.getDiagnosis(), currentDoctor.getFirstName() + " " + currentDoctor.getLastName(),
                    currentDoctor.getToken() +"\n"));


//        for (Patient patient : patients) {
//            bufferedFileWriter.write(String.join("|", patient.getFirstName(), patient.getLastName(),
//                    patient.getLogin(), patient.getPassword(),patient.getDiagnosis(), getDoctorByLogin(currentDoctor).getLastName() + "\n"));
//        }
        bufferedFileWriter.close();
    }
}
