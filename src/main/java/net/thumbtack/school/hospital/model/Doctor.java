package net.thumbtack.school.hospital.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.thumbtack.school.hospital.server.Server;
import net.thumbtack.school.hospital.service.UserService;

import java.io.*;
import java.util.*;

@Getter
@Setter
public class Doctor extends User implements UserService {
        public final String speciality;
        public final String token;
        public List<Patient> thisDoctorsPatients = new ArrayList<>();
    private String password;

    public Doctor(String firstName, String lastName, String login, String password, String speciality, String token) {
        super(firstName, lastName, login);
        this.speciality = speciality;
        this.token = token;
        this.password = password;
    }

    @SneakyThrows

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
            Doctor thisDoc = new Doctor(thisFirstName, thisLastName, thisLogin, thisPassword, thisSpeciality, thisToken);
            thisDoc.setThisDoctorsPatients(new ArrayList<>());
            Server.doctors.add(thisDoc);

            Server.currentDoctor = Server.getDoctorByToken(thisToken);
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
            doctorsMenu();
        }

        @SneakyThrows
        public void doctorsMenu() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(Server.currentDoctor.getFirstName() + " " + Server.currentDoctor.getLastName());
            System.out.println("1: Регистрация нового пользователя");
            System.out.println("2: Вход с другого аккаунта");
            System.out.println("3: Зарегистрировать нового пациента");
            System.out.println("4: Мои пациенты");
            System.out.println("5: Добавить назначение");
            System.out.println("6: Удалить аккаунт");
            System.out.println("Другая клавиша: Выход");
            String s = reader.readLine();


            switch (s) {
                case "1":
                    signUp();
                    break;
                case "2":
                    logIn();
                    break;
                case "3":
                    registerPatient();
                    break;
                case "4":
                    viewCurrentDoctorsPatients(Server.currentDoctor);
                    break;
                case "5":
                    addPrescription();
                    break;
                case "6":
                    removeDoctor();
            }

        }


        public void viewCurrentDoctorsPatients(Doctor doctor) {
            System.out.println("Мои пациенты: ");
            Server.patients.
                    stream()
                    .filter(patient -> patient.getDoctor().equals(doctor))
                    .forEach(patient -> System.out.println(patient.getFirstName() + " " + patient.getLastName()
                            + "|" + patient.getDiagnosis()));

            System.out.println("=================================");
            doctorsMenu();
        }

        @SneakyThrows
        public void addPrescription() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите логин пациента");
            String patientsLogin = reader.readLine();
            Server.currentPatient = Server.getPatientByLogin(patientsLogin);
            Patient patient = Server.currentPatient;

            if (patient.getDoctor().equals(Server.currentDoctor)) {

                System.out.println("1. Назначить лекарства");
                System.out.println("2. Назначить процедуры");
                String s = reader.readLine();

                if (s.equals("1")) {
                    while (true) {
                        try {
                            System.out.println("Введите название лекарства: ");
                            String medName = reader.readLine();
                            if (medName.isBlank()) {
                                break;
                            }
                            System.out.println("Введите частоту приёма(в день)");
                            String sFreq = reader.readLine();
                            Integer frequency = Integer.parseInt(sFreq);
                            if (frequency < 1) {
                                throw new RuntimeException("Неверное значение");
                            }
                            patient.medicines.put(medName, frequency);

                        } catch (NumberFormatException e) {
                            System.out.println("Невеерное значение");
                            addPrescription();
                        }
                    }
                }
                if (s.equals("2")) {
                    while (true) {
                        System.out.println("Введите название процедуры: ");
                        String prName = reader.readLine();
                        if (prName.isBlank()) {
                            break;
                        }
                        System.out.println("Введите дни для процедур");
                        TreeSet<Day> days = new TreeSet<>();
                        while (true) {
                            try {
                                String sDay = reader.readLine();
                                if (sDay.isBlank()) {
                                    break;
                                }
                                Day day = Day.valueOf(reader.readLine());
                                days.add(day);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Неверные данные");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        patient.procedures.put(prName, days);
                    }
                }
                writePrescriptions();
            }
            else {
                System.out.println("Чужой пациент");
                addPrescription();
            }
        }

        @SneakyThrows
        public void writePrescriptions() {
            Patient patient = Server.currentPatient;
            File procedures = new File("procedures.txt");
            if (!procedures.exists()) {
                procedures.createNewFile();
            }
            BufferedWriter proceduresWriter = new BufferedWriter(new FileWriter(procedures.getName(), true));
            proceduresWriter.write(patient.getFirstName() + " " + patient.getLastName());

            File medicines = new File("medicines.txt");
            if (!medicines.exists()) {
                medicines.createNewFile();
            }

            BufferedWriter medicinesWriter = new BufferedWriter(new FileWriter(medicines.getName(), true));
            String strDays = "";
            medicinesWriter.write(patient.getFirstName() + " " + patient.getLastName());

                if (!patient.getProcedures().isEmpty()) {

                    for (Map.Entry<String, TreeSet<Day>> entry : patient.getProcedures().entrySet()) {
                        proceduresWriter.write("|" + entry.getKey() + "(");
                        for (Day day : entry.getValue()) {
                            strDays += day + ",";
                        }
                        proceduresWriter.write(strDays.substring(0, strDays.length() - 1));
                        proceduresWriter.write(")");
                    }
                    proceduresWriter.write("\n");
                }

                if (!patient.getMedicines().isEmpty()) {

                    for (Map.Entry<String, Integer> entry : patient.getMedicines().entrySet()) {
                        medicinesWriter.write("|" + entry.getKey() + "(" + entry.getValue() + ")" );
                    }

                    medicinesWriter.write("\n");
                }

            proceduresWriter.close();
            medicinesWriter.close();
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

            Patient current = new Patient(firstName, lastName, login, password, Server.currentDoctor, diagnosis);
            current.setDoctor(Server.currentDoctor);
            Server.patients.add(current);
            Server.currentDoctor.thisDoctorsPatients.add(current);
            Server.savePatient();
            doctorsMenu();
        }

        public void removeDoctor() {
        String speciality = Server.currentDoctor.getSpeciality();
        Doctor check = Server.currentDoctor;

        Server.doctors.remove(Server.currentDoctor);
            Server.patients.stream().filter(patient -> patient.getDoctor().equals(check))
        .forEach(patient -> { for (Doctor doctor : Server.doctors) {
                if (speciality.equals(doctor.getSpeciality())) {
                    patient.setDoctor(doctor);
                    break;
                }
            }
            if (patient.getDoctor().equals(check)) {
                patient.setDoctor(Server.doctors.get(new Random().nextInt(Server.doctors.size() - 1)));
            }});

            Server.updatePatients();

            System.out.println("Аккаунт удалён");
        }
}
