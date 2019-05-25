class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        if (cols == 0) return 0;

        int total = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    total += 1;
                    numIslandsDFS(grid, visited, i, j, rows, cols);
                }
            }
        }

        return total;
    }

    private void numIslandsDFS(char[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {

        if(isValidCell(row, col, rows, cols) && grid[row][col] == '1' && !visited[row][col]) {
            visited[row][col] = true;
            numIslandsDFS(grid, visited, row + 1, col, rows, cols);
            numIslandsDFS(grid, visited, row - 1, col, rows, cols);
            numIslandsDFS(grid, visited, row, col + 1, rows, cols);
            numIslandsDFS(grid, visited, row, col - 1, rows, cols);
        }
    }

    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row>=0 && row<rows && col>=0 && col<cols;
    }
}
