import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn = false;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.gray);
        textField.setForeground(Color.black);
        textField.setOpaque(true);
        textField.setFont(new Font("MV Boli", Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Player O's Turn");

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(Color.green);

        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Serif", Font.PLAIN, 150));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]){
                if (playerOneTurn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        textField.setText("Player O's Turn");
                        checkWin();
                    }
                }
                else {
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        textField.setText("Player X's Turn");
                        checkWin();
                    }
                }
            }
            draw();
        }
    }

    public void firstTurn(){
        if (random.nextInt(2) == 0){
            playerOneTurn = true;
            textField.setText("Player X's Turn");
        }
    }

    public void checkWin(){
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            xWins(0,1,2);
        }
        else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            xWins(3,4,5);
        }
        else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            xWins(6,7,8);
        }
        else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            xWins(0,3,6);
        }
        else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            xWins(1,4,7);
        }
        else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            xWins(2,5,8);
        }
        else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            xWins(0,4,8);
        }
        else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            xWins(2,4,6);
        }
        else if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            oWins(0,1,2);
        }
        else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            oWins(3,4,5);
        }
        else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            oWins(6,7,8);
        }
        else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            oWins(0,3,6);
        }
        else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            oWins(1,4,7);
        }
        else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
            oWins(2,5,8);
        }
        else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            oWins(0,4,8);
        }
        else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Player X Wins!");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Player O Wins!");
    }

    public void draw(){
        boolean draw = true;
        for (int i = 0; i < 9; i++){
           if (buttons[i].getText() == ""){
               draw = false;
           }
        }
        if (draw){
            textField.setText("Draw");
        }
    }
}
