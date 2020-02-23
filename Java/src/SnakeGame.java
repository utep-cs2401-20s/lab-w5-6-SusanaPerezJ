import java.util.Arrays;

public class SnakeGame {
    //to calculate final score
    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //default Constructor
    public SnakeGame(){
        boolean[][] gameBoard = new boolean[1][1];
    }
    //a constructor that takes a 2-dimensional boolean array, and the x and y position of the snakes "head".
    public SnakeGame(boolean[][] gameBoard, int x, int y){
        int size = gameBoard.length;
        game = new boolean[size][size];
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                game[i][j] = gameBoard[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    public int[] findTailExhaustive(){
        int[] tailFound = new int[3];
        int snakeLength = 0;
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                int neighbors = 0;
                //check if cell is part of the snake
                if(game[i][j] == true){
                    snakeLength++;
                    if(i == headPosition[0] && j == headPosition[1]){
                        continue;
                    }
                    //check neighbors
                    if(i - 1 >=0) {
                        if(game[i-1][j] == true){
                            neighbors++;
                        }
                    }
                    if(i + 1 < game.length){
                        if(game[i+1][j] == true){
                            neighbors++;
                        }
                    }
                    if(j - 1 >= 0){
                        if(game[i][j-1] == true){
                            neighbors++;
                        }
                    }
                    if(j + 1 < game.length){
                        if(game[i][j+1] == true){
                            neighbors++;
                        }
                    }
                    if(neighbors == 1){
                        tailFound[0] = i;
                        tailFound[1] = j;
                    }
                }
                exhaustiveChecks = (tailFound[0]) * (game.length) + tailFound[1] + 1;
                tailFound[2] = snakeLength;
            }
        }
        System.out.println("Checks:" + exhaustiveChecks);
        printA(tailFound);
        return tailFound;
    }
    /*public int[] findTailRecursive(){
        int[] tailFound = new int[3];
        //base case if cell is tail
        if() {
            return tailFound;
            //each direction
        }else if(){
            //call with new cell
        }
    }*/
    public void printA(int[] boardToPrint){
        for(int number : boardToPrint){
            System.out.println(number);
        }
        System.out.println();
    }
}
