import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MemberScreen extends JFrame{
    JLabel l1;
    JButton b1, b2, b3, b4;
    MemberScreen(){
        l1 = new JLabel("Member Screen");
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        add(l1);
        b1 = new JButton("Search plots by owner name");
        b4 = new JButton("Logout");


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b4.addActionListener(a);

        add(b1);
        add(b2);

        setVisible(true);
    }



    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search plots by owner name")){
                new SearchByName();
                dispose();
            }else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }
            
        }
    }
}
