package org.example;

public enum CellState {
    ALIVE(1), DEAD(0);

    private int value;

    private CellState(int value) {
        this.value = value;
    }
}
