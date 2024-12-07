package space;

public class Patient {

    private String name;
    private String surname;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private int amka;
    private String gender;

    public Patient(String name, String surname, String dateOfBirth, String address, String phoneNumber, String email,
            int amka, String gender) {

        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.amka = amka;
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public String getAddress() {

        return address;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getEmail() {

        return email;
    }

    public int getAmka() {

        return amka;
    }

    public String getGender() {

        return gender;
    }

    @Override
    public String toString() {

        return "Patient{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", dateOfBirth='" + dateOfBirth
                + '\'' +
                ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' +
                '\'' + ", amka='" + amka + '\'' + ", gender='" + gender + '\''
                + '}';
    }
}
