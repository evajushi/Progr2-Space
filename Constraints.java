import java.util.List;

public class Constraint {
    private String description;
    private List<Doctor> availableDoctors;

    public Constraint(String description, List<Doctor> availableDoctors) {
        this.description = description;
        this.availableDoctors = availableDoctors;
    }

    public String getDescription() {
        return description;
    }

    // Ελέγχει αν υπάρχει διαθέσιμος ιατρός την ώρα του ραντεβού.
    public boolean isSatisfied(Appointment appointment) {
        for (Doctor doctor : availableDoctors) {
            if (doctor.isAvailable(appointment.getTime())) {
                return true; // Υπάρχει διαθέσιμος ιατρός.
            }
        }
        return false; // Κανένας ιατρός δεν είναι διαθέσιμος.
    }
}

