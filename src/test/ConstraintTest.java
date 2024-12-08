package space;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ConstraintTest {

    private Constraint constraint;
    private Doctor doctor;
    private Appointment appointment;

    @Before
    public void setUp() {
        doctor = new Doctor("John", "Doe", "Cardiologist",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(10, 0)), 180);
        constraint = new Constraint(Arrays.asList(doctor));

        appointment = new Appointment("Cardiologist", LocalDateTime.of(2024, 12, 9, 9, 0),
                null, doctor, 1, 30);
    }

    @Test
    public void testIsSatisfied() {
        assertTrue(constraint.isSatisfied(appointment));
    }
}
