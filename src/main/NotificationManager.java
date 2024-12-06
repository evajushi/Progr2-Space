package space;

import java.util.List;

public class NotificationManager {

    public void notifyDoctor(Doctor doctor, List<Appointment> schedule) {
        System.out.println("Notifying " + doctor.getFullname() + " of their schedule:");
        schedule.forEach(
                appointment -> System.out
                        .println("  - " + appointment.getDateTime() + " - " + appointment.getDetails()));
    }

    public void notifyPatient(Patient patient, Appointment appointment) {
        System.out.println("Reminder for " + patient.getName() + ": Your appointment is on " +
                appointment.getDateTime() + " with Dr. " + appointment.getDoctor().getFullname());
    }
}
