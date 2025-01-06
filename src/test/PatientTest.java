import org.junit.jupiteer.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.juniter.api.Assertions.*;
class PatientTest {
    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient("Maria", "Berg", "2000-06-01", "567 Main Street", "890-0987", "mariaberg@example.com", "Female", "123456789");
    }

    @Test
    void testGetName() {
        assertEquals("Maria", patient.getName());
    }

    @Test
    void testGetSurname() {
        assertEquals("Berg", patient.getSurname());
    }

    @Test
    void testGetDateOfBirth() {
        assertEquals("2000-06-01", patient.getDateOfBirth());
    }

    @Test
    void testGetAddress() {
        assertEquals("567 Main Street", patient.getAddress());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals("890-0987", patient.getPhoneNumber());
    }

    @Test
    void testGetEmail() {
        assertEquals("mariaberg@example.com", patient.getEmail());
    }

    @Test
    void testGetAmka() {
        assertEquals("123456789", patient.getAmka());
    }

    @Test
    void testGetGender() {
        assertEquals("Female", patient.getGender());
    }

    @Test
    void testToString() {
        String expected = "Patient{name='Maria', surname='Berg', dateOfBirth='2000-06-01', address='567 Main Street', phoneNumber='890-0987', email='mariaberg@example.com', amka='123456789', gender='Female'}";
        assertEquals(expected, patient.toString());
    }
}
