package space;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ScheduleManagerTest {

    private ScheduleManager scheduleManager;
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;

    @Before
    public void setUp() {
        doctor = new Doctor("John", "Doe", "Cardiologist",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(10, 0)), 180);

        scheduleManager = new ScheduleManager(Arrays.asList(doctor));

        patient = new Patient("Alice", "Brown", "1990-05-15", "123 Main St", "555-1234",
                "alice@example.com", 123456789, "Female");

        appointment = new Appointment("Cardiologist", LocalDateTime.of(2024, 12, 9, 9, 0),
                patient, doctor, 1, 30);
    }

    @Test
    public void testAddAppointmentSuccess() {
        boolean result = scheduleManager.addAppointment(appointment);

        assertTrue(result);
    }

    @Test
    public void testAddAppointmentFailure() {
        // Εξαφανίζουμε τη διαθεσιμότητα για να προκαλέσουμε αποτυχία
        doctor.setAvailableMinutes(0);

        boolean result = scheduleManager.addAppointment(appointment);

        assertFalse(result);
    }

    @Test
    public void testPrintSchedule() {
        scheduleManager.addAppointment(appointment);
        scheduleManager.printSchedule();

        // Ελέγχουμε ότι η εκτέλεση ολοκληρώνεται χωρίς exceptions
        assertTrue(true);
    }
}
