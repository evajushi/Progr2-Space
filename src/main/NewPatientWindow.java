import javax.swing.*;
import java.awt.*;
import javax.swing.text.MaskFormatter;

public class NewPatientWindow extends JFrame {
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private static final int LABEL_FONT_SIZE = 22;
    private static final int FIELD_WIDTH = 500;
    private static final int FIELD_HEIGHT = 30;
    private String selectedDate;
    private String selectedTime;
    
    public NewPatientWindow(String date, String time) {

        this.selectedDate = date;
        this.selectedTime = time;

        setTitle("Στοιχεία Ασθενή");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Color lightBlue = new Color(230, 245, 255);
        getContentPane().setBackground(lightBlue);

        JPanel mainPanel = createMainPanel(lightBlue);
        add(mainPanel, BorderLayout.CENTER);

        JPanel bottomPanel = createBottomPanel(lightBlue);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
        
    }

    private JPanel createMainPanel(Color lightBlue) {
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.setBackground(lightBlue);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JPanel leftPanel = createLeftPanel(lightBlue);
        JPanel rightPanel = createRightPanel(lightBlue);

        mainPanel.add(leftPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        mainPanel.add(rightPanel);

        return mainPanel;
        
    }

    private JPanel createLeftPanel(Color lightBlue) {
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(lightBlue);

        leftPanel.add(createLabel("Παρακαλώ εισάγετε τα στοιχεία σας: ", 26));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createFieldLabelAndTextField("Όνομα: "));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createFieldLabelAndTextField("Έπιθετο: "));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createDateFieldPanel());
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createFieldLabelAndTextField("Διεύθυνση: "));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createFieldLabelAndTextField("Κινητό: "));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        leftPanel.add(createFieldLabelAndTextField("Email: "));
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        return leftPanel;
        
    }

        private JPanel createRightPanel(Color lightBlue) {
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(lightBlue);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));

        rightPanel.add(createLabel("Ίατρικό Ιστορικό: ", LABEL_FONT_SIZE));

        rightPanel.add(createMedicalHistoryArea());
        rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        rightPanel.add(createFieldLabelAndTextField("ΑΜΚΑ: "));
        rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        rightPanel.add(createFieldLabelAndTextField("Φύλο: "));

        return rightPanel;
        
    }

    private JPanel createBottomPanel(Color lightBlue) {
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(lightBlue);

        JButton submitButton = new JButton("Υποβολή");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.setBackground(new Color(173, 216, 230));
        bottomPanel.add(submitButton);
        
        submitButton.addActionListener(e -> {
            dispose();
            new AppointmentFinalScreen(selectedDate, selectedTime); 
        });

        return bottomPanel;
        
    }

    private JLabel createLabel(String text, int fontSize) {
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        return label;
        
    }

    private JPanel createFieldLabelAndTextField(String labelText) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(230, 245, 255));

        JLabel label = createLabel(labelText, LABEL_FONT_SIZE);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        textField.setMaximumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));

        textField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
        panel.add(textField);

        return panel;
        
    }

    private JScrollPane createMedicalHistoryArea() {
        
        JTextArea medicalHistory = new JTextArea();
        medicalHistory.setFont(new Font("Arial", Font.PLAIN, 14));
        medicalHistory.setLineWrap(true);
        medicalHistory.setWrapStyleWord(true);
        medicalHistory.setPreferredSize(new Dimension(FIELD_WIDTH, 200));
        medicalHistory.setMaximumSize(new Dimension(FIELD_WIDTH, 200));

        JScrollPane scrollPane = new JScrollPane(medicalHistory);
        scrollPane.setPreferredSize(new Dimension(FIELD_WIDTH, 100));
        scrollPane.setMaximumSize(new Dimension(FIELD_WIDTH, 100));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        return scrollPane;
        
    }

    private JPanel createDateFieldPanel() {
    	
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(230, 245, 255));

        JLabel label = createLabel("Ημερομηνία γέννησης (dd/mm/yyyy): ", LABEL_FONT_SIZE);
        panel.add(label);

        MaskFormatter dateFormatter = null;
        try {
            dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
        dateField.setFont(new Font("Arial", Font.PLAIN, 14));
        dateField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        dateField.setMaximumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        dateField.setAlignmentX(JFormattedTextField.LEFT_ALIGNMENT);

        panel.add(dateField);
        return panel;
        
    }
    
    public static void main(String[] args) {
    	
        new NewPatientWindow("__/__/___", "9:00");
        
    }
    
  
}
