package space;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OptimizationAlgorithm {
    private DatabaseManager dbManager;

    public OptimizationAlgorithm(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * Ελέγχει αν η ώρα είναι διαθέσιμη για την ειδικότητα και την ημερομηνία.
     * 
     * @param specialty Η ειδικότητα
     * @param date      Η ημερομηνία
     * @param time      Η ώρα
     * @return true αν η ώρα είναι διαθέσιμη, αλλιώς false
     */
    public boolean isTimeSlotAvailable(String specialty, String date, String time) {
        // Ανάκτηση ραντεβού για την ειδικότητα και την ημερομηνία
        List<Appointment> appointments = dbManager.getAppointmentsByDateAndSpecialty(date, specialty);

        // Έλεγχος αν η ώρα είναι κατειλημμένη
        for (Appointment appointment : appointments) {
            if (appointment.getDateTime().toLocalTime().toString().equals(time)) {
                return false; // Η ώρα είναι κατειλημμένη
            }
        }
        return true; // Η ώρα είναι διαθέσιμη
    }

    /**
     * Προτείνει εναλλακτικές ώρες για την επιλεγμένη ειδικότητα και ημερομηνία.
     * 
     * @param specialty Η ειδικότητα
     * @param date      Η ημερομηνία
     * @param doctors   Λίστα με τους διαθέσιμους γιατρούς
     * @return Λίστα με τις προτεινόμενες ώρες
     */
    public List<String> suggestAlternativeTimes(String specialty, String date, List<Doctor> doctors) {
        List<String> suggestedTimes = new ArrayList<>();

        // Ελέγξτε όλους τους γιατρούς της ειδικότητας
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialty)) {
                for (LocalTime time : doctor.getAvailableTimeSlots()) {
                    // Αν η ώρα είναι διαθέσιμη, προσθέστε την στις προτάσεις
                    if (isTimeSlotAvailable(specialty, date, time.toString())) {
                        suggestedTimes.add(time.toString());
                    }
                }
            }
        }

        // Επιστροφή των προτεινόμενων ωρών
        return suggestedTimes;
    }
}
