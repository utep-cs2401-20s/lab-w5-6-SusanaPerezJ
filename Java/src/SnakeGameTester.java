import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {

    //Exhaustive Checks
    public boolean[][] board1 =
            {{false, false, false, false, false, false},{false, true, true, true, false, false},
            {false, true, false, true, false, false},{false, true, false, true, false, true},{false, true, false, true, true, true},
            {false, true, false, false, false, false},{false, false, false, false, false, false}};
    public boolean[][] board2 =
                    {{false, false, true, true, true, true, true},
                    {false, false, true, false, false, false, true},
                    {false, false, true, true, true, false, true},
                    {false, false, false, false, true, false, true},
                    {true, true, true, false, true, false, true},
                    {false, false, true, false, true, false, true},
                    {false, false, true, true, true, false,false}};
    public boolean[][] board3 = {{false, false, true, true},
                                 {false, false, true, false},
                                 {true, true, true, false},
                                 {false, false, false, false}};

    @Test
    public void exhaustiveChecks() {
        SnakeGame game = new SnakeGame(board1, 5, 1);
        int[] solution = {3,5,13};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks1() {
        SnakeGame game = new SnakeGame(board2, 4, 0);
        int[] solution = {5,6,24};
        assertArrayEquals(solution, game.findTailRecursive());
    }
    //rec
    @Test
    public void recursiveChecks() {
        SnakeGame game = new SnakeGame(board3, 2, 0);
        int[] solution = {0,3,6};
        assertArrayEquals(solution, game.findTailRecursive());
    }
}