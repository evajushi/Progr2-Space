import java.util.List;

public class OptimizationAlgorithm {
    private List<Doctor> availableDoctors;

    public OptimizationAlgorithm(List<Doctor> availableDoctors) {
        this.availableDoctors = availableDoctors;
    }

    public Appointment findAlternative(Appointment initialAppointment) {
        for (Doctor doctor : availableDoctors) {
            for (String time : doctor.getAvailableTimes()) {
                if (!time.equals(initialAppointment.getTime())) {
                    // Βρέθηκε εναλλακτική ώρα.
                    System.out.println("Εναλλακτική ώρα: " + time + " με τον ιατρό: " + doctor.getName());
                    return new Appointment(time);
                }
            }
        }
        System.out.println("Δεν βρέθηκε εναλλακτική ώρα.");
        return null; // Δεν βρέθηκε εναλλακτική.
    }
}
