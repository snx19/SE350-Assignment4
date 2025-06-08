/**
 * Class Matrix that forms a 2D matrix of int
 * Has methods to set, get, and return dimensions of matrix
 */
public class Matrix {
    private char[][] data;

    /**
     * Make matrix with specified rows and columns
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws IllegalArgumentException if row or columns less than 1
     */
    // constructor that takes number of rows / columns
    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) { // ensures there's at least 1 row and column
            throw new IllegalArgumentException("rows and cols must be greater than 0");
        }
        data = new char[rows][cols];
        clear();
    }

    /**
     * clears the data
     */
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = ' ';
            }
        }
    }

    /**
     *
     * @param x x position
     * @param y y position
     * @param c character
     */
    public void setCell(int x, int y, char c) {
        if (x < 0 || x >= getCols() || y < 0 || y >= getRows()) {
            return;
        }
        data[y][x] = c;}

    /**
     * Returns cell value
     * @param x x position
     * @param y y position
     * @return the array
     */
    public char getCell(int x, int y) { // getter
        return data[y][x];
    }


    /**
     * returns number of rows in matrix
     * @return number of rows
     */
    public int getRows() { // method to get first dimension of array (Row)
        return data.length;
    }

    /**
     * return number of columns
     *
     * @return number of columns
     */
    public int getCols() { // method to get second dimension of array (Column)
        return data[0].length;
    }

    /**
     * prints out rows/columns
     */
    public void print() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                System.out.print(data[i][j]);
            }
            System.out.println(); // print newline after each row
        }
    }

    public char[] getRow(int i) {
        return data[i];
    }
}
