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
        b2 = new JButton("Check unsold plots");
        // b3 = new JButton("Home");
        b4 = new JButton("Logout");


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        // b3.addActionListener(a);
        b4.addActionListener(a);

        add(b1);
        add(b2);
        // add(b3);
        add(b4);
        setVisible(true);
    }



    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search plots by owner name")){
                // new SearchPlotByOnwerName();
                dispose();
            }else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }else if(e.getActionCommand().equals("Check unsold plots")){
                Member m =new Member();
                // System.out.println(m.checkAvailablePlots());
                dispose();
                new LoginPage();
            }
        }
    }
}
