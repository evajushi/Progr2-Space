import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

public class Mainview implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Διαχείριση Ραντεβού σε Ιατρείο");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false); 
		frame.setSize(2000,900);
		
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 50, 200), 0, getHeight(), new Color(0, 0, 50, 100));
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				}
		};
		panel.setLayout(new BorderLayout()); 
        frame.add(panel);
        
       
        
        
        
        
		frame.setVisible(true);
	
	}
} 

