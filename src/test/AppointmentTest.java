import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Before;

public class AppointmentTest {

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;

    @Before
    public void setUp() {
        patient = new Patient("Maria", "Berg", "2000-06-01", "567 Main Street", "890-0987", "mariaberg@example.com", "Female", "123456789");
        doctor = new Doctor ("John", "Doe", "Cardiologist", null, 180);
        appointment = new Appointment("Cardiologist", LocalDateTime.of(2024, 12, 9, 9, 0), patient, doctor, 1, 30);
    }

    @Test
    public void testAppointment() {

        assertEquals("Specialization: Cardiologist, Patient: Maria Berg, Doctor: John Doe", appointment.getDetails());
    }
       
    @Test
    public void testGetDateTime() {
        assertEquals(LocalDateTime.of(2024, 12, 9, 9, 0), appointment.getDateTime());

    }
}
