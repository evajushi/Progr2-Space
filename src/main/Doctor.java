import java.util.List;

public class Doctor {
    private String name;
    private String specialty;
    private List<String> availableTimes;

    public Doctor(String name, String specialty, List<String> availableTimes) {
        this.name = name;
        this.specialty = specialty;
        this.availableTimes = availableTimes;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void displayAvailableTimes() {
        System.out.println("Available times for Dr. " + name + " (" + specialty + "): " + availableTimes);
    }
}
