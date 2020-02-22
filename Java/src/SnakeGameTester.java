import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {
    public static void main(String[] args) {
         boolean[][] board1 = {{false, false, false, false, false, false},{false, true, true, true, false, false},
                {false, true, false, true, false, false},{false, true, false, true, false, true},{false, true, false, true, true, true},
                {false, true, false, false, false, false},{false, false, false, false, false, false}};
         int[] solution = {3,5,13};
        SnakeGame game = new SnakeGame(board1, 5, 1);
        /*for(int i = 0; i<board1.length;i++){
            for(int j = 0; j<board1[i].length;j++){
                System.out.println(board1[i][j]);
            }
        }*/
        game.findTailExhaustive();
        //game.printA(game.findTailExhaustive());
    }
//    //Exhaustive Checks
//    public boolean[][] board1 = {{false, false, false, false, false, false},{false, true, true, true, false, false},
//            {false, true, false, true, false, false},{false, true, false, true, false, true},{false, true, false, true, true, true},
//            {false, true, false, false, false, false},{false, false, false, false, false, false}};
//    @Test
//    public void exhaustiveChecks() {
//        SnakeGame game = new SnakeGame(board1, 5, 1);
//        Assert.assertEquals(int[] solution = {3,5,13}, game.findTailExhaustive());
//    }


}