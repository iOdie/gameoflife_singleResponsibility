package org.example;

public class App
{
    public static void main(String[] args) {
        App app = new App();
        app.initializeSimulation();
    }
    public void initializeSimulation() {
        int[][] gameBoard = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0}};
        GameBoard golService = new GameBoard(gameBoard);
        golService.printGameBoard();
        golService.doIterations(10);
    }

}

