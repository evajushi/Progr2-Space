import java.util.List;

public class NotificationManager {
    /**
     * Ειδοποιεί τον γιατρό για το καθημερινό του πρόγραμμα.
     * 
     * @param doctor Ο γιατρός
     * @param Λίστα  με τα ραντεβού του γιατρού
     */
    public void notifyDoctor(Doctor doctor, List<Appointment> schedule) {
        System.out.println("Notifying " + doctor.getFullname() + " of their schedule:");
        schedule.forEach(
                appointment -> System.out.println(appointment.getDateTime() + " - " + appointment.getDetails()));
    }

    /**
     * Ειδοποιεί τον ασθενη για το ραντεβου του
     * 
     * @param patient     Ο ασθενής
     * @param appointment Το ραντεβού
     */
    public void notifyPatient(Patient patient, Appointment appointment) {
        System.out.println("Reminder for " + patient.getName() + ": Your appointment is on " +
                appointment.getDateTime());
    }
}
