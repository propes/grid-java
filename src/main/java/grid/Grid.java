package grid;

import java.util.Arrays;

public class Grid {
    private final int[] data;
    private final int cols;

    public Grid(int[] data, int cols) {
        this.data = Arrays.copyOf(data, data.length);
        this.cols = cols;
    }

    public Grid(int rows, int cols) {
        data = new int[rows * cols];
        this.cols = cols;
    }

    public Grid(int length) {
        data = new int[length * length];
        cols = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return Arrays.equals(data, grid.data) && cols == grid.cols;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    public Grid copy() {
        return new Grid(data, cols);
    }

    public int cell(int row, int col) {
        return data[row * cols + col % cols];
    }

    public int pos(int i) {
        return data[i];
    }

    public int[] toFlatArray() {
        return data;
    }

    public int[][] toArray() {
        int rows = this.rows();
        int[][] twoD = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                twoD[row][col] = cell(row, col);
            }
        }
        return twoD;
    }

    public int columns() {
        return cols;
    }

    public int rows() {
        return (int) Math.ceil((double) data.length / cols);
    }
}
