import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Appointment> appointments; // Λίστα με όλα τα ραντεβού
    private List<Doctor> doctors;          // Λίστα με όλους τους γιατρούς

    public ScheduleManager(List<Doctor> doctors) {
        this.appointments = new ArrayList<>();
        this.doctors = doctors;
    }

    /**
     * Προσθέτει ένα νέο ραντεβού στο πρόγραμμα.
     * @param appointment Το ραντεβού που προστίθεται
     * @return true αν προστεθεί επιτυχώς, αλλιώς false.
     */
    public boolean addAppointment(Appointment appointment) {
        if (checkConflicts(appointment)) {
            System.out.println("Conflict detected! Appointment cannot be added.");
            return false;
        }
        appointments.add(appointment);
        System.out.println("Appointment added successfully.");
        return true;
    }

    /**
     * Αφαιρεί ένα ραντεβού από το πρόγραμμα.
     * @param appointment Το ραντεβού προς αφαίρεση
     * @return true αν αφαιρεθεί επιτυχώς, αλλιώς false.
     */
    public boolean removeAppointment(Appointment appointment) {
        if (appointments.remove(appointment)) {
            System.out.println("Appointment removed successfully.");
            return true;
        }
        System.out.println("Appointment not found.");
        return false;
    }

    /**
     * Ελέγχει αν υπάρχει σύγκρουση μεταξύ του νέου ραντεβού και των υπαρχόντων.
     * @param newAppointment Το νέο ραντεβού
     * @return true αν υπάρχει σύγκρουση, αλλιώς false.
     */
    public boolean checkConflicts(Appointment newAppointment) {
        for (Appointment existing : appointments) {
            if (existing.getDoctor().equals(newAppointment.getDoctor()) &&
                overlap(existing, newAppointment)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ευθυγραμμίζει και βελτιστοποιεί το πρόγραμμα ραντεβού χρησιμοποιώντας Linear Programming.
     */
    public void optimizeSchedule() {
        System.out.println("Optimizing schedule...");
        OptimizationAlgorithm optimizer = new OptimizationAlgorithm(appointments, doctors);
        optimizer.optimizeSchedule();
    }

    /**
     * Επιστρέφει το ημερήσιο πρόγραμμα ενός γιατρού.
     * @param doctor Ο γιατρός
     * @return Λίστα με τα ραντεβού του γιατρού
     */
    public List<Appointment> getDailySchedule(Doctor doctor) {
        List<Appointment> dailySchedule = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                dailySchedule.add(appointment);
            }
        }
        return dailySchedule;
    }

    /**
     * Εκτυπώνει το πλήρες πρόγραμμα για όλους τους γιατρούς.
     */
    public void printSchedule() {
        System.out.println("Full schedule:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    /**
     * Ελέγχει αν δύο ραντεβού επικαλύπτονται.
     * @param a1 Το πρώτο ραντεβού
     * @param a2 Το δεύτερο ραντεβού
     * @return true αν επικαλύπτονται, αλλιώς false.
     */
    private boolean overlap(Appointment a1, Appointment a2) {
        return a1.getDateTime().isBefore(a2.getDateTime().plusMinutes(a2.getDuration())) &&
               a2.getDateTime().isBefore(a1.getDateTime().plusMinutes(a1.getDuration()));
    }
}
