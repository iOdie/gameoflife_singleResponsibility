package org.example;

public class GameService {

    private final GameBoard gameBoard;

    GameService (GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int evaluateNeighborCountOfCell (int row, int col) {
        //TODO define calculation
        return 0;
    }

    public void setNextIteration () {
        int[][] currentIteration = gameBoard.getGameBoard();
        int[][] nextIterationGameBoard = new int[currentIteration.length][currentIteration[0].length];

        for (int row = 0; row < currentIteration.length; row++) {
            for(int col = 0; col < currentIteration[row].length; col++) {
                if (checkIfCellWillBeAlive(row,col)) {
                    nextIterationGameBoard[row][col] = 1;
                }
            }
            gameBoard.setGameBoard(nextIterationGameBoard);
        }
    }

    public boolean checkIfCellWillBeAlive (int row, int col) {
        // Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        if(evaluateNeighborCountOfCell(row, col) < 2 && gameBoard.isCellAlive(row, col)) {
            return false;
        }
        // Any live cell with two or three live neighbours lives on to the next generation.
        if((evaluateNeighborCountOfCell(row, col) == 2 || evaluateNeighborCountOfCell(row, col) == 3) && gameBoard.isCellAlive(row, col)) {
            return true;
        }
        // Any live cell with more than three live neighbours dies, as if by overpopulation.
        if(evaluateNeighborCountOfCell(row, col) > 3 && gameBoard.isCellAlive(row, col)) {
            return false;
        }
        // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        if(evaluateNeighborCountOfCell(row,col) == 3 && !gameBoard.isCellAlive(row, col)) {
            return true;
        }
        return false;
    }
}
