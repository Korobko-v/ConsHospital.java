package net.thumbtack.school.hospital.server;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Medicine extends Prescription {
    public String name;
    public int frequency;
    public Doctor doctor;
}
