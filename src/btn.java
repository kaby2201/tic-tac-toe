import javax.swing.*;
import java.awt.*;

public class btn extends JButton {
    private boolean active_btn = true;


    public btn(String name){
        this.setText(name);
    }
    public ImageIcon changeIcon(String name){
        Image photo = new ImageIcon(this.getClass().getResource("/img/"+name+"Image.png")).getImage();
        return new ImageIcon(photo);

    }
    public void setName(String name){
        if(active_btn){
            this.setIcon(changeIcon(name));
            this.setText(name);
        }
        active_btn = false;
    }

    public void resetButton(){
        this.setText("");
        this.setIcon(null);
        active_btn = true;
    }

    public int getTextValue(){
        if(this.getText().equals("X")) return 1;
        else if(this.getText().equals("O")) return 0;
        else return -4;
    }
}
