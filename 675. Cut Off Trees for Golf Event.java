public class Solution {

	public int cutOffTree(List<List<Integer>> forest) {

		PriorityQueue<HeapNode> heap = prepareHeap(forest);

		int retval = 0, nextRow = 0, nextCol = 0;
		while (!heap.isEmpty()) {
			boolean visited[][] = new boolean[forest.size()][forest.get(0).size()];
			HeapNode heapNode = heap.poll();
			QueueNode queueNode = bfs(forest, nextRow, nextCol, heapNode.row, heapNode.col, forest.size(), forest.get(0).size(), visited);
			if (queueNode == null)
				return -1;
			retval += queueNode.dist;
			nextRow = queueNode.row;
			nextCol = queueNode.col;
		}

		return retval;
	}

	private PriorityQueue<HeapNode> prepareHeap(List<List<Integer>> forest) {

		Comparator<HeapNode> comparator = new Comparator<Solution.HeapNode>() {
			@Override
			public int compare(HeapNode o1, HeapNode o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.val, o2.val);
			}
		};

		PriorityQueue<HeapNode> heap = new PriorityQueue<>(comparator);

		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(i).size(); j++) {
				if (forest.get(i).get(j) > 1)
					heap.offer(new HeapNode(forest.get(i).get(j), i, j));
			}
		}

		return heap;
	}

	private QueueNode bfs(List<List<Integer>> forest, int row, int col, int destRow, int destCol, int rows, int cols,
			boolean[][] visited) {
		
		Queue<QueueNode> queue = new LinkedList<>();
		queue.offer(new QueueNode(row, col, 0));

		while (!queue.isEmpty()) {
			QueueNode node = queue.poll();
			if (isValidCell(node.row, node.col, rows, cols) && !visited[node.row][node.col]) {
				int heightOfCurrentTree = forest.get(node.row).get(node.col);
				if (heightOfCurrentTree > 0) {
					visited[node.row][node.col] = true;

					if (node.row == destRow && node.col == destCol) {
						forest.get(node.row).set(node.col, 1);
						return node;
					}

					queue.offer(new QueueNode(node.row + 1, node.col, node.dist + 1));
					queue.offer(new QueueNode(node.row - 1, node.col, node.dist + 1));
					queue.offer(new QueueNode(node.row, node.col + 1, node.dist + 1));
					queue.offer(new QueueNode(node.row, node.col - 1, node.dist + 1));

				}
			}
		}

		return null;
	}

	boolean isValidCell(int row, int col, int rows, int cols) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}

	class QueueNode {
		int row, col, dist;

		public QueueNode(int row, int col, int dist) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "QueueNode [row=" + row + ", col=" + col + ", dist=" + dist + "]";
		}

	}

	class HeapNode {
		int val, row, col;

		public HeapNode(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
}