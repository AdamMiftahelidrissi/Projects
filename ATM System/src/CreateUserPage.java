import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateUserPage implements ActionListener {

    JFrame frame = new JFrame("Create Account");
    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel lastNameLabel = new JLabel("Last Name:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
    JLabel headerMessageLabel = new JLabel("Welcome to JAVA Bank");
    JLabel messageLabel = new JLabel("");
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JButton createAccountButton = new JButton("Create Account");

    ArrayList<String> history = new ArrayList<>();

    CreateUserPage(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        firstNameLabel.setBounds(80,150,120,20);
        firstNameLabel.setFont(new Font(null, Font.PLAIN, 20));

        lastNameLabel.setBounds(80,200,120,20);
        lastNameLabel.setFont(new Font(null, Font.PLAIN, 20));

        passwordLabel.setBounds(80,250,120,20);
        passwordLabel.setFont(new Font(null, Font.PLAIN, 20));

        confirmPasswordLabel.setBounds(10,300,170,20);
        confirmPasswordLabel.setFont(new Font(null, Font.PLAIN, 20));

        headerMessageLabel.setBounds(55,50,450,50);
        headerMessageLabel.setFont(new Font("Serif", Font.BOLD, 40));

        messageLabel.setBounds(200,350,250,30);
        messageLabel.setFont(new Font(null, Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        firstNameTextField.setBounds(200,150,240,25);

        lastNameTextField.setBounds(200,200,240,25);

        passwordField.setBounds(200,250,240,25);

        confirmPasswordField.setBounds(200,300,240,25);

        createAccountButton.setBounds(170,400,200,50);
        createAccountButton.setFont(new Font(null, Font.PLAIN, 20));
        createAccountButton.setFocusable(false);
        createAccountButton.addActionListener(this);


        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(headerMessageLabel);
        frame.add(messageLabel);
        frame.add(firstNameTextField);
        frame.add(lastNameTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(createAccountButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

        if (e.getSource() == createAccountButton){
            if (firstNameTextField.getText().isEmpty()){
                messageLabel.setText("First name is required");
            }
            else if (lastNameTextField.getText().isEmpty()){
                messageLabel.setText("Last name is required");
            }
            else if (String.valueOf(passwordField.getPassword()).isEmpty()){
                messageLabel.setText("Password is required");
            }
            else if (!password.equals(confirmPassword)){
                messageLabel.setText("Passwords do not match");
            }
            else {
                frame.dispose();
                BankMenu bank = new BankMenu(0, 0, firstName, lastName, password, history);
            }
        }
    }
}
