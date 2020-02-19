import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {
    //Exhaustive Checks
    public boolean[][] board1 = {{false, false, false, false, false, false},{false, true, true, true, false, false},
            {false, true, false, true, false, false},{false, true, false, true, false, true},{false, true, false, true, true, true},
            {false, true, false, false, false, false},{false, false, false, false, false, false}};
    @Test
    public void exhaustiveChecks() {
        SnakeGame game = new SnakeGame(board1, 5, 1);
        Assert.assertEquals(int[] solution = {3,5,13}, game.findTailExhaustive());
    }


}