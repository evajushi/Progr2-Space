package space;

import java.util.List;

public class NotificationManager {

    public void notifyDoctor(Doctor doctor, List<Appointment> schedule) {
        System.out.println("Notifying " + doctor.getFullname() + " of their schedule:");
        schedule.stream()
                .filter(appointment -> appointment.getDoctor().equals(doctor))
                .forEach(appointment -> System.out.println("  - " + appointment));
    }

    public void notifyPatient(Patient patient, List<Appointment> schedule) {
        System.out.println("Notifying " + patient.getName() + " of their appointments:");
        schedule.stream()
            .filter(appointment -> appointment.getDetails().contains(patient.getName()))
            .forEach(appointment -> System.out.println("  - " + appointment));
    }
}
