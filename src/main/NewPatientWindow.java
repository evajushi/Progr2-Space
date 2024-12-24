import javax.swing.*;
import java.awt.*;

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

    
  
}
