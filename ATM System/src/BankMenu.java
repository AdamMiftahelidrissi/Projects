import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class BankMenu implements ActionListener {
    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame("Main Menu");
    JLabel headerMessage = new JLabel();
    JLabel messageLabel = new JLabel("");
    JLabel checkingAccountBalance = new JLabel();
    JLabel savingAccountBalance = new JLabel();
    JButton transaction = new JButton("Transaction History");
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton transfer = new JButton("Transfer");
    JButton logOut = new JButton("Logout");

    Date thisDate = new Date();

    ArrayList<String> history = new ArrayList<>();

    BankMenu(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

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

        headerMessage.setText("Welcome, what would you like to do?");
        headerMessage.setBounds(70,50,450,50);
        headerMessage.setFont(new Font("Serif", Font.BOLD, 25));

        checkingAccountBalance.setText("Checking account balance: " + checkingAccountAmount);
        checkingAccountBalance.setBounds(100,100,4000,50);
        checkingAccountBalance.setFont(new Font("Dialog", Font.PLAIN, 20));

        savingAccountBalance.setText("Saving account balance: " + savingAccountAmount);
        savingAccountBalance.setBounds(120,150,400,50);
        savingAccountBalance.setFont(new Font("Dialog", Font.PLAIN, 20));

        messageLabel.setBounds(140,450,350,50);
        messageLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        messageLabel.setForeground(Color.red);

        transaction.setBounds(150,200,250,50);
        transaction.setFont(new Font(null, Font.PLAIN, 20));
        transaction.setFocusable(false);
        transaction.addActionListener(this);

        withdraw.setBounds(150,250,250,50);
        withdraw.setFont(new Font(null, Font.PLAIN, 20));
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);

        deposit.setBounds(150,300,250,50);
        deposit.setFont(new Font(null, Font.PLAIN, 20));
        deposit.setFocusable(false);
        deposit.addActionListener(this);

        transfer.setBounds(150,350,250,50);
        transfer.setFont(new Font(null, Font.PLAIN, 20));
        transfer.setFocusable(false);
        transfer.addActionListener(this);

        logOut.setBounds(150,400,250,50);
        logOut.setFont(new Font(null, Font.PLAIN, 20));
        logOut.setFocusable(false);
        logOut.addActionListener(this);

        frame.add(headerMessage);
        frame.add(checkingAccountBalance);
        frame.add(savingAccountBalance);
        frame.add(messageLabel);
        frame.add(transaction);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(transfer);
        frame.add(logOut);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transaction){
            if (history.isEmpty()){
                messageLabel.setText("No transaction history available");
            }
            else{
                TransactionHistory transactionHistory = new TransactionHistory(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        if (e.getSource() == withdraw){
            if (checkingAccountAmount == 0 && savingAccountAmount == 0){
                messageLabel.setText("Cannot withdraw from any accounts");
            }
            else {
                frame.dispose();
                WithdrawPage withdrawPage = new WithdrawPage(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        if (e.getSource() == deposit){
            frame.dispose();
            DepositPage depositPage = new DepositPage(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
        }
        if (e.getSource() == transfer){
            if (checkingAccountAmount == 0 && savingAccountAmount == 0){
                messageLabel.setText("Cannot transfer from any accounts");
            }
            else {
                frame.dispose();
                TransferPage transferPage = new TransferPage(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
            }
        }
        if (e.getSource() == logOut){
            frame.dispose();
            LoginPage loginPage = new LoginPage(checkingAccountAmount, savingAccountAmount, firstName, lastName, password, history);
        }
    }



}
