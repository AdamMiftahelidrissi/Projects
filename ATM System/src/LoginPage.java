import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class LoginPage implements ActionListener {

    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame();
    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel lastNameLabel = new JLabel("Last Name:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel headerMessageLabel = new JLabel("Welcome to JAVA Bank");
    JLabel messageLabel = new JLabel("");
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");

    Date thisDate = new Date();

    ArrayList<String> history = new ArrayList<>();


    LoginPage(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        this.checkingAccountAmount = checkingAccountAmount;
        this.savingAccountAmount = savingAccountAmount;

        this.history = history;

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

        headerMessageLabel.setBounds(55,50,450,50);
        headerMessageLabel.setFont(new Font("Serif", Font.BOLD, 40));

        messageLabel.setBounds(200,350,250,30);
        messageLabel.setFont(new Font(null, Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        firstNameTextField.setBounds(200,150,240,25);

        lastNameTextField.setBounds(200,200,240,25);

        passwordField.setBounds(200,250,240,25);

        loginButton.setBounds(170,400,200,50);
        loginButton.setFont(new Font(null, Font.PLAIN, 20));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);


        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(passwordLabel);
        frame.add(headerMessageLabel);
        frame.add(messageLabel);
        frame.add(firstNameTextField);
        frame.add(lastNameTextField);
        frame.add(passwordField);
        frame.add(loginButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String password = String.valueOf(passwordField.getPassword());
        if (e.getSource() == loginButton){
            if (firstNameTextField.getText().isEmpty()){
                messageLabel.setText("First name is required");
            }
            else if (lastNameTextField.getText().isEmpty()){
                messageLabel.setText("Last name is required");
            }
            else if (String.valueOf(passwordField.getPassword()).isEmpty()){
                messageLabel.setText("Password is required");
            }
            else if (!firstNameTextField.getText().equals(firstName)){
                messageLabel.setText("Unknown first name");
            }
            else if (!lastNameTextField.getText().equals(lastName)){
                messageLabel.setText("Unknown last name");
            }
            else if (!String.valueOf(passwordField.getPassword()).equals(password)){
                messageLabel.setText("Incorrect password");
            }
            else {
                frame.dispose();
                BankMenu bank = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
    }
}
