import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class AdminDashbord extends JFrame{
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
    JScrollPane scrollbar = new JScrollPane();
    JTextArea ta;
    AdminDashbord(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(new GridLayout(25,2));
        setTitle("Admin dashboard");
        l1 = new JLabel("Admin dashboard");
        b1 = new JButton("Delete record by email");
        b2 = new JButton("Search record by email");
        b3 = new JButton("Add a plot");
        b4 = new JButton("Assign house");
        b5 = new JButton("Check all records");
        b6 = new JButton("Update plot info");
        b7 = new JButton("Search plots by owner email");
        b8 = new JButton("Check unsold plots");
        b9 = new JButton("Logout");
        b10 = new JButton("Update member record");
        ta = new JTextArea(20,20);
        scrollbar = new JScrollPane(ta);
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);
        b9.addActionListener(a);
        b10.addActionListener(a);
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(scrollbar);
        setVisible(true);
    }

    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search plots by owner email")){
                String email = JOptionPane.showInputDialog(null, "Enter your email");
            }

            else if(e.getActionCommand().equals("Delete record by email")){
                String email = JOptionPane.showInputDialog(null, "Enter the email to be deleted");
                Admin ad = new Admin();
                JOptionPane.showMessageDialog(null, ad.deleteRecordByEmail(email), "Result", JOptionPane.INFORMATION_MESSAGE);
            }

            else if(e.getActionCommand().equals("Search record by email")){
                ta.setText(null);
                String email = JOptionPane.showInputDialog(null, "Enter the email of member to search");
                Admin ad = new Admin();
                Member md = ad.searchRecordByEmail(email);
                if(md != null){
                    ta.setText(md.toString());
                    JOptionPane.showMessageDialog(null, "Found", "Result", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Record not found");
                }
            }
            
            else if(e.getActionCommand().equals("Add a plot")){
                dispose();
                new LoginPage();
            }

            else if(e.getActionCommand().equals("Assign house")){
                dispose();
                new LoginPage();
            }

            else if(e.getActionCommand().equals("Check all records")){
                Admin ad = new Admin();
                ArrayList<Member> list = ad.checkAllRecords();
                for(int i = 0; i<list.size(); i++){
                    ta.append(list.get(i).toString());
                }
            }

            else if(e.getActionCommand().equals("Update plot info")){
                dispose();
                new LoginPage();
            }

            else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
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

                
            else if(e.getActionCommand().equals("Check unsold plots")){
                Member m =new Member();
                dispose();
                new LoginPage();
            }
        }
    }
}