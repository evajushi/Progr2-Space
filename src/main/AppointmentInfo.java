import javax.swing.*;
import java.awt.*;
import javax.swing.text.MaskFormatter;
import javax.swing.border.TitledBorder;

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

     private void selectAppointment() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 60, 20, 20); 
        gbc.anchor = GridBagConstraints.WEST; 

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        JLabel label = new JLabel("Επιλέξτε τύπο ραντεβού");
        label.setFont(new Font("Arial", Font.PLAIN, 22));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);
        
        String[] options = {"Παθολόγος", "Καρδιολόγος", "Γυναικολόγος", "Ορθοπαιδικός", "Δερματολόγος", 
                            "Παιδίατρος", "Νευρολόγος", "Ενδοκρινολόγος", "Ψυχίατρος", "Οφθαλμίατρος"};
        
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox.setPreferredSize(new Dimension(420, 40));
        panel.add(comboBox, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; 
        add(panel, gbc);
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
