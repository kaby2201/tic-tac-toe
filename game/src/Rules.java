import java.util.ArrayList;

public class Rules {
    public boolean winGame(ArrayList<ArrayList<Integer>> buttonValues){
        return checkHorizontal(buttonValues) || checkVertical(buttonValues) || checkDiagonal(buttonValues);

    }

    public boolean checkHorizontal(ArrayList<ArrayList<Integer>> buttonValues){
        int totalSum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                totalSum += buttonValues.get(i).get(j);

            }
            if(totalSum == 3 || totalSum == 0){
                System.out.println("Horizontal win");
                return true;
            }
            totalSum = 0;
        }
        return false;
    }

    public boolean checkVertical(ArrayList<ArrayList<Integer>> buttonValues){
        int totalSum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                totalSum += buttonValues.get(j).get(i);

            }
            if(totalSum == 3 || totalSum == 0){
                System.out.println("Vertical win");
                return true;
            }
            totalSum = 0;

        }
        return false;
    }

    public boolean checkDiagonal(ArrayList<ArrayList<Integer>> buttonValues){
        int totalSum = 0;

        for (int i = 0; i < 3; i++) {
            totalSum += buttonValues.get(i).get(i);
        }

        if(totalSum == 3 || totalSum == 0){
            System.out.println("Diagonal win");
            return true;
        }
        totalSum = 0;

        for (int i = 0; i < 3; i++) {
            totalSum += buttonValues.get(i).get(2-i);
        }
        if(totalSum == 3 || totalSum == 0){
            System.out.println("Diagonal win");
            return true;
        }

        return false;
    }

    public boolean draw(ArrayList<ArrayList<Integer>> buttonValues){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(buttonValues.get(i).get(j) == -4) return false;
            }
        }
        return true;
    }
}