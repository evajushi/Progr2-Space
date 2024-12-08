package space;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {

    private Patient patient;

    @Before
    public void setUp() {
        patient = new Patient("Alice", "Brown", "1990-05-15", "123 Main St", "555-1234",
                "alice@example.com", 123456789, "Female");
    }

    @Test
    public void testGetName() {
        assertEquals("Alice", patient.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Brown", patient.getSurname());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals("1990-05-15", patient.getDateOfBirth());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", patient.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("555-1234", patient.getPhoneNumber());
    }

    @Test
    public void testGetEmail() {
        assertEquals("alice@example.com", patient.getEmail());
    }

    @Test
    public void testGetAmka() {
        assertEquals(123456789, patient.getAmka());
    }

    @Test
    public void testGetGender() {
        assertEquals("Female", patient.getGender());
    }

    @Test
    public void testToString() {
        String expected = "Patient{name='Alice', surname='Brown', dateOfBirth='1990-05-15', address='123 Main St', " +
                "phoneNumber='555-1234', email='alice@example.com', amka='123456789', gender='Female'}";
        assertEquals(expected, patient.toString());
    }
}
