import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class Main{
	
	public static void main(String[] args) {

			JFrame frame = new JFrame();
			frame.setSize(500,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new GridLayout(6,1));
			frame.setTitle("Housing Society Management System");
			ImageIcon image = new ImageIcon("Images/logo.jpg");
			frame.setIconImage(image.getImage());

			JButton button1 = new JButton("Add a plot");
			button1.setFocusable(false);
			button1.addActionListener(e -> new AddAPlot());
			JButton button2 = new JButton("Assign a Plot ");
			// button2.addActionListener(e -> new SearchByName());
			button2.setFocusable(false);
			JButton button3 = new JButton("Check Records");
			// button3.addActionListener(e -> new SearchByDepartment());
			button3.setFocusable(false);
			JButton button4 = new JButton("Search by Name");
			button4.addActionListener(e -> new SearchByName());
			button4.setFocusable(false);
			JButton button5 = new JButton("Update plot Information");
			// button5.addActionListener(e -> new DeleteByName());
			button5.setFocusable(false);
			JButton button6 = new JButton("Delete a member from record");
			// button5.addActionListener(e -> new DeleteByName());
			button6.setFocusable(false);
			frame.add(button1);
			frame.add(button2);
			frame.add(button3);
			frame.add(button4);
			frame.add(button5);
			frame.add(button6);


			frame.setVisible(true);

	}


	
}