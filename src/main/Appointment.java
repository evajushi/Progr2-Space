public class Appointment {

    private String specialization;
    private String time;
    private String date;
    private Patient patient;

    public Appointment(String specializatiion, String time, String date, Patient patient) {

        this.specialization = specialization;
        this.time = time;
        this.date = date;
        this.patient = patient;
    }

    public String getSpecialization() {

        return specialization;
    }

    public String getTime(){

        return time;
    }

    public String getDate(){

        return date;
    }

    public Patient getPatient(){
        return patient;
    }

    @Override
    public String toString() {
        
        return "Appointment{" + "specialization='" + specialization + '\'' +
         ", time='" + time + '\'' + ", date='" + date + '\'' + ", patient=" + patient.getName() + '}';
    }
} 
