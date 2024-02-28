import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class IDandPasswords implements ActionListener{

    JFrame frame = new JFrame();
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel message = new JLabel();
    JButton continueLoginButton = new JButton("Continue to Login");
    JButton createAccountButton = new JButton("Create Account");
    HashMap<String,String> loginInfo = new HashMap<>();

    IDandPasswords(){

        loginInfo.put("johnSmith", "smith123");
        loginInfo.put("username", "password");
        loginInfo.put("cool", "project");
        loginInfo.put("1", "1");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 400);
        frame.setVisible(true);

        usernameLabel.setBounds(60,70,100,50);

        passwordLabel.setBounds(60,120,100,50);

        confirmPasswordLabel.setBounds(60,190,200,15);

        message.setBounds(170,205,350,40);
        message.setFont(new Font("", Font.ITALIC,15));

        usernameTextField.setBounds(170, 80, 220,30);

        passwordField.setBounds(170, 130, 220,30);

        confirmPasswordField.setBounds(170,180,220,30);

        createAccountButton.setBounds(60,250,140,50);
        createAccountButton.setFocusable(false);
        createAccountButton.addActionListener(this);

        continueLoginButton.setBounds(250,250,140,50);
        continueLoginButton.setFocusable(false);
        continueLoginButton.addActionListener(this);

        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(message);
        frame.add(usernameTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(createAccountButton);
        frame.add(continueLoginButton);

    }
    protected HashMap getLoginInfo() {
        return loginInfo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueLoginButton){
            frame.dispose();
            LoginPage loginpage = new LoginPage(loginInfo);
        }
        if (e.getSource() == createAccountButton){
            String pass = String.valueOf(passwordField.getPassword());
            String passConfirm = String.valueOf(confirmPasswordField.getPassword());

            if (usernameTextField.getText().isEmpty()){
                message.setText("Fill out username");
            }
            else if (pass.isEmpty()){
                message.setText("Password is empty");
            }
            else if (passConfirm.isEmpty()){
                message.setText("Confirm password");
            }
            else if (!pass.equals(passConfirm)){
                message.setText("Passwords do not match");
            }
            else{
                loginInfo.put(usernameTextField.getText(), pass);
                frame.dispose();
                LoginPage loginpage = new LoginPage(loginInfo);
            }
        }

    }
}

