import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Double.parseDouble;

public class TransferPage implements ActionListener{

    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame();
    JLabel transferAmountLabel = new JLabel("Transfer amount:");
    JTextField transferAmountTextField = new JTextField();
    JLabel messageLabel = new JLabel("");
    JButton checkingToSavingButton = new JButton("Checking to saving");
    JButton savingToCheckingButton = new JButton("Saving to checking");

    Date thisDate = new Date();

    ArrayList<String> history = new ArrayList<>();


    TransferPage(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

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

        transferAmountLabel.setBounds(40,150,150,20);
        transferAmountLabel.setFont(new Font(null, Font.PLAIN, 20));

        messageLabel.setBounds(140,380,290,30);
        messageLabel.setFont(new Font(null, Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        transferAmountTextField.setBounds(200,150,240,25);

        checkingToSavingButton.setBounds(70,280,210,50);
        checkingToSavingButton.setFont(new Font(null, Font.PLAIN, 20));
        checkingToSavingButton.setFocusable(false);
        checkingToSavingButton.addActionListener(this);

        savingToCheckingButton.setBounds(290,280,210,50);
        savingToCheckingButton.setFont(new Font(null, Font.PLAIN, 20));
        savingToCheckingButton.setFocusable(false);
        savingToCheckingButton.addActionListener(this);

        frame.add(transferAmountLabel);
        frame.add(transferAmountTextField);
        frame.add(messageLabel);
        frame.add(checkingToSavingButton);
        frame.add(savingToCheckingButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String transferAmount = transferAmountTextField.getText();
        double transferNumberAmount = parseDouble(transferAmount);
        if (e.getSource() == checkingToSavingButton){
            if (transferAmount.isEmpty()){
                messageLabel.setText("Input a transfer amount");
            }
            else if (transferNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else if (transferNumberAmount > checkingAccountAmount){
                messageLabel.setText("Not enough funds in your account");
            }
            else {
                frame.dispose();
                checkingAccountAmount -= transferNumberAmount;
                savingAccountAmount += transferNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Transfer of " + transferNumberAmount + " dollars from checking account into saving account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        else if (e.getSource() == savingToCheckingButton){
            if (transferAmount.isEmpty()){
                messageLabel.setText("Input a transfer amount");
            }
            else if (transferNumberAmount <= 0){
                messageLabel.setText("Input a number greater than 0");
            }
            else if (transferNumberAmount > savingAccountAmount){
                messageLabel.setText("Not enough funds in your account");
            }
            else {
                frame.dispose();
                savingAccountAmount -= transferNumberAmount;
                checkingAccountAmount += transferNumberAmount;
                String x = String.valueOf(thisDate);
                x = x.concat(" Transfer of " + transferNumberAmount + " dollars from saving account into checking account");
                history.add(x);
                BankMenu bankmenu = new BankMenu(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
    }
}
