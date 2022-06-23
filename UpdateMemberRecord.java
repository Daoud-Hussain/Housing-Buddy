import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UpdateMemberRecord extends JFrame{
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Member member;

    public UpdateMemberRecord(Member mr){
        member = mr;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Member data updation");
        setSize(600,600);
        setLayout(new GridLayout(9,2));
        l1 = new JLabel("Name");
        l2 = new JLabel("Plot no");
        l3 = new JLabel("Street no");
        l4 = new JLabel("Sector");
        l5 = new JLabel("Phone no ");
        l6 = new JLabel("Email");
        l7 = new JLabel("Password");

        t1 = new JTextField(mr.getName());
        t2 = new JTextField(mr.getAddress().getPlotNo());
        t3 = new JTextField(mr.getAddress().getStreet());
        t4 = new JTextField(mr.getAddress().getSector());
        t5 = new JTextField(mr.getPhoneNo());
        t6 = new JTextField(mr.getEmail());
        t7 = new JTextField(mr.getPassword());

        b1 = new JButton("Update");
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
            if(e.getActionCommand().equals("Update")){
                FileOperations f = new FileOperations();
                String name = t1.getText();
                String plotNo = t2.getText();
                String streetno = t3.getText();
                String sector = t4.getText();
                String phoneNo = t5.getText();
                String email = t6.getText();
                String password = t7.getText();

                Address userAddress = new Address(plotNo, streetno, sector);
                Member s = new Member(name, userAddress, phoneNo, email, password);
                Admin ad = new Admin();
                IDAndPassword passId = new IDAndPassword(email, password, "member");
                System.out.println(s.toString());
                System.out.println(ad.updateMemberRecord(member.getEmail(), s));
                System.out.println(f.updatePasswords(member.getEmail(), passId));
                new AdminDashbord();
                dispose();
            }else if(e.getActionCommand().equals("Home")){
                dispose();
                new AdminDashbord();
            }
        }
    }
}
