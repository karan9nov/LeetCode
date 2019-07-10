class Solution {
    public int snakesAndLadders(int[][] board) {
        
		int n = board.length;
		Queue<Position> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
		queue.add(new Position(1, 0));
        visited.add(1);
        
		while (!queue.isEmpty()) {
			
			Position currPos = queue.poll();
			for (int i = 1; i <= 6; i++) {
                
				int[] rowCol = getRowCol(currPos.location + i, n);
				Position nextPos;
				if (board[rowCol[0]][rowCol[1]] == -1) {
					nextPos = new Position(getValue(rowCol[0], rowCol[1], n), currPos.moves + 1);
				} else {
					nextPos = new Position(board[rowCol[0]][rowCol[1]], currPos.moves + 1);
				}
				if (nextPos.location == n * n) return nextPos.moves;
                
                if (!visited.contains(nextPos.location)) {
				    queue.offer(nextPos);
                    visited.add(nextPos.location);
                }
			}
		}
		
		return -1;
		
    }

	class Position {
		int location;
		int moves;
		
		public Position(int location, int moves) {
			// TODO Auto-generated constructor stub
			this.location = location;
			this.moves = moves;
		}
	}

	private int[] getRowCol(int val, int n) {
		int q = (val - 1) / n;
		int rem = (val - 1) % n;
		int row = n - 1 - q;
		int col = row % 2 != n % 2 ? rem : n - 1 - rem;
		return new int[] { row, col };
	}
	
	private int getValue(int row, int col, int n) {
		int q = n - 1 - row;
		int rem = row % 2 != n % 2 ? col : n - 1 - col;
		return q * n + rem + 1;
	}
}