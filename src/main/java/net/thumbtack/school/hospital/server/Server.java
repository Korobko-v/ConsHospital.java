package net.thumbtack.school.hospital.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Lombok;
import lombok.SneakyThrows;
import net.thumbtack.school.hospital.model.Day;
import net.thumbtack.school.hospital.model.Doctor;
import net.thumbtack.school.hospital.model.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Server {
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Patient> patients = new ArrayList<>();
    public static Doctor currentDoctor;
    public static Patient currentPatient;
    public ObjectMapper mapper = new ObjectMapper();

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

    public static boolean containsPatientsLogin(String login) {
        for (Patient patient: patients) {
            try {
                if (patient.getLogin().equals(login)) {
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

    public static Patient getPatientByLogin(String login) {
        for (Patient patient: patients) {
            if (patient.getLogin().equals(login)) {
                return patient;
            }
        }
        return null;
    }

//    public static Doctor getDoctorByToken(String token) {
//        for (Doctor doctor : doctors) {
//            if (doctor.getToken().equals(token)) {
//                return doctor;
//            }
//        }
//        return null;
//    }

    public void startServer(String savedDataFileName) throws IOException {
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(savedDataFileName));
        while (bufferedFileReader.ready()) {
            String s = bufferedFileReader.readLine();
            doctors.add(mapper.readValue(s, Doctor.class));
//            String[] arr = bufferedFileReader.readLine().split("\\|");
//            if (arr.length >= 6) {
//                doctors.add(new Doctor(arr[0], arr[1],
//                        arr[2], arr[3], arr[4], arr[5]));
//            }
        }
    //    loadPatients();
  //      loadMedicines();
        //    loadProcedures();
        bufferedFileReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1: Регистрация");
        System.out.println("2: Вход(Доктор)");
        System.out.println("3: Вход(Пациент)");
        System.out.println("Другая клавиша: Выход");
        String s = reader.readLine();

        if (s.equals("1")) {
            Doctor.signUp();
        }
        if (s.equals("2")) {
            doctors.get(0).logIn();
        }
        if (s.equals("3")) {
            patients.get(0).logIn();
        }
        else {
            stopServer(savedDataFileName);
        }
    }

    public void stopServer(String savedDataFileName) throws IOException {
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(savedDataFileName));
        for (Doctor doctor : doctors) {
//            bufferedFileWriter.write(String.join("|", doctor.getFirstName(), doctor.getLastName(),
//                    doctor.getLogin(), doctor.getPassword(),doctor.getSpeciality(), doctor.getToken()) + "\n");

            bufferedFileWriter.write(new ObjectMapper().writeValueAsString(doctor));
            bufferedFileWriter.write("\n");
        }
        bufferedFileWriter.close();
//        savePatients();
    }

//    @SneakyThrows
//    public void loadPatients() {
//        BufferedReader bufferedFileReader = new BufferedReader(new FileReader("patients.txt"));
//        while (bufferedFileReader.ready()) {
//            String[] arr = bufferedFileReader.readLine().split("\\|");
//            if (arr.length >= 5) {
//                Patient currentPatient = new Patient(arr[0], arr[1],
//                        arr[2], arr[3], getDoctorByToken(arr[6]), arr[4]);
//                currentPatient.setDoctor(getDoctorByToken(arr[6]));
//                patients.add(currentPatient);
//
//                for (Doctor doctor: doctors) {
//                    if (arr[6].equals(doctor.getToken())) {
//                        doctor.patients.add(currentPatient);
//                    }
//                }
//            }
//            for (Doctor doctor: doctors) {
//                for (Patient patient: doctor.patients) {
//                    patients.add(patient);
//                }
//            }
//        }


//    @SneakyThrows
//    public static void savePatient() {
//        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter("patients.txt", true));
//        Patient currentPatient  = patients.get(patients.size()-1);
//            bufferedFileWriter.write(String.join("|", currentPatient.getFirstName(),
//                    currentPatient.getLastName(), currentPatient.getLogin(), currentPatient.getPassword(),
//                    currentPatient.getDiagnosis(), currentDoctor.getFirstName() + " " + currentDoctor.getLastName(),
//                    currentDoctor.getToken() +"\n"));
//
//        bufferedFileWriter.close();
//    }
//
//    @SneakyThrows
//    public static void updatePatients() {
//        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter("patients.txt"));
//        for (Patient patient : patients) {
//            bufferedFileWriter.write(String.join("|", patient.getFirstName(),
//                    patient.getLastName(), patient.getLogin(), patient.getPassword(),
//                    patient.getDiagnosis(), patient.getDoctor().getFirstName() + " " + patient.getDoctor().getLastName(),
//                    patient.getDoctor().getToken() + "\n"));
//        }
//        bufferedFileWriter.close();
//    }

//    @SneakyThrows
//    public static void loadProcedures() {
//        BufferedReader proceduresReader = new BufferedReader(new FileReader("procedures.txt"));
//        while (proceduresReader.ready()) {
//            String s = proceduresReader.readLine();
//            String[] patientAndProcedure = s.split("\\|");
//            if (patientAndProcedure.length > 1) {
//                String login = patientAndProcedure[0];
//                Patient patient = getPatientByLogin(login);
//
//                String[] procedureAndDays = patientAndProcedure[1].split("\\-");
//                if (procedureAndDays.length > 1) {
//                    String procedure = procedureAndDays[0];
//                    String[] days = procedureAndDays[1].split(",");
//
//                    TreeSet<Day> daySet = new TreeSet<>((o1, o2) -> o1.getOrder().compareTo(o2.getOrder()));
//                    for (String sDay : days) {
//                        for (Day day : Day.values()) {
//                            if (day.getDay().equals(sDay)) {
//                                daySet.add(day);
//                                break;
//                            }
//                        }
//                    }
//                    patient.getProcedures().put(procedure, daySet);
//                }
//            }
//        }
//        proceduresReader.close();
//    }
//
//    @SneakyThrows
//    public void loadMedicines() {
//        BufferedReader medicinesReader = new BufferedReader(new FileReader("medicines.txt"));
//        while (medicinesReader.ready()) {
//            String s = medicinesReader.readLine();
//            String[] patientAndMedicines = s.split("\\|");
//            String login = patientAndMedicines[0];
//            Patient patient = getPatientByLogin(login);
//            String[] meds = new String[patientAndMedicines.length - 1];
//            System.arraycopy(patientAndMedicines, 1, meds, 0, patientAndMedicines.length - 1);
//            for (String med : meds) {
//                String[] medsAndSeq = med.split("-");
//
//                if (medsAndSeq.length > 1) {
//                    String key = medsAndSeq[0];
//                    Integer value = Integer.parseInt(medsAndSeq[1]);
//                    patient.getMedicines().put(key,value);
//                }
//            }
//        }
//    }
}
