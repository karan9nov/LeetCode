public class Solution {

	public double findMedianSortedArrays(int[] X, int[] Y) {

		if (Y.length < X.length)
			return findMedianSortedArrays(Y, X);

		// Length of both arrays
		int lenX = X.length, lenY = Y.length;

		int start = 0, end = lenX;
		int numberOfLeftElements = (lenX + lenY + 1) / 2;

		while (start <= end) {

			// Find the partition points
			int parX = (start + end) / 2;
			int parY = numberOfLeftElements - parX;

			// Find Max of Left Side
			int maxLeftX = parX == 0 ? Integer.MIN_VALUE : X[parX - 1];
			int maxLeftY = parY == 0 ? Integer.MIN_VALUE : Y[parY - 1];

			// Find Min of Right Side
			int minRightX = parX == lenX ? Integer.MAX_VALUE : X[parX];
			int minRightY = parY == lenY ? Integer.MAX_VALUE : Y[parY];

			if (maxLeftX > minRightY) {
				// move to the Left of X
				end = parX - 1;
			} else if (maxLeftY > minRightX) {
				// move to the right of X
				start = parX + 1;
			} else {
				if ((lenX + lenY) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			}
		}

		return -1;
	}
}
