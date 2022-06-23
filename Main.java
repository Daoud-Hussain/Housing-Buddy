import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
public class Main implements ActionListener{
	
	JButton button7;
	JFrame frame = new JFrame();
	Main() {

			frame.setSize(500,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new GridLayout(7,1));
			frame.getContentPane().setBackground(new Color(0,0,0));
			frame.setTitle("Admin Dashboard - Plot");
			ImageIcon image = new ImageIcon("Images/logo.jpg");
			frame.setIconImage(image.getImage());

			JButton button1 = new JButton("Add a plot");
			button1.setFocusable(false);
			button1.addActionListener(e -> new AddAPlot());
			JButton button3 = new JButton("Check Records");
			button3.addActionListener(e -> new ViewRecord());
			button3.setFocusable(false);
			JButton button4 = new JButton("Search by Name");
			button4.addActionListener(e -> new SearchByName());
			button4.setFocusable(false);
			JButton button5 = new JButton("Update plot Information");
			button5.addActionListener(e -> new UpdatePlotInformation());
			button5.setFocusable(false);
			JButton button6 = new JButton("Delete a member from record");
			button6.addActionListener(e -> new DeleteRecordByOwner());
			button6.setFocusable(false);
			button7 = new JButton("Switch to member dashboard");
			button7.addActionListener(this);
			button7.setFocusable(false);
			
			JButton button8 = new JButton("Exit");
			button8.addActionListener(e -> System.exit(0));
			button8.setFocusable(false);
			frame.add(button1);
			frame.add(button3);
			frame.add(button4);
			frame.add(button5);
			frame.add(button6);
			frame.add(button7);
			frame.add(button8);


			frame.setVisible(true);




	}
        @Override
        public void actionPerformed(ActionEvent ex) {
			if(ex.getSource() == button7){
                frame.dispose();
                new AdminDashbord();
            }
        }


	
}