import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    JFrame frame = new JFrame("Welcome!");
    JLabel message = new JLabel();

    WelcomePage(String username){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(300,300);
        frame.setVisible(true);

        message.setText("Welcome " + username);
        message.setHorizontalAlignment(JLabel.CENTER);

        frame.add(message);

    }


}
