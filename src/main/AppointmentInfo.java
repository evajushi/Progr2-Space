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
    }


public static void main(String[] args) {
        DocInfo frame = new DocInfo(); 
        frame.setVisible(true);        
    }
}
