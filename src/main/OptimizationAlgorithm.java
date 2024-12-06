package space;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimizationAlgorithm {
    private List<Appointment> appointments;
    private List<Doctor> doctors;

    public OptimizationAlgorithm(List<Appointment> appointments, List<Doctor> doctors) {
        this.appointments = appointments;
        this.doctors = doctors;
    }

    public void optimizeSchedule() {
        // Ταξινόμηση ραντεβού κατά προτεραιότητα (από υψηλή σε χαμηλή)
        appointments.sort(Comparator.comparingInt(Appointment::getPriority).reversed());

        // Κατανομή ραντεβού στους διαθέσιμους γιατρούς
        List<Appointment> unassignedAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            boolean assigned = false;

            for (Doctor doctor : doctors) {
                // Έλεγχος ειδικότητας
                if (!doctor.getSpecialization().equalsIgnoreCase(appointment.getDoctor().getSpecialization())) {
                    continue;
                }

                // Έλεγχος διαθεσιμότητας για το συγκεκριμένο χρονικό διάστημα
                if (doctor.isAvailable(appointment.getDateTime().toLocalTime())
                        && doctor.getAvailableMinutes() >= appointment.getDuration()) {

                    // Ενημέρωση διαθέσιμων λεπτών του γιατρού
                    doctor.setAvailableMinutes(doctor.getAvailableMinutes() - appointment.getDuration());

                    // Εμφάνιση ανάθεσης
                    System.out.println("Assigned: " + appointment.getDetails() +
                            " to Doctor: " + doctor.getFullname());
                    assigned = true;
                    break;
                }
            }

            // Αν το ραντεβού δεν βρήκε διαθέσιμο γιατρό
            if (!assigned) {
                System.out.println("Could not assign appointment: " + appointment.getDetails());
                unassignedAppointments.add(appointment);
            }
        }

        // Εμφάνιση μη ανατεθειμένων ραντεβού
        if (!unassignedAppointments.isEmpty()) {
            System.out.println("\n--- Unassigned Appointments ---");
            for (Appointment unassigned : unassignedAppointments) {
                System.out.println(unassigned.getDetails() + " at " + unassigned.getDateTime());
            }
        }
    }
}
