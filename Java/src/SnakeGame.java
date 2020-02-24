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
        exhaustiveChecks = 0;
        int[] tailFound = new int[3];
        int snakeLength = 0;
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                int neighbors = 0;
                //check if cell is part of the snake
                if(game[i][j] == true){
                    snakeLength++;
                    //check it's not the head
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
                    //check is it's the tail
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
    public int[] findTailRecursive(){
        int[] previousPosition = new int[2];
        return findTailRecursive(headPosition, previousPosition);
    }
    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] tailFound = new int[3];
        //count neighbors
        //check if it's tail
        int neighbors = 0;
        if(currentPosition[0] - 1 >=0) {
            if(game[currentPosition[0]-1][currentPosition[1]] == true){
                neighbors++;
            }
        }
        if(currentPosition[0] + 1 < game.length){
            if(game[currentPosition[0]+1][currentPosition[1]] == true){
                neighbors++;
            }
        }
        if(currentPosition[1] - 1 >= 0){
            if(game[currentPosition[0]][currentPosition[1]-1] == true){
                neighbors++;
            }
        }
        if(currentPosition[1] + 1 < game.length) {
            if (game[currentPosition[0]][currentPosition[1] + 1] == true) {
                neighbors++;
            }
        }

        return findTailRecursive();
    }
    //NEXT METHOD, CALLS
    //
    public void printA(int[] boardToPrint){
        for(int number : boardToPrint){
            System.out.print(number);
        }
        System.out.println();
    }

}
