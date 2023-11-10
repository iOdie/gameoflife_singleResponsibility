package org.example;

public class GameService {

    private final GameBoard gameBoard;

    GameService (GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard () {
        return this.gameBoard;
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
        Rules rules = new Rules(this);
        if (rules.checkIfCellIsOverpopulated(row, col)
                && rules.checkIfCellIsReproducing(row, col)
                && rules.checkIfCellIsUnderpopulated(row, col)
                && rules.checkIfCellHasTwoOrThreeNeighbors(row,col)) {
            return true;
        }
        return false;
    }
}
