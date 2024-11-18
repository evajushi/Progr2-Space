public class Doctor {
    private String name;
    private String surname;
    private String specialization;
    private boolean availableTime;
    
    public Doctor(String name, String specialization, String availableTime, String surname) {
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.availableTime = availableTime;
    }
    public String getName() { 
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getSpecialization() { 
        return specialization;
    }
    public boolean getAvailableTime() { 
        return availableTime;
    }
    @Override
    public String toString() {
        return  "Dr. " + name + " " + surname + " - Specialization: " + specialization + " | Available: " + availableTime;
    }
}
