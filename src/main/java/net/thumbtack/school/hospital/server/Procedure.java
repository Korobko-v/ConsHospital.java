package net.thumbtack.school.hospital.server;

import lombok.AllArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
public class Procedure {
    public String name;
    public ArrayList<Day> days;
    public Doctor doctor;
}
