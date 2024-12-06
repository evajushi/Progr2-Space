package space;

import java.time.LocalTime;
import java.util.List;

public class Constraint {
    private List<Doctor> availableDoctors;

    public Constraint(List<Doctor> availableDoctors) {
        if (availableDoctors == null || availableDoctors.isEmpty()) {
            throw new IllegalArgumentException("Available doctors cannot be null or empty");
        }
        this.availableDoctors = availableDoctors;
    }

    public boolean isSatisfied(Appointment appointment) {
        LocalTime time = appointment.getDateTime().toLocalTime();
        return availableDoctors.stream().anyMatch(doctor -> doctor.isAvailable(time));
    }

    @Override
    public String toString() {
        return "Constraint{" + "availableDoctors=" + availableDoctors + '}';
    }
}
