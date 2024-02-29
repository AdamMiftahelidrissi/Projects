import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Double.parseDouble;

public class DepositPage implements ActionListener {
    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame();
    JLabel depositAmountLabel = new JLabel("Deposit amount:");
    JLabel selectAccountLabel = new JLabel("Select account to deposit into");
    JTextField depositAmountTextField = new JTextField();
    JLabel messageLabel = new JLabel("");
    JButton checkingButton = new JButton("Checking");
    JButton savingButton = new JButton("Saving");

    Date thisDate = new Date();

    ArrayList<String> history = new ArrayList<>();

    DepositPage(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

        this.checkingAccountAmount = checkingAccountAmount;
        this.savingAccountAmount = savingAccountAmount;

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        this.history = history;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        depositAmountLabel.setBounds(50,150,150,20);
        depositAmountLabel.setFont(new Font(null, Font.PLAIN, 20));

        selectAccountLabel.setBounds(140,200,270,30);
        selectAccountLabel.setFont(new Font(null, Font.PLAIN, 20));

        messageLabel.setBounds(140,380,270,30);
        messageLabel.setFont(new Font(null, Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        depositAmountTextField.setBounds(200,150,240,25);

        checkingButton.setBounds(80,280,180,50);
        checkingButton.setFont(new Font(null, Font.PLAIN, 20));
        checkingButton.setFocusable(false);
        checkingButton.addActionListener(this);

        savingButton.setBounds(270,280,180,50);
        savingButton.setFont(new Font(null, Font.PLAIN, 20));
        savingButton.setFocusable(false);
        savingButton.addActionListener(this);




        frame.add(depositAmountLabel);
        frame.add(selectAccountLabel);
        frame.add(depositAmountTextField);
        frame.add(messageLabel);
        frame.add(checkingButton);
        frame.add(savingButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String depositAmount = depositAmountTextField.getText();
        double depositNumberAmount = parseDouble(depositAmount);
        if (e.getSource() == checkingButton){
            if (depositAmount.isEmpty()){
                messageLabel.setText("Input a deposit amount");
            }
            else if (depositNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else {
                frame.dispose();
                checkingAccountAmount += depositNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Deposit of " + depositNumberAmount + " dollars into checking account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        else if (e.getSource() == savingButton){
            if (depositAmount.isEmpty()){
                messageLabel.setText("Input a deposit amount");
            }
            else if (depositNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else {
                frame.dispose();
                savingAccountAmount += depositNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Deposit of " + depositNumberAmount + " dollars into saving account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
    }
}
