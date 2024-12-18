import javax.swing.*;
import java.awt.*;

public class AppointmentInfo extends JFrame {
    private static final int WINDOW_WIDTH = 1200; 
    private static final int WINDOW_HEIGHT = 800;

    public AppointmentInfo() {
        setTitle("Κλείστε Ραντεβού");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Color lightBlue = new Color(230, 245, 255); 
        getContentPane().setBackground(lightBlue);
        
        setLayout(new GridBagLayout());  
        
        selectAppointment();
        selectDateAndTime();
        addButton();
    }

private void addButton() {
        JButton submitButton = new JButton("Συνέχεια");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setBackground(new Color(173, 216, 230));
        submitButton.setForeground(Color.BLACK);
        submitButton.setPreferredSize(new Dimension(120, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(100, 20, 20, 20); 
        gbc.anchor = GridBagConstraints.CENTER; 
        add(submitButton, gbc); 
    }
public static void main(String[] args) {
        DocInfo frame = new DocInfo(); 
        frame.setVisible(true);        
    }
}
