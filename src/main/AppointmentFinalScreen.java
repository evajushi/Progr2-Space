import java.awt.*;
import javax.swing.*;

public class AppointmentFinalScreen extends JFrame {
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;

    private GridBagConstraints gbc;

    public AppointmentFinalScreen() {
        setTitle("Επιβεβαίωση Ραντεβού");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color lightBlue = new Color(230, 245, 255);
        getContentPane().setBackground(lightBlue);

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints(); 

        showMessage(); 

        setVisible(true);
    }

    public void showMessage() {
        JLabel confirmationLabel = new JLabel("Το Ραντεβού σας έχει επιβεβαιωθεί!");
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 28));
        confirmationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        add(confirmationLabel, gbc);
    }

}
