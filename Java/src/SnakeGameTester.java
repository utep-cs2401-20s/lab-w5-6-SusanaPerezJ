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
    public boolean[][] board4 = {{false, false, true, true},
                                 {false, false, true},
                                 {true, true, true},
                                 {false, false}};
    public boolean[][] board5 = {{true}, {false}};

    /*Test with head before tail*/
    @Test
    public void exhaustiveChecks() {
        SnakeGame game = new SnakeGame(board1, 5, 1);
        int[] solution = {3,5,13};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks1(){
        SnakeGame game = new SnakeGame(board1, 5, 1);
        game.findTailExhaustive();
        assertEquals(27, game.getExhaustiveChecks());
    }
    /*Test with head on the border of array*/
    @Test
    public void exhaustiveChecks2() {
        SnakeGame game = new SnakeGame(board2, 4, 0);
        int[] solution = {5,6,24};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks3(){
        SnakeGame game = new SnakeGame(board2, 4, 0);
        game.findTailExhaustive();
        assertEquals(42, game.getExhaustiveChecks());
    }
    /*Test case with a board where the tail "appears" before the head, to check that the condition that check if the cell
    is the head works*/
    @Test
    public void exhaustiveChecks4() {
        SnakeGame game = new SnakeGame(board3, 2, 0);
        int[] solution = {0,3,6};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks5(){
        SnakeGame game = new SnakeGame(board3, 2, 0);
        game.findTailExhaustive();
        assertEquals(4, game.getExhaustiveChecks());
    }
    //Testing the method with a jagged array to check that the for loop is working correctly.
    @Test
    public void exhaustiveChecks6() {
        SnakeGame game = new SnakeGame(board4, 2, 0);
        int[] solution = {0,3,6};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks7(){
        SnakeGame game = new SnakeGame(board4, 2, 0);
        game.findTailExhaustive();
        assertEquals(4, game.getExhaustiveChecks());
    }
    /*This test case is to check an array with only one alive cell. The expected behavior
    of the method is that it should check 1 cell and the tail will have the same
    coordinate as the head*/
    @Test
    public void exhaustiveChecks8() {
        SnakeGame game = new SnakeGame(board5, 0, 0);
        int[] solution = {0,0,1};
        assertArrayEquals(solution, game.findTailExhaustive());
    }
    @Test
    public void exhaustiveChecks9(){
        SnakeGame game = new SnakeGame(board5, 0, 0);
        game.findTailExhaustive();
        assertEquals(1, game.getExhaustiveChecks());
    }

    //Recursive method
    //Test case where the head "appears" before the tail
    @Test
    public void recursiveChecks(){
        SnakeGame game = new SnakeGame(board1, 5,1);
        int[] solution = {3,5,13};
        assertArrayEquals(solution, game.findTailRecursive());
        //assertEquals(13,game.getRecursiveChecks());
    }
    @Test
    public void recursiveChecks1(){
        SnakeGame game = new SnakeGame(board1, 5, 1);
        game.findTailRecursive();
        assertEquals(13, game.getRecursiveChecks());
    }
    //Board with head on the border of array to check that the bounds conditions are working correctly
    @Test
    public void recursiveChecks2() {
        SnakeGame game = new SnakeGame(board2, 4, 0);
        int[] solution = {5,6,24};
        assertArrayEquals(solution, game.findTailRecursive());
    }
    @Test
    public void recursiveChecks3(){
        SnakeGame game = new SnakeGame(board2, 4, 0);
        game.findTailRecursive();
        assertEquals(24, game.getRecursiveChecks());
    }
    //Snake with tail before the head
    @Test
    public void recursiveChecks4() {
        SnakeGame game = new SnakeGame(board3, 2, 0);
        int[] solution = {0,3,6};
        assertArrayEquals(solution, game.findTailRecursive());
    }
    @Test
    public void recursiveChecks5(){
        SnakeGame game = new SnakeGame(board3, 2, 0);
        game.findTailRecursive();
        assertEquals(6, game.getRecursiveChecks());
    }
    /*this test case is to verify that the method will behave correctly even with a jagged array*/
    @Test
    public void recursiveChecks6() {
        SnakeGame game = new SnakeGame(board4, 2, 0);
        int[] solution = {0,3,6};
        assertArrayEquals(solution, game.findTailRecursive());
    }
    @Test
    public void recursiveChecks7(){
        SnakeGame game = new SnakeGame(board4, 2, 0);
        game.findTailRecursive();
        assertEquals(6, game.getRecursiveChecks());
    }
    /*Test case to check if the recursive returns the coordinates of the tail if there is only one alive cell*/
    @Test
    public void recursiveChecks8(){
        SnakeGame game = new SnakeGame(board5, 0,0 );
        int[] solution = {0,0,1};
        assertArrayEquals(solution, game.findTailRecursive());
    }
    @Test
    public void recursiveChecks9(){
        SnakeGame game = new SnakeGame(board5, 0, 0);
        game.findTailRecursive();
        assertEquals(1, game.getRecursiveChecks());
    }
}