import java.util.ArrayList;
import java.util.Random;

public class AI {
    Random rand;
    public AI(String sign, ArrayList<ArrayList<btn>> buttonList){
        rand = new Random();
        int i = rand.nextInt(3);
        int j = rand.nextInt(3);
        String buttonText = buttonList.get(i).get(j).getText();
        if(buttonText.isEmpty()){
            buttonList.get(i).get(j).setName(sign);
        }
    }
}
