package org.example;

import org.example.CellState;
import java.util.Arrays;

public class GameBoard {

    private int rows;
    private int cols;
    private int ALIVE = 1;
    private int DEAD = 0;
    private int[][] gameBoard;
    private GameService service;


    public GameBoard (int[][] gameBoard) {
        setGameBoard(gameBoard);
        this.service = new GameService(this);
    }

    public void doIterations (int iterationCount) {
        for (int counter = 0; counter < iterationCount; counter++) {
            System.out.println("Iteration: " + (counter + 1));
            service.setNextIteration();
            printGameBoard();
        }
    }

    public int[][] getGameBoard () {
        return gameBoard;
    }

    public void setGameBoard (int[][] gameBoard) {
        try { this.gameBoard = gameBoard; } catch (Exception e) {
            System.out.println("Input invalid");
        }
    }

    public void printGameBoard () {
        for (int row = 0; row < gameBoard.length; row++) {
            for(int col = 0; col < gameBoard[row].length; col++) {
                System.out.print(gameBoard[row][col]);
            }
            System.out.println();
        }
    }

    public boolean isCellAlive (int row, int col) {
        if(gameBoard[row][col] == ALIVE) {
            return true;
        } else {
            return false;
        }
    }

    public int[][] changeFieldToAlive (int[][] gameBoard, int row, int col) {
        gameBoard[row][col] = ALIVE;
        return gameBoard;
    }

    public int[][] changeFieldToDead (int[][] gameBoard, int row, int col) {
        gameBoard[row][col] = DEAD;
        return gameBoard;
    }
}
