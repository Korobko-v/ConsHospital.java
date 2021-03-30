package net.thumbtack.school.hospital.server;

import java.io.File;
import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        Server server = new Server();
        server.startServer(file.getName());
        server.stopServer(file.getName());
    }
}
