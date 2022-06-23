import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
public class Details implements ActionListener{
	
	JFrame frame;
	JTextArea textArea;
    JScrollPane scrollbar = new JScrollPane();
    JButton button = new JButton();

	Details(String str) {
		frame = new JFrame();
			frame.setSize(500,400);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// frame.getContentPane().setBackground(new Color(0,0,0));
			frame.setTitle("Housing Society Management System");
			// frame.setLayout(null);

			ImageIcon image = new ImageIcon("Images/logo.jpg");
			frame.setIconImage(image.getImage());
			button.setText("Close");
			button.setBounds(195,300,75,40);
			button.addActionListener(this);
			
        	textArea = new JTextArea(10,10);
        	// textArea.setBounds(10,50,200,200)
        	textArea.setSize(frame.getWidth(), frame.getHeight());
        	textArea.setText(str);
        	scrollbar = new JScrollPane(textArea);
        	scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        	frame.add(scrollbar);
			// frame.add(button);
			// frame.setLayout(null);
			frame.setVisible(true);
			frame.setResizable(false);




	}
        @Override
        public void actionPerformed(ActionEvent ex) {
			if(ex.getSource() == button){
                frame.dispose();
            }
        }




	
}