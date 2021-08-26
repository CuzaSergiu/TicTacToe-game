import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {

        // setup the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // setup the text
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Welcome to Tic-Tac-Toe");
        textfield.setOpaque(true);

        // title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        // button panel
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        checkWinner();

                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        checkWinner();
                    }
                }
            }
        }
    }

    // checks who ever starts first
    public void firstTurn() {

        // start the game after 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // picks a random player to start the game from X or O
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("0 turn");
        }

    }

    public void checkWinner() {

        // check to see if X is winning
        if ((buttons[0].getText() == "X") && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            xWin(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            xWin(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            xWin(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            xWin(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            xWin(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            xWin(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            xWin(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            xWin(2, 4, 6);
        }

        // check to see if O is winning
        if ((buttons[0].getText() == "O") && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            oWin(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            oWin(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            oWin(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            oWin(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            oWin(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
            oWin(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            oWin(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            oWin(2, 4, 6);
        }

    }

    public void xWin(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");

    }

    public void oWin(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }
}
