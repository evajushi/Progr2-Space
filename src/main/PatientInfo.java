import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInfo extends JFrame {
    private JButton yesButton;
    private JButton noButton;
    
    public PatientInfo() {
        setTitle("Στοιχεία Ασθενή");
        setSize(2000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Color lightBlue = new Color(230, 245, 255); 
        getContentPane().setBackground(lightBlue);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        
        //ρωτάμε τον χρήστη αν έχει ξανακλείσει ραντεβού, ώστε να συλλέξουμε τα στοιχεία του από τη βάση δεδομένων, εφόσον αυτό είναι δυνατό
        JLabel questionLabel = new JLabel("Έχετε ξανακλείσει ραντεβού;", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel.setForeground(Color.BLACK);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        add(questionLabel, gbc);

        yesButton = new JButton("Ναι");
        noButton = new JButton("Όχι");
        
        Dimension buttonSize = new Dimension(120, 50);
        yesButton.setPreferredSize(buttonSize);
        noButton.setPreferredSize(buttonSize);

        yesButton.setBackground(new Color(173, 216, 230)); 
        noButton.setBackground(new Color(173, 216, 230));
        
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        yesButton.setFont(buttonFont);
        noButton.setFont(buttonFont);
        
        gbc.gridwidth = 1; 
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(yesButton, gbc);

        gbc.gridx = 1;
        add(noButton, gbc);

         yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new IsOldPatient(); 
            }
        });

        setVisible(true);
    }
    

    public static void main(String[] args) {
        new PatientInfo();
    }
}

