import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Double.parseDouble;
public class WithdrawPage implements ActionListener{

    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame();
    JLabel withdrawalAmountLabel = new JLabel("Withdrawal amount:");
    JLabel selectAccountLabel = new JLabel("Select account to withdraw from");
    JTextField withdrawalAmountTextField = new JTextField();
    JLabel messageLabel = new JLabel("");
    JButton checkingButton = new JButton("Checking");
    JButton savingButton = new JButton("Saving");

    Date thisDate = new Date();
    ArrayList<String> history = new ArrayList<>();

    WithdrawPage(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

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

        withdrawalAmountLabel.setBounds(20,150,200,20);
        withdrawalAmountLabel.setFont(new Font(null, Font.PLAIN, 20));

        selectAccountLabel.setBounds(130,200,290,30);
        selectAccountLabel.setFont(new Font(null, Font.PLAIN, 20));

        messageLabel.setBounds(140,380,270,30);
        messageLabel.setFont(new Font(null, Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        withdrawalAmountTextField.setBounds(200,150,240,25);

        checkingButton.setBounds(80,280,180,50);
        checkingButton.setFont(new Font(null, Font.PLAIN, 20));
        checkingButton.setFocusable(false);
        checkingButton.addActionListener(this);

        savingButton.setBounds(270,280,180,50);
        savingButton.setFont(new Font(null, Font.PLAIN, 20));
        savingButton.setFocusable(false);
        savingButton.addActionListener(this);

        frame.add(withdrawalAmountLabel);
        frame.add(selectAccountLabel);
        frame.add(withdrawalAmountTextField);
        frame.add(messageLabel);
        frame.add(checkingButton);
        frame.add(savingButton);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String withdrawalAmount = withdrawalAmountTextField.getText();
        double withdrawalNumberAmount = parseDouble(withdrawalAmount);
        if (e.getSource() == checkingButton){
            if (withdrawalAmount.isEmpty()){
                messageLabel.setText("Input a withdrawal amount");
            }
            else if (withdrawalNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else if (withdrawalNumberAmount > checkingAccountAmount){
                messageLabel.setText("Not enough funds in account");
            }
            else {
                frame.dispose();
                checkingAccountAmount -= withdrawalNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Withdrawal of " + withdrawalNumberAmount + " dollars from checking account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        else if (e.getSource() == savingButton){
            if (withdrawalAmount.isEmpty()){
                messageLabel.setText("Input a deposit amount");
            }
            else if (withdrawalNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else if (withdrawalNumberAmount > savingAccountAmount){
                messageLabel.setText("Not enough funds in account");
            }
            else {
                frame.dispose();
                savingAccountAmount -= withdrawalNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Withdrawal of " + withdrawalNumberAmount + " dollars from saving account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
    }



}
