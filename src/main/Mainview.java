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
		frame.setSize(1200,800);
		
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
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        	frame.add(panel);

		JLabel title = new JLabel("DocOptimizer", JLabel.CENTER);
	        title.setForeground(Color.black);
		title.setFont(new Font("Arial",Font.BOLD,50));
		title.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(title);
		       
		 panel.add(Box.createVerticalStrut(250));
        
		 JLabel description = new JLabel("Μπορείτε τώρα να κλείσετε ραντεβού γρήγορα και εύκολα", JLabel.CENTER);
		 description.setForeground(Color.black);
		 description.setFont(new Font("Arial", Font.PLAIN, 20));
		 description.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 0));
		 description.setAlignmentX(Component.CENTER_ALIGNMENT);
		 panel.add(description);

		        
		 panel.add(Box.createVerticalStrut(30));
		  
		JButton enterButton = new JButton("Είσοδος στην εφαρμογή");
		enterButton.setFont(new Font("Arial", Font.PLAIN, 20));
		enterButton.setBackground(new Color(216, 167, 210)); 
		enterButton.setForeground(Color.BLACK);
		enterButton.setPreferredSize(new Dimension(200, 200)); 
		enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		       
		panel.add(enterButton); 
    
		frame.setVisible(true);
	
	}
} 

