public class SnakeGame {
    //to calculate final score
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //default Constructor
    public SnakeGame(){
        boolean[][] gameBoard = new boolean[1][1];
    }
    //a constructor that takes a 2-dimensional boolean array, and the x and y position of the snakes "head".
    public SnakeGame(boolean[][] gameBoard, int x, int y){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j] = game[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    public int[] findTailExhaustive(){
        int[] tailFound = new int[3];
        int neighbors = 0;
        int snakeLength = 0;
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                //check that is not head
                if(i == headPosition[0] && j == headPosition[1]){
                    snakeLength++;
                    exhaustiveChecks++;
                    continue;
                }
                //check if cell is part of the snake
                if(game[i][j] == true){
                    //check neighbors
                    if(headPosition[0] >= 0){
                        //up
                        if(game[headPosition[0]-1][headPosition[1]] == true){
                            neighbors++;
                        }
                    }
                    if(headPosition[0] + 1 < game.length){
                        //down
                        if(game[headPosition[0]+1][headPosition[1]] == true){
                            neighbors++;
                        }
                    }
                    //columns
                    if(headPosition[0] - 1 >= 0){
                        //left
                        if(game[headPosition[0]][headPosition[1]-1] == true){
                            neighbors++;
                        }
                    }
                    if(headPosition[0] + 1 < game[0].length){
                        //right
                        if(game[headPosition[0]][headPosition[1]+1]== true){
                            neighbors++;
                        }
                    }
                }
                //check that if only has one neighbor
                if(neighbors > 1){
                    snakeLength++;
                }
                if(neighbors == 1){
                    tailFound[0] = i;
                    tailFound[1] = j;
                    tailFound[2] = snakeLength;
                    snakeLength++;
                }
                exhaustiveChecks++;
            }
        }
        return tailFound;
    }
}
