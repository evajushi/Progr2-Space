package space;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AppointmentTest {

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;

    @Before
    public void setUp() {
        patient = new Patient("Alice", "Brown", "1990-05-15", "123 Main St", "555-1234",
                "alice@example.com", 123456789, "Female");
        doctor = new Doctor("John", "Doe", "Cardiologist", null, 180);

        appointment = new Appointment("Cardiologist", LocalDateTime.of(2024, 12, 9, 9, 0),
                patient, doctor, 1, 30);
    }

    @Test
    public void testAppointmentDetails() {
        assertEquals("Specialization: Cardiologist, Patient: Alice, Doctor: John Doe",
                appointment.getDetails());
    }

    @Test
    public void testGetDateTime() {
        assertEquals(LocalDateTime.of(2024, 12, 9, 9, 0), appointment.getDateTime());
    }
}
