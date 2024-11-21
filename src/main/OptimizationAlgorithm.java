import com.google.ortools.linearsolver.*;

import java.util.List;

public class OptimizationAlgorithm {
    static {
        System.loadLibrary("jniortools"); // Φορτώνει τις βιβλιοθήκες OR-Tools
    }

    private List<Appointment> appointments;
    private List<Doctor> doctors;

    public OptimizationAlgorithm(List<Appointment> appointments, List<Doctor> doctors) {
        this.appointments = appointments;
        this.doctors = doctors;
    }

    public void optimizeSchedule() {
        Solver solver = Solver.createSolver("GLOP"); // Χρήση γραμμικού επιλυτή

        if (solver == null) {
            System.out.println("Linear solver is not available.");
            return;
        }

        // 1. Μεταβλητές: Ραντεβού ανά γιατρό
        int numDoctors = doctors.size();
        int numAppointments = appointments.size();
        Variable[][] x = new Variable[numDoctors][numAppointments];

        for (int i = 0; i < numDoctors; i++) {
            for (int j = 0; j < numAppointments; j++) {
                x[i][j] = solver.makeIntVar(0, 1, "x_" + i + "_" + j);
            }
        }

        // 2. Περιορισμός 1: Ένα ραντεβού ανατίθεται σε έναν γιατρό
        for (int j = 0; j < numAppointments; j++) {
            LinearExpr.Builder constraint = LinearExpr.newBuilder();
            for (int i = 0; i < numDoctors; i++) {
                constraint.addTerm(x[i][j], 1);
            }
            solver.addConstraint(constraint.build(), 1, 1); // Κάθε ραντεβού ανατίθεται σε έναν γιατρό
        }

        // 3. Περιορισμός 2: Τα ραντεβού δεν υπερβαίνουν τη διαθεσιμότητα των γιατρών
        for (int i = 0; i < numDoctors; i++) {
            LinearExpr.Builder constraint = LinearExpr.newBuilder();
            for (int j = 0; j < numAppointments; j++) {
                constraint.addTerm(x[i][j], appointments.get(j).getDuration());
            }
            solver.addConstraint(constraint.build(), 0, doctors.get(i).getAvailableMinutes());
        }

        // 4. Στόχος: Ελαχιστοποίηση κενών χρόνων
        LinearExpr.Builder objective = LinearExpr.newBuilder();
        for (int i = 0; i < numDoctors; i++) {
            for (int j = 0; j < numAppointments; j++) {
                objective.addTerm(x[i][j], appointments.get(j).getPriority());
            }
        }
        solver.objective().setMaximization();
        solver.objective().setLinearExpr(objective.build());

        // 5. Επίλυση
        Solver.ResultStatus resultStatus = solver.solve();
        if (resultStatus == Solver.ResultStatus.OPTIMAL) {
            System.out.println("Optimal solution found:");
            for (int i = 0; i < numDoctors; i++) {
                for (int j = 0; j < numAppointments; j++) {
                    if (x[i][j].solutionValue() == 1.0) {
                        System.out.println("Appointment " + j + " assigned to Doctor " + i);
                    }
                }
            }
        } else {
            System.out.println("No optimal solution found.");
        }
    }
}
