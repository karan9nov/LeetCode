class Solution {

    public boolean isValidSudoku(char[][] board) {

        int boxCount = 0;
        List<Set<Character>> rowSet = new ArrayList<>();
        List<Set<Character>> colSet = new ArrayList<>();
        List<Set<Character>> boxSet = new ArrayList<>();

        for (int i = 0; i< board.length; i++) {
            rowSet.add(new HashSet<>());
            colSet.add(new HashSet<>());
            boxSet.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                int box = (i / 3) * 3 + j / 3;
                char val = board[i][j];
                if (val != '.') {
                    if (boxSet.get(box).contains(val)) return false;
                    boxSet.get(box).add(val);
                    if (rowSet.get(i).contains(val)) return false;
                    rowSet.get(i).add(val);
                    if (colSet.get(j).contains(val)) return false;
                    colSet.get(j).add(val);
                }
            }
        }

        return true;
    }

}
