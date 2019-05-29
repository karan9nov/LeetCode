class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> retval = new HashSet<>();
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (String word:words) {
            if (word.length() == 0 || retval.contains(word)) continue;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[rows][cols];
                        // visited[i][j] = false;
                        // System.out.println("word = " + word + "\nrow = " + i + "\ncol = " + j);
                        if (dfs(board, visited, word, i, j, rows, cols)) {
                            retval.add(word);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<String>(retval);
        
    }
    
    private boolean dfs (char[][] board, boolean[][] visited, String word, int row, int col, int rows, int cols) {
        
        if (word.length() == 0) {
            return true;
        }
        
        if (isValidCell(row, col, rows, cols) && !visited[row][col]){
            if (board[row][col] == word.charAt(0)){
                visited[row][col] = true;
                if (dfs(board, visited, word.substring(1), row+1, col, rows, cols)) {
                    // System.out.println("word = " + word + "(" + row + "," + col + ")");
                    return true;
                }
                if (dfs(board, visited, word.substring(1), row-1, col, rows, cols)) {
                    // System.out.println("word = " + word + "(" + row + "," + col + ")");
                    return true;
                }
                if (dfs(board, visited, word.substring(1), row, col+1, rows, cols)) {
                    // System.out.println("word = " + word + "(" + row + "," + col + ")");
                    return true;
                } if (dfs(board, visited, word.substring(1), row, col-1, rows, cols)) {
                    // System.out.println("word = " + word + "(" + row + "," + col + ")");
                    return true;
                }
                visited[row][col] = false;
            }
        }
        
        return false;
    }
    
    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row>=0 && row<rows && col>=0 && col<cols;
    }
}