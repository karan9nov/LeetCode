class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0 || image[0].length == 0) return image;

        if (newColor != image[sr][sc])
            dfs(image, sr, sc, newColor, image.length, image[0].length, image[sr][sc]);

        return image;
    }

    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int origColor) {

        if (isValidCell(sr, sc, rows, cols) && image[sr][sc] == origColor) {
            image[sr][sc] = newColor;
            dfs(image, sr+1, sc, newColor, rows, cols, origColor);
            dfs(image, sr-1, sc, newColor, rows, cols, origColor);
            dfs(image, sr, sc+1, newColor, rows, cols, origColor);
            dfs(image, sr, sc-1, newColor, rows, cols, origColor);
        }

    }
}
