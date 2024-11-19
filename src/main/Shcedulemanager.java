import java.util.ArrayList;
import java.util.List;
public class ScheduleManager { //Αναλαμβανει την διαχειρηση των ραντεβου ,των γιατρων και των ραντεβου
    private List<Appointment> appointments;
    public ScheduleManager() {
        this.appointments = new ArrayList<>();
    }
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    public void bookAppointment(String time, String date, Patient patient, String doctorName, String doctorSurname) {
        Doctor availableDoctor = findAvailableDoctor(doctorName);
        if (availableDoctor != null) {
            Appointment appointment = new Appointment(date, time, availableDoctor, patient);
            appointments.add(appointment);
            availableDoctor.setAvailability(false);
            System.out.println("To ραντεβου εχει κλεισει: " + appointment);
        } else {
            System.out.println("O Γιατρος δεν ειναι διαθεσιμος.");
        }
    }
    public Doctor findAvailableDoctor(String name) {
        for (Appointment appointment : appointments) {
            Doctor doctor = appointment.getDoctor();
            if (doctor.getName().equalsIgnoreCase(name) && doctor.isAvailable()) {
                return doctor;
            }
        }
        return null; 
    }
    public void showAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Κανενα ραντεβου κλεισμενο.");
        } else {
            appointments.forEach(System.out::println);
        }
    }
}
