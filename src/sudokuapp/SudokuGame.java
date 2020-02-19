/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuapp;

import java.util.*;

/**
 *
 * @author Dil Bdr
 */
public class SudokuGame {
   /**
    * row is the integer variable that user will enter.
    * column is the integer variable which user will input the value.
    * number is the integer that user is willing to store in  a certain spot.
    * board is that 2D array with 3*3 size.
    */
    int row;
    int column;
    int number;
    int[][] board = new int[3][3];
/**
 * This is a constructor which create a blank board.
 */
    public SudokuGame() {
        int[][] newGame = new int[3][3];
        board = newGame;
    }
/**
 * 
 * @param row is the value given by user.
 * @param column is the value given by user
 * @return the value in the row and column and return space if there is no value.
 */
    public String getValue(int row, int column) {
        int value1 = board[row][column];

        //String value2 = Integer.toString(value1);
        String value2 = new String();
        value2 += value1;

        if (value1 == 0) {
            value2 = " ";
        }
        return value2;

    }
/**
 * 
 * @param row value given by the user
 * @param col value given by user
 * this method removes the values stored in given row and column
 */
    public void remove(int row, int col) {
        board[row][col] = 0;
    }

/**
 * 
 * @param row is value given by user.
 * @param col is the value given by user
 * @param number is the value that user wants to store in the given row and column
 * @throws RowException when the sum of the row is not equals to 15.
 * @throws ColumnException when the sum of the column is not equals to 15
 * @throws NumberAlreadyUsedException when the number already in the board.
 */
    public void place(int row, int col, int number) throws RowException, ColumnException, NumberAlreadyUsedException {

        int empty = 0;
        int empty2 = 0;

        for (int i = 0; i < 3; i++) {
            if (board[row][i] == 0) {
                empty++;
            }
        }

        if (empty == 1) {
            if (RowSum(row) + number != 15) {
                throw new RowException();
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[j][col] == 0) {
                empty2++;
            }
        }
        if (empty2 == 1 && CloumnSum(col) + number != 15) {
            throw new ColumnException();
        }

        if (AlreadyUsed(number)) {
            throw new NumberAlreadyUsedException();
        }

        board[row][col] = number;
    }
/**
 * 
 * @return true if the board is completely filled with the numbers
 */
    public boolean completed() {
        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;

    }
/**
 * 
 * @param row is the value entered by user
 * @param col is the value entered by user
 * @return true if there is no value in the given row and column
 */
    public boolean isEmpty(int row, int col) {
        return (board[row][col] == 0);
    }
/**
 * 
 * @param col is the value entered by user
 * @return the sum of column.
 */
    
    /**
 * 
 * @param row is value given by user
 * @return the sum of row given by the user.
 * sum1 is a variable that store the sum of the row.
 */
    public int RowSum(int row) {

        int sum1 = 0;

        for (int i = 0; i < 3; i++) {
            sum1 += board[row][i];
            System.out.println(sum1);
        }
        return sum1;

    }
    
    public int CloumnSum(int col) {
        int sum2 = 0;

        for (int j = 0; j < 3; j++) {
            sum2 += board[j][col];
        }
        return sum2;
    }
/**
 * 
 * @param number is integer value entered by user.
 * @return true if the number is already in the board.
 */
    public boolean AlreadyUsed(int number) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (number == board[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
