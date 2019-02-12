import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Controller implements ActionListener {

    String currentString = "X";
    Window view;
    Window window;
    Rules rules = new Rules();
    boolean AIMode = false;

    public Controller(){
        window = new Window(this);
    }

    public void exitGame(){
        int conf = JOptionPane.showConfirmDialog(null,"Are you sure you want to end the game?");
        if (conf == 0){
            System.exit(0);
        }

    }
    public void switchSign(){
        if(currentString.equals("X")){
            currentString = "O";
        }else currentString = "X";
    }

    public void changePlayer(){
        if(window.currentPlayer.getText().equals("Player 1")) window.currentPlayer.setText("Player 2");
        else window.currentPlayer.setText("Player 1");
    }

    public void resetGame(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                window.buttons.get(i).get(j).resetButton();
            }

        }
    }

    public void playAI(){

        Random rand = new Random();
        int i = rand.nextInt(3);
        int j = rand.nextInt(3);

        String randomButton = window.buttons.get(i).get(j).getText();
        while (!randomButton.isEmpty()) {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
            randomButton = window.buttons.get(i).get(j).getText();
        }
        switchSign();
        changePlayer();
        window.buttons.get(i).get(j).setName(currentString);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == window.newGame){
            resetGame();
        }
        if(e.getSource() == window.AI){
            if(!AIMode){
                window.AI.setText("Multyplayer");
                AIMode = true;
            }
            else{
                window.AI.setText("AI");
                AIMode = false;
            }

        }
        if(e.getSource() == window.exitWin){
            exitGame();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn button = window.buttons.get(i).get(j);
                if(e.getSource() == button){
                    if(button.getText().isEmpty()){
                        switchSign();
                        changePlayer();
                    }
                    button.setName(currentString);
                }
            }
        }

        if(AIMode && window.currentPlayer.getText().equals("Player 2")) {
            playAI();
        }

        ArrayList<ArrayList<Integer>> buttonValues = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <3 ; j++) {
                int value = window.buttons.get(i).get(j).getTextValue();
                innerList.add(value);
            }
            buttonValues.add(innerList);
        }


        if(rules.winGame(buttonValues)){
            Object[] options2 = {"Rematch",
                    "Close"};
            int result = JOptionPane.showOptionDialog(window,
                    "The winner is " + window.currentPlayer.getText()+"!",
                    "We have a winner",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options2,
                    options2[1]);

            if(result == 0){
                resetGame();
            }
        }



    }
}
