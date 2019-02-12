import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {

    //Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Game");
    JMenu currentPlayer = new JMenu("Player 1");
    JMenuItem newGame = new JMenuItem("New game");
    JMenuItem AI = new JMenuItem("Play versus Computer");
    JMenuItem exitWin = new JMenuItem("Exit The Game");

    //Button
    ArrayList<ArrayList<btn>> buttons = new ArrayList<>();
    public Window(Controller Controller){

        newGame.addActionListener(Controller);
        exitWin.addActionListener(Controller);
        AI.addActionListener(Controller);

        menuBar.add(menu);
        menuBar.add(currentPlayer);
        menu.add(newGame);
        menu.add(AI);
        menu.add(exitWin);
        this.add(menuBar);
        this.setJMenuBar(menuBar);

        this.setLayout(new GridLayout(3,3));

        for (int i = 0; i <3 ; i++) {
            ArrayList<btn> innerButtons = new ArrayList<>();
            for (int j = 0; j <3 ; j++) {
                btn button = new btn("");
                button.addActionListener(Controller);
                this.add(button);
                innerButtons.add(button);
            }
            buttons.add(innerButtons);
        }

        this.setSize(600,600);
        this.setTitle("Tic tac toe");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
