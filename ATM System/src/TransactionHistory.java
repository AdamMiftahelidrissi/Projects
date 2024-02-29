import javax.swing.*;
import java.util.ArrayList;

public class TransactionHistory {

    double checkingAccountAmount;
    double savingAccountAmount;
    String firstName;
    String lastName;
    String password;
    JFrame frame = new JFrame();
    DefaultListModel<String> transactionHistory = new DefaultListModel<>();
    ArrayList<String> history = new ArrayList<>();
    JList<String> list = new JList<>(transactionHistory);

    TransactionHistory(double checkingAccountAmount, double savingAccountAmount, String firstName, String lastName, String password, ArrayList<String>history){

        this.history = history;

        for (int i = 0; i < history.size(); i++){
            transactionHistory.addElement(history.get(i));
        }

        list.setBounds(1,1,570,400);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(570,400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(list);
    }

}
