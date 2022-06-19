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
			frame.setLayout(new GridLayout(5,1));
			frame.setTitle("Housing Society Management System");
			ImageIcon image = new ImageIcon("Images/logo.jpg");
			frame.setIconImage(image.getImage());

			JButton button1 = new JButton("Add a plot");
			button1.setFocusable(false);
			button1.addActionListener(e -> new AddAPlot());
			JButton button2 = new JButton("Check Records");
			button2.addActionListener(e -> new ViewRecord());
			button2.setFocusable(false);
			JButton button3 = new JButton("Search by Name");
			button3.addActionListener(e -> new SearchByName());
			button3.setFocusable(false);
			JButton button4 = new JButton("Update plot Information");
			button4.addActionListener(e -> new UpdatePlotInformation());
			button4.setFocusable(false);
			JButton button5 = new JButton("Delete a member from record");
			button5.addActionListener(e -> new DeleteRecordByOwner());
			button5.setFocusable(false);
			frame.add(button1);
			frame.add(button2);
			frame.add(button3);
			frame.add(button4);
			frame.add(button5);


			frame.setVisible(true);

	}

	
}

