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
        appointments.add(appointment);
        System.out.println("Appointment added successfully.");
        return true;
    }

    public void optimizeSchedule() {
        System.out.println("Optimizing schedule...");
        OptimizationAlgorithm optimizer = new OptimizationAlgorithm(appointments, doctors);
        optimizer.optimizeSchedule();
    }

    public void printSchedule() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getDetails());
        }
    }
}
