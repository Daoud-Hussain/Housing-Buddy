import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Log In");
    JButton resetButton = new JButton("Reset");
    JButton signUpButton = new JButton("Sign Up");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel headerLabel = new JLabel("Log In...");
    JLabel userIdLabel = new JLabel("User Email");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();


    LoginPage(){

        frame.setTitle("Housing Society Management System");
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        frame.setIconImage(image.getImage());

        headerLabel.setBounds(150,20,400,50);
        headerLabel.setFont(new Font(null, Font.BOLD, 40));

        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(50, 300,500,35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        userIdField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        frame.add(headerLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);

        loginButton.setBounds(120,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(230,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        signUpButton.setBounds(175,250,100,25);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(signUpButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100, 450,400);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton){
                    
            String[] responses = {"Admin", "Member"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of account you want to register","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            if(buttonResponse == 0){
                new SignUpPage();
            }else{
                new MemberDataInput();
            }
            
            frame.dispose();
        }
        if (e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }
        if (e.getSource() == loginButton){
            String UserID = userIdField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            FileOperations f= new FileOperations();

            try {
                if (f.readPasswordsAndValidate(UserID,password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    if(f.isAdmin(UserID, password)){
                        new AdminDashbord();
                    }else{
                        new Main();
                    }
                }else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Invalid UserName or Password!");
                }
            } catch (Exception ex) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Invalid UserName or Password!");
            }
        }
    }
}
