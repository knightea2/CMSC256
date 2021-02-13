/**
 * Evan Knight
 * 2-5-2021
 * CMSC 256
 * Sec 004
 */


package cmsc256;

public class Grid {
    char[][] grid = new char[3][3];

    /**
     * Initializes a 3 by 3 grid to default char values ('\u0000')
     */
    public Grid() {
        this.grid = grid;
    }



    /**
     * Formats the grid row to a String that consists of a space, the char,
     *  a space, a vertical pipe, a space, the char, a space, a vertical pipe,
     * a space, the char, and a final space,
     * for example: " X | X | X "
     *
     * @param rowIndex  the index of the row to convert to a String
     * @return a formatted String representation of the row
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public String getRow(int rowIndex) throws IllegalArgumentException{
        if (rowIndex < 0 || rowIndex > grid.length - 1) {
            throw new IllegalArgumentException("Invalid row index");
        }

        return " " + grid[rowIndex][0] + " | " + grid[rowIndex][1] + " | " + grid[rowIndex][2] + " ";
    }



    /**
     * Sets the grid location to the given value
     * @param value         char value for the grid location
     * @param rowIndex      the index of the row position
     * @param columnIndex   the index of the column position
     * @throws IllegalArgumentException if the row index or column index is invalid
     *                                  or if the position is not null
     */
    public void setPosition(char value, int rowIndex, int columnIndex) throws IllegalArgumentException{
        if (rowIndex < 0 || rowIndex > grid.length - 1) {
            throw new IllegalArgumentException("Invalid row index");
        }
        if (columnIndex < 0 || columnIndex > grid[rowIndex].length - 1) {
            throw new IllegalArgumentException("Invalid column index");
        }
        if (grid[rowIndex][columnIndex] != '\u0000') {
            throw new IllegalArgumentException("Grid position must be null");
        }

        grid[rowIndex][columnIndex] = value;
    }



    /**
     * Checks for valid input value
     * @param inputValue the char value to be checked
     * @return true if input value is X, x, O, or o
     * @throws IllegalArgumentException if character is not X or O
     */
    public boolean checkInput(char inputValue) throws IllegalArgumentException{
        if (inputValue == 'X' || inputValue == 'x' || inputValue == 'O' || inputValue == 'o') {
            return true;
        }
        else {
            throw new IllegalArgumentException("Input must be X, x, 0, or o.");
        }
    }



    /**
     * Checks if all positions have a char value
     * @return true if none of the grid locations contain the null character ('\u0000')
     */
    public boolean isFull(){
        boolean full = true;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '\u0000') {
                    full = false;
                }
            }
        }

        return full;
    }



    /**
     *  Check if row has all the same characters
     * @param rowIndex  the row index to check
     * @return  true if row contains the same char value
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public boolean isRowMatching(int rowIndex) throws IllegalArgumentException{
        boolean isMatching = true;
        if (rowIndex < 0 || rowIndex > grid.length - 1) {
            throw new IllegalArgumentException("Invalid row index");
        }

        char initialValue = grid[rowIndex][0];
        for (int column = 1; column < grid[rowIndex].length; column++) {
            if (grid[rowIndex][column] != initialValue) {
                isMatching = false;
            }
        }

        return isMatching;
    }



    /**
     * Check if column has all the same characters
     * @param columnIndex   the column index to check
     * @return  true if column contains the same char value
     * @throws IllegalArgumentException if an invalid column index is given
     */
    public boolean isColumnMatching(int columnIndex) throws IllegalArgumentException{
        boolean isMatching = true;
        if (columnIndex < 0 || columnIndex > grid.length - 1) {
            throw new IllegalArgumentException("Invalid column index");
        }

        char initialValue = grid[0][columnIndex];
        for (int row = 1; row < grid.length; row++) {
            if (grid[row][columnIndex] != initialValue) {
                isMatching = false;
            }
        }

        return isMatching;
    }



    /**
     * Checks if either diagonal has the same characters
     * @return true if grid position 0,0; 1,1; and 2,2 are the same
     *              if grid position 2,0; 1,1; and 0,2 are the same
     */
    public boolean hasDiagonalMatch(){
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        char checkValue = grid[1][1];

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != checkValue) {
                diagonal1 = false;
            }
        }
        if (grid[2][0] != checkValue && grid[0][2] != checkValue) {
            diagonal2 = false;
        }

        if (diagonal1 == true || diagonal2 == true) {
            return true;
        }
        else {
            return false;
        }

    }



    /**
     * Checks if there is a character with three in a row on the grid
     * @return winning character if there is a row, column or diagonal match
     *          otherwise returns the null character
     */
    public char checkForWinner(){
        char winningChar = '\u0000';

        for (int row = 0; row < grid.length; row++) {
            if (isRowMatching(row)) {
                winningChar = grid[row][0];
            }
        }
        for (int column = 0; column < grid.length; column++) {
            if (isColumnMatching(column)) {
                winningChar = grid[0][column];
            }
        }
        if (hasDiagonalMatch()) {
            winningChar = grid[1][1];
        }

        return winningChar;
    }



    @Override
    /**
     * Returns a string representation of the grid with each row separated by a line
     * @return string
     */
    public String toString() {
        return getRow(0) + "\n" + "---------" + "\n" + getRow(1) + "\n" + "---------" + "\n" + getRow(2) + "\n";
    }
}


