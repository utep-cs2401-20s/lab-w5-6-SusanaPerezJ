public class SnakeGame {
    //to calculate final score
    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    int snakeLength = 0;
    private int[] tailFound = new int[3];

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
        //reset counter, starting at head
        recursiveChecks = 0;
        int[] previous = new int[2];
        return findTailRecursive(headPosition, previous );
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;
        int row = currentPosition[0];
        int col  = currentPosition[1];
        int[] temp = new int[2];
        if(row - 1 >= 0){//bounds
            if(game[row - 1][col] == true) {//has neighbor
                if(row - 1 != previousPosition[0] || col != previousPosition[1]){
                    snakeLength++;
                    temp[0] = row - 1;
                    temp[1] = col;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if(row + 1 < game.length){//bounds
            if(game[row + 1][col] == true) {//has neighbor
                if(row + 1 != previousPosition[0] || col != previousPosition[1]){
                    snakeLength++;
                    temp[0] = row + 1;
                    temp[1] = col;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if(col - 1 >= 0){//bounds
            if(game[row][col - 1] == true) {//has neighbor
                if(row != previousPosition[0] || col - 1 != previousPosition[1]){
                    snakeLength++;
                    temp[0] = row;
                    temp[1] = col - 1;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if(col + 1 < game.length){//bounds
            if(game[row][col + 1] == true) {//has neighbor
                if(row != previousPosition[0] || col + 1 != previousPosition[1]){
                    snakeLength++;
                    temp[0] = row;
                    temp[1] = col + 1;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        snakeLength++;
        System.out.println(row + " " + col + " " + snakeLength);
        return new int[]{row, col, snakeLength};
    }
    
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }
    //resets both the exhaustiveChecks and recursiveChecks counters to 0.
    public static int getRecursiveChecks(){
        return recursiveChecks;
    }
    //gets the current state of the recursiveChecks counter.
    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
    // gets the current state of the exhaustiveChecks counter.
    public void printA(int[] boardToPrint){
        for(int number : boardToPrint){
            System.out.print(number);
        }
        System.out.println();
    }

}
