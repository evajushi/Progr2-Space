import java.time.LocalTime;
import java.util.List;

public class Constraint {
    private List<Doctor> availableDoctors;

    public Constraint(String description, List<Doctor> availableDoctors) {
        this.availableDoctors = availableDoctors;
    }

    public boolean isSatisfied(Appointment appointment) {
        LocalTime time = appointment.getDateTime().toLocalTime();
        for (Doctor doctor : availableDoctors) {
            if (doctor.isAvailable(time)) {
                return true; // Υπάρχει διαθέσιμος γιατρός.
            }
        }
        return false; // Κανένας γιατρός δεν είναι διαθέσιμος.
    }
}
