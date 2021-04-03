package net.thumbtack.school.hospital.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class Procedure extends Prescription {
    public String name;
    public ArrayList<Day> days;
    public Doctor doctor;
}
