import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame = new JFrame("Calculator");
    JTextField textField = new JTextField();
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("x");
    JButton divButton = new JButton("/");
    JButton decButton = new JButton(".");
    JButton equButton = new JButton("=");
    JButton delButton = new JButton("Delete");
    JButton clrButton = new JButton("Clear");
    JButton negButton = new JButton("(-)");
    JPanel buttonPanel = new JPanel();
    Font myFont = new Font("", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);

        textField.setBackground(Color.lightGray);
        textField.setForeground(Color.BLACK);
        textField.setBounds(50,50,400,60);
        textField.setFont(myFont);
        textField.setEditable(false);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++){
            //buttonPanel.add(functionButtons[i]);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].addActionListener(this);
        }

        for (int i = 0; i <= 9; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            //buttonPanel.add(numberButtons[i]);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        delButton.setBounds(50,550,120,50);
        negButton.setBounds(190,550,120,50);
        clrButton.setBounds(330,550,120,50);

        buttonPanel.setBounds(50,125,400,410);
        buttonPanel.setLayout(new GridLayout(4,4));

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);
        buttonPanel.add(decButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equButton);
        buttonPanel.add(divButton);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(buttonPanel);
        frame.add(textField);

    }

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            if (operator == '+') {
                result = num1 + num2;
            }
            else if (operator == '-') {
                result = num1 - num2;
            }
            else if (operator == 'x') {
                result = num1 * num2;
            }
            else if (operator == '/') {
                result = num1 / num2;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double holder;
            holder = Double.parseDouble(textField.getText());
            holder *= -1;
            textField.setText(String.valueOf(holder));
        }
    }
}
