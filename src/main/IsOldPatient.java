import javax.swing.*;
import java.awt.*;

class IsOldPatient extends JFrame {

    public IsOldPatient() {
    	
        setTitle("ΑΦΜ");
        setSize(2000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color lightBlue = new Color(230, 245, 255);
        getContentPane().setBackground(lightBlue);

        setLayout(new BorderLayout(10, 10));

        JLabel amkaLabel = new JLabel("Παρακαλώ εισάγετε το ΑΜΚΑ σας:");
        amkaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        amkaLabel.setForeground(Color.BLACK);
        amkaLabel.setHorizontalAlignment(SwingConstants.LEFT);
        amkaLabel.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 0));

        JTextField amka = new JTextField();
        amka.setFont(new Font("Arial", Font.PLAIN, 14));
        amka.setPreferredSize(new Dimension(500, 30)); 
        amka.setMaximumSize(new Dimension(500, 30));

        JButton submitButton = new JButton("Υποβολή");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(173, 216, 230));
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(lightBlue);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(amka);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(submitButton);

        add(amkaLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        setVisible(true);
        
    }

    public static void main(String[] args) {
    	
        new IsOldPatient();
        
    }
  
}
