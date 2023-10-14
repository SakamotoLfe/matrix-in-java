package com.sakamotoslfe.matrixinjava.question;

import java.util.Arrays;
import java.util.Random;

public class SudokuService {

    Random random = new Random();

    public int[][] createGrid(int size) {
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextInt(1, size);
            }
        }
        return grid;
    }

    public void printGrid(int[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : grid) {
            stringBuilder.append("[");
            for (int j = 0; j < grid.length; j++) {
                stringBuilder.append("[").append(ints[j]).append("]");
            }
            stringBuilder.append("]\n");
        }
        System.out.println(stringBuilder);
    }

    public boolean isSudokuValid(int[][] grid) {
        boolean valid = true;
        // Check each row
        for (int i = 0; i < grid.length; i++) {
            if (!isRowValid(grid, i)) {
                return false;
            }
        }

        // Check each column
        for (int j = 0; j < grid.length; j++) {
            if (!isColumnValid(grid, j)) {
                return false;
            }
        }

        // Check each subgrid
        for (int row = 0; row < grid.length; row += grid.length * grid.length) {
            for (int col = 0; col < grid.length; col += grid.length * grid.length) {
                if (!isSubgridValid(grid, row, col)) {
                    return false;
                }
            }
        }
        return valid;
    }

    // STUDY THIS FIRST!

    private boolean isRowValid(int[][] grid, int row) {
        boolean[] seen = new boolean[grid.length];
        for (int col = 0; col < grid.length; col++) {
            int num = grid[row][col];
            if (num < 1 || num > grid.length || seen[num - 1]) {
                return false;
            }
            seen[num - 1] = true;
        }
        return true;
    }

    private boolean isColumnValid(int[][] grid, int col) {
        boolean[] seen = new boolean[grid.length];
        for (int row = 0; row < grid.length; row++) {
            int num = grid[row][col];
            if (num < 1 || num > grid.length || seen[num - 1]) {
                return false;
            }
            seen[num - 1] = true;
        }
        return true;
    }

    private boolean isSubgridValid(int[][] grid, int startRow, int startCol) {
        for (int i = startRow; i < startRow + grid.length; i++) {
            boolean[] seen = new boolean[grid.length];
            for (int j = startCol; j < startCol + grid.length; j++) {
                int num = grid[i][j];
                if (num < 1 || num > grid.length || seen[num - 1]) {
                    return false;
                }
                seen[num - 1] = true;
            }
        }
        return true;
    }
}