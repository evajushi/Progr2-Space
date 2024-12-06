package space;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public ScheduleManager(List<Doctor> doctors) {
        this.doctors = doctors;
        this.appointments = new ArrayList<>();
    }

    public boolean addAppointment(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        LocalTime appointmentTime = appointment.getDateTime().toLocalTime();

        if (doctor.isAvailable(appointmentTime) && doctor.getAvailableMinutes() >= appointment.getDuration()) {
            doctor.setAvailableMinutes(doctor.getAvailableMinutes() - appointment.getDuration());
            appointments.add(appointment);
            System.out.println("Appointment added: " + appointment.getDetails());
            return true;
        } else {
            System.out.println("Doctor is not available or does not have enough time for: " +
                    appointment.getDetails());
            return false;
        }
    }

    public void printSchedule() {
        System.out.println("---- Full Schedule ----");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
            appointments.stream()
                    .filter(appointment -> appointment.getDoctor().equals(doctor))
                    .forEach(appointment -> System.out.println("  - " + appointment.getDetails() +
                            " at " + appointment.getDateTime()));
        }
    }
}
