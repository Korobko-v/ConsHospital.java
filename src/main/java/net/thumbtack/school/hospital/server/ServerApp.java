package net.thumbtack.school.hospital.server;

import java.io.File;
import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        File doctorFile = new File("doctors.txt");
        File patientFile = new File("patients.txt");

        if (!doctorFile.exists()) {
            doctorFile.createNewFile();
        }
        if (!patientFile.exists()) {
            patientFile.createNewFile();
        }

        Server server = new Server();
        server.startServer(doctorFile.getName());
        server.stopServer(doctorFile.getName());
    }
}
