import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame{
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    public SignUpPage(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        setTitle("Housing Society Management System");
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());
        setLayout(new GridLayout(8,2));
        l1 = new JLabel("Name");
        l2 = new JLabel("Plot no");
        l3 = new JLabel("Street no");
        l4 = new JLabel("Sector");
        l5 = new JLabel("Phone no ");
        l6 = new JLabel("Email");
        l7 = new JLabel("Password");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();

        b1 = new JButton("Register");
        b2 = new JButton("Home");

        MyActionListener m = new MyActionListener();

        b1.addActionListener(m);
        b2.addActionListener(m);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(b1);
        add(b2);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Register")){

                FileOperations f = new FileOperations();
                String name = t1.getText();
                String plotNo = t2.getText();
                String streetno = t3.getText();
                String sector = t4.getText();
                String phoneNo = t5.getText();
                String email = t6.getText();
                String password = t7.getText();
                Address userAddress = new Address(plotNo, streetno, sector);
                Admin s = new Admin(name, userAddress, phoneNo, email, password);
                f.writeToFile(s);
                IDAndPassword passId = new IDAndPassword(email, password, "admin");
                f.writePasswordsAndUserNames(passId);
                new LoginPage();
                dispose();
            }else if(e.getActionCommand().equals("Home")){
                dispose();
                new LoginPage();
            }
        }
    }
}