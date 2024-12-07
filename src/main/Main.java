package space;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Δημιουργία γιατρών
                List<Doctor> doctors = Arrays.asList(
                                new Doctor("John", "Doe", "Cardiology", Arrays.asList(
                                                LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0)), 90),
                                new Doctor("Jane", "Smith", "Pediatrics", Arrays.asList(
                                                LocalTime.of(9, 0), LocalTime.of(12, 0)), 120));

                // Ζήτηση στοιχείων ασθενή από τον χρήστη
                System.out.println("Καλώς ήλθατε στο σύστημα DocOptimizer!");
                System.out.print("Εισάγετε το όνομα σας: ");
                String name = scanner.nextLine();

                System.out.print("Εισάγετε το επίθετο σας: ");
                String surname = scanner.nextLine();

                System.out.print("Εισάγετε την ημερομηνία γέννησης σας (π.χ., 1990-01-01): ");
                String dateOfBirth = scanner.nextLine();

                System.out.print("Εισάγετε τη διεύθυνση σας: ");
                String address = scanner.nextLine();

                System.out.print("Εισάγετε τον αριθμό τηλεφώνου σας: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Εισάγετε το email σας: ");
                String email = scanner.nextLine();

                System.out.print("Εισάγετε το ΑΜΚΑ σας: ");
                int amka = scanner.nextInt();

                System.out.print("Εισάγετε το φύλο σας (Male/Female): ");
                String gender = scanner.nextLine();

                Patient patient = new Patient(name, surname, dateOfBirth, address, phoneNumber, email, amka, gender);
                System.out.println("Ο ασθενής δημιουργήθηκε επιτυχώς: " + patient);

                // Ζήτηση ειδικότητας γιατρού
                System.out.println("\nΔιαθέσιμες Ειδικότητες:");
                doctors.stream().map(Doctor::getSpecialization).distinct().forEach(System.out::println);
                System.out.print("Επιλέξτε την ειδικότητα του γιατρού σας: ");
                String selectedSpecialization = scanner.nextLine();

                // Εύρεση διαθέσιμων γιατρών με βάση την ειδικότητα
                List<Doctor> filteredDoctors = doctors.stream()
                                .filter(doc -> doc.getSpecialization().equalsIgnoreCase(selectedSpecialization))
                                .toList();

                if (filteredDoctors.isEmpty()) {
                        System.out.println("Δυστυχώς δεν υπάρχουν διαθέσιμοι γιατροί για την επιλεγμένη ειδικότητα.");
                        scanner.close();
                        return;
                }

                // Ζήτηση ώρας ραντεβού
                System.out.println("\nΔιαθέσιμες Ώρες:");
                filteredDoctors.stream()
                                .flatMap(doc -> doc.getAvailableTimeSlots().stream())
                                .distinct()
                                .forEach(System.out::println);
                System.out.print("Επιλέξτε την ώρα του ραντεβού σας (π.χ., 10:00): ");
                String selectedTime = scanner.nextLine();
                LocalTime appointmentTime = LocalTime.parse(selectedTime);

                // Εύρεση διαθέσιμου γιατρού
                Doctor selectedDoctor = filteredDoctors.stream()
                                .filter(doc -> doc.isAvailable(appointmentTime))
                                .findFirst()
                                .orElse(null);

                if (selectedDoctor == null) {
                        System.out.println("Δυστυχώς δεν υπάρχουν διαθέσιμοι γιατροί για την επιλεγμένη ώρα.");
                        scanner.close();
                        return;
                }

                // Δημιουργία ραντεβού
                LocalDateTime appointmentDateTime = LocalDateTime.of(2024, 12, 6, appointmentTime.getHour(),
                                appointmentTime.getMinute());
                Appointment appointment = new Appointment(selectedSpecialization, appointmentDateTime, patient,
                                selectedDoctor, 1, 30);

                // Κλήση αλγορίθμου βελτιστοποίησης
                List<Appointment> appointments = new ArrayList<>();
                appointments.add(appointment);

                OptimizationAlgorithm optimizer = new OptimizationAlgorithm(appointments, doctors);
                optimizer.optimizeSchedule();

                System.out.println("Το ραντεβού σας δημιουργήθηκε επιτυχώς!");
                scanner.close();
        }
}
