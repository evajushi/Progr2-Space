import javax.swing.*;
import java.awt.*;

class IsOldPatient extends JFrame {

    public IsOldPatient() {
    	
        setTitle("AMKA");
        setSize(2000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color lightBlue = new Color(230, 245, 255);
        getContentPane().setBackground(lightBlue);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 20); 
        gbc.anchor = GridBagConstraints.CENTER; 

        JLabel amkaLabel = new JLabel("Παρακαλώ εισάγετε το ΑΜΚΑ σας:");
        amkaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        amkaLabel.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amkaLabel, gbc);

        JTextField amka = new JTextField(20);
        amka.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(amka, gbc);

        JButton submitButton = new JButton("Υποβολή");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(submitButton, gbc);

        setLocationRelativeTo(null);
        
        setVisible(true);
        
    }

    public static void main(String[] args) {
    	
        new IsOldPatient();
        
    }
  
}
