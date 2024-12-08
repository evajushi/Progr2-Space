package space;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NotificationManagerTest {

    private NotificationManager notificationManager;
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;

    @Before
    public void setUp() {
        notificationManager = new NotificationManager();

        doctor = new Doctor("John", "Doe", "Cardiologist",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(10, 0)), 180);

        patient = new Patient("Alice", "Brown", "1990-05-15", "123 Main St", "555-1234",
                "alice@example.com", 123456789, "Female");

        appointment = new Appointment("Cardiologist", LocalDateTime.of(2024, 12, 9, 9, 0),
                patient, doctor, 1, 30);
    }

    @Test
    public void testNotifyDoctor() {
        List<Appointment> schedule = Arrays.asList(appointment);
        notificationManager.notifyDoctor(doctor, schedule);

        // Ελέγχουμε ότι η εκτέλεση ολοκληρώνεται χωρίς exceptions
        assertTrue(true);
    }

    @Test
    public void testNotifyPatient() {
        List<Appointment> schedule = Arrays.asList(appointment);
        notificationManager.notifyPatient(patient, schedule);

        // Ελέγχουμε ότι η εκτέλεση ολοκληρώνεται χωρίς exceptions
        assertTrue(true);
    }
}
