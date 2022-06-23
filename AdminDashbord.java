import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ImageIcon;



public class AdminDashbord extends JFrame{
    JButton b1, b2, b3, b4, b5, b6, b7;
    JScrollPane scrollbar = new JScrollPane();
    AdminDashbord(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        setLayout(new GridLayout(7,1));
        setTitle("Admin Dashboard - Member");
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());

        b1 = new JButton("Check member records");
        b2 = new JButton("Search member by email");
        b3 = new JButton("Delete member by email");
        b4 = new JButton("Update member record");
        b7 = new JButton("Switch to Plot dashboard");
        b5 = new JButton("Logout");
        b6 = new JButton("Exit");
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b7.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b7);
        add(b5);
        add(b6);

        setVisible(true);
    }

    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("Delete member by email")){
                String email = JOptionPane.showInputDialog(null, "Enter the email to be deleted");
                Admin ad = new Admin();
                JOptionPane.showMessageDialog(null, ad.deleteRecordByEmail(email), "Result", JOptionPane.INFORMATION_MESSAGE);
            }

            else if(e.getActionCommand().equals("Search member by email")){
                String email = JOptionPane.showInputDialog(null, "Enter the email of member to search");
                Admin ad = new Admin();
                Member md = ad.searchRecordByEmail(email);
                if(md != null){
                    // ta.setText(md.toString());
                    new Details(md.toString());
                    JOptionPane.showMessageDialog(null, "Found", "Result", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Record not found");
                }


            }

            else if(e.getActionCommand().equals("Check member records")){
                String str = "";
                Admin ad = new Admin();
                ArrayList<Member> list = ad.checkAllRecords();
                for(int i = 0; i<list.size(); i++){
                    str += list.get(i).toString();
                }
                new Details(str);
            }


            else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }
            else if(e.getActionCommand().equals("Switch to Plot dashboard")){
                dispose();
                new Main();
            }

            else if(e.getActionCommand().equals("Update member record")){
                String email = JOptionPane.showInputDialog("Enter your email? ");
                System.out.println(email);
                Admin ad = new Admin();
                Member md = new Member();
                md = ad.searchRecordByEmail(email);

                if(md != null){
                    JOptionPane.showMessageDialog(null,"Found");
                    dispose();
                    new UpdateMemberRecord(md);
                }else{
                    JOptionPane.showMessageDialog(null, "Member not found in record");
                }
            }
        }
    }
}