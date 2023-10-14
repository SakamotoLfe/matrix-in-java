package com.sakamotoslfe.matrixinjava;

import com.sakamotoslfe.matrixinjava.question.SudokuService;

public class Main {
    public static void main(String[] args) {

        // Sudoku game question
        SudokuService sudoku = new SudokuService();
        int[][] sudokuGame = sudoku.createGrid(3);
        sudoku.printGrid(sudokuGame);
        int[][] validSudoku = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println(sudoku.isSudokuValid(sudokuGame));
        System.out.println(sudoku.isSudokuValid(validSudoku));
        // End Sudoku game question
    }
}