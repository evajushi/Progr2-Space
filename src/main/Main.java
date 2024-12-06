package space;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Δημιουργία γιατρών
        Doctor doctor1 = new Doctor("John", "Doe", "Cardiology",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0)), 60);
        Doctor doctor2 = new Doctor("Jane", "Smith", "Pediatrics",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(12, 0)), 90);

        // Δημιουργία ασθενών
        Patient patient1 = new Patient("Alice", "Johnson", "1990-01-01", "123 Main St", "555-1234",
                "alice@example.com", "Healthy", "123456789", "Female");
        Patient patient2 = new Patient("Bob", "Brown", "1985-05-15", "456 Elm St", "555-5678",
                "bob@example.com", "Allergic", "987654321", "Male");

        // Δημιουργία ραντεβού
        Appointment appointment1 = new Appointment("Cardiology",
                LocalDateTime.of(2024, 12, 1, 9, 0), patient1, doctor1, 10, 30);
        Appointment appointment2 = new Appointment("Pediatrics",
                LocalDateTime.of(2024, 12, 1, 9, 0), patient2, doctor2, 8, 60);
        Appointment appointment3 = new Appointment("Cardiology",
                LocalDateTime.of(2024, 12, 1, 10, 0), patient1, doctor1, 7, 30);

        // Δημιουργία λιστών
        List<Doctor> doctors = Arrays.asList(doctor1, doctor2);
        List<Appointment> appointments = Arrays.asList(appointment1, appointment2, appointment3);

        // Βελτιστοποίηση ραντεβού
        OptimizationAlgorithm optimizer = new OptimizationAlgorithm(appointments, doctors);
        optimizer.optimizeSchedule();
    }
}
