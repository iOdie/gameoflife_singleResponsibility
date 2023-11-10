package org.example;

import org.example.GameBoard;
public class Rules {

    private GameBoard gameBoard;
    private GameService gameService;
    public Rules (GameService gameService) {
        this.gameBoard = gameService.getGameBoard();
        this.gameService = gameService;
    }

    public boolean checkIfCellIsUnderpopulated (int row, int col) {
        if(gameService.evaluateNeighborCountOfCell(row, col) < 2 && gameBoard.isCellAlive(row, col)) {
            return true;
        }
        return false;
    }

    public boolean checkIfCellHasTwoOrThreeNeighbors (int row, int col) {
        if((gameService.evaluateNeighborCountOfCell(row, col) == 2 || gameService.evaluateNeighborCountOfCell(row, col) == 3) && gameBoard.isCellAlive(row, col)) {
            return true;
        }
        return false;
    }

    public boolean checkIfCellIsOverpopulated (int row, int col) {
        if(gameService.evaluateNeighborCountOfCell(row, col) > 3 && gameBoard.isCellAlive(row, col)) {
            return false;
        }
        return true;
    }

    public boolean checkIfCellIsReproducing (int row, int col) {
        if(gameService.evaluateNeighborCountOfCell(row,col) == 3 && !gameBoard.isCellAlive(row, col)) {
            return true;
        }
        return false;
    }
}
