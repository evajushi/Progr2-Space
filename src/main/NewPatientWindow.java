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
    
  
}
