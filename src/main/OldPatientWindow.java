import javax.swing.*;
import java.awt.*;

class OldPatientWindow extends JFrame {
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private static final int FIELD_WIDTH = 20;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 50;
    private String selectedDate;
    private String selectedTime;

    public OldPatientWindow(String date, String time) {

        this.selectedDate = date;
        this.selectedTime = time;
        
        setTitle("AMKA");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color lightBlue = new Color(230, 245, 255);
        getContentPane().setBackground(lightBlue);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 20); 
        gbc.anchor = GridBagConstraints.CENTER; 

        createAmkaLabel(gbc);

        createAmkaField(gbc);

        createSubmitButton(gbc);

        setVisible(true);
        
    }

    private void createAmkaLabel(GridBagConstraints gbc) {
        
        JLabel amkaLabel = new JLabel("Παρακαλώ εισάγετε το ΑΜΚΑ σας:");
        amkaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        amkaLabel.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amkaLabel, gbc);
        
    }
    
    private void createAmkaField(GridBagConstraints gbc) {
        
        JTextField amka = new JTextField(20);
        amka.setFont(new Font("Arial", Font.PLAIN, 20));
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(amka, gbc);
        
    }

    private void createSubmitButton(GridBagConstraints gbc) {

        JButton submitButton = new JButton("Υποβολή");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(173, 216, 230));
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            dispose();
            new AppointmentFinalScreen(selectedDate, selectedTime); 
        });

    }


    public static void main(String[] args) {
    	
        new OldPatientWindow("__/__/___", "9:00");
        
    }
  
}
