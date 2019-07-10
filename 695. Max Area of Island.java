class Solution {
    public int maxAreaOfIsland(int[][] grid) {

		int max = 0;
		int rows = grid.length, cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1 && visited[i][j] == false) {
					int[] currentArea = new int[1];
					dfs(grid, i, j, rows, cols, visited, currentArea);
					max = Math.max(max, currentArea[0]);
				}
			}
		}
		return max;
    }
	
	private void dfs(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited, int[] currentArea) {
		// TODO Auto-generated method stub
		if (isValidCell(row, col, rows, cols) && grid[row][col] == 1 && visited[row][col] == false) {
            visited[row][col] = true;
			currentArea[0]+=1;
			dfs(grid, row+1, col, rows, cols, visited, currentArea);
			dfs(grid, row-1, col, rows, cols, visited, currentArea);
			dfs(grid, row, col+1, rows, cols, visited, currentArea);
			dfs(grid, row, col-1, rows, cols, visited, currentArea);
		}
	}

	private boolean isValidCell(int row, int col, int rows, int cols) {
		// TODO Auto-generated method stub
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}
}