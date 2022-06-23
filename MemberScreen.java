import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MemberScreen extends JFrame{
    JButton b1, b2, b3, b4;
    MemberScreen(){
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());

        setSize(360,200);
        setTitle("Member Dashboard");
        b1 = new JButton("Search plots by owner name");
        b4 = new JButton("Logout");


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b1.setFocusable(false);
        b4.addActionListener(a);
        b4.setFocusable(false);


        add(b1);
        add(b4);

        setVisible(true);
    }



    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search plots by owner name")){
                new SearchByName();
            }else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }
            
        }
    }
}
