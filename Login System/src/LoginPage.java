import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JTextField usernameTextField = new JTextField();
    JLabel visiblePasswordLabel = new JLabel();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton showButton = new JButton("Show");
    JFrame frame = new JFrame();
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel message = new JLabel();
    boolean show = false;
    HashMap<String,String> loginInfoCopy = new HashMap<>();

    LoginPage(HashMap<String,String> loginInfoOriginal){

        loginInfoCopy = loginInfoOriginal;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);

        usernameLabel.setBounds(100,100,100,50);

        passwordLabel.setBounds(100,150,100,50);

        visiblePasswordLabel.setBounds(170,190,200,15);

        message.setBounds(180,200,400,50);
        message.setFont(new Font("", Font.ITALIC,20));

        usernameTextField.setBounds(170, 110, 200,30);

        passwordField.setBounds(170, 160, 200,30);

        loginButton.setBounds(100,250,120,50);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(250,250,120,50);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        showButton.setBounds(380,160,70,30);
        showButton.setFocusable(false);
        showButton.addActionListener(this);

        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(visiblePasswordLabel);
        frame.add(message);
        frame.add(usernameTextField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(showButton);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton){
            String username = usernameTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (loginInfoCopy.containsKey(username)){
                if (loginInfoCopy.get(username).equals(password)){
                    message.setForeground(Color.green);
                    message.setText("Successful");
                    frame.dispose();
                    WelcomePage welcomepage = new WelcomePage(username);
                }
                else {
                    message.setForeground(Color.red);
                    message.setText("Wrong Password");
                }
            }
            else {
                message.setForeground(Color.red);
                message.setText("Unknown Username");
            }
        }
        if (e.getSource() == resetButton){
            usernameTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showButton){
            if (show == true){
                visiblePasswordLabel.setText("");
                showButton.setText("Show");
                show = false;
            }
            else {
                visiblePasswordLabel.setText(String.valueOf(passwordField.getPassword()));
                showButton.setText("Hide");
                show = true;
            }

        }

    }
}
