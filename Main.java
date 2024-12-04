import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Δημιουργία γιατρών
        Doctor doctor1 = new Doctor("John", "Doe", "Cardiology", 
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0)));
        Doctor doctor2 = new Doctor("Jane", "Smith", "Pediatrics", 
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(12, 0)));

        // Δημιουργία ασθενή
        Patient patient1 = new Patient("Alice", "Johnson", "1990-01-01", "123 Main St", "555-1234", 
                "alice@example.com", "Healthy", "123456789", "Female");

        // Δημιουργία ραντεβού
        Appointment appointment1 = new Appointment("Cardiology", 
                LocalDateTime.of(2024, 12, 1, 10, 0), patient1, doctor1, 1, 30);

        // Δημιουργία ScheduleManager
        ScheduleManager manager = new ScheduleManager(Arrays.asList(doctor1, doctor2));

        // Προσθήκη ραντεβού
        manager.addAppointment(appointment1);

        // Εκτύπωση πλήρους προγράμματος
        manager.printSchedule();
    }
}

