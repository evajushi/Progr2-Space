package space;

import java.time.LocalTime;
import java.util.List;

public class Doctor {
    private String name;
    private String surname;
    private String specialization;
    private List<LocalTime> availableTimeSlots;
    private int availableMinutes; // Συνολικός διαθέσιμος χρόνος σε λεπτά

    public Doctor(String name, String surname, String specialization, List<LocalTime> availableTimeSlots,
            int availableMinutes) {
        if (name == null || surname == null || specialization == null || availableTimeSlots == null) {
            throw new IllegalArgumentException("Doctor fields cannot be null");
        }
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.availableTimeSlots = availableTimeSlots;
        this.availableMinutes = availableMinutes;
    }

    public boolean isAvailable(LocalTime time) {
        return availableTimeSlots.contains(time);
    }

    public int getAvailableMinutes() {
        return availableMinutes;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setAvailableMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Available minutes cannot be negative");
        }
        this.availableMinutes = minutes;
    }

    public String getFullname() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Dr. " + name + " " + surname + " - Specialization: " + specialization +
                " | Available slots: " + availableTimeSlots + " | Available minutes: " + availableMinutes;
    }
}
