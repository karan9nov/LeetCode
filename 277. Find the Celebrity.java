/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {

    public int findCelebrity(int n) {

        int potentialCelebrity = -1;

        for (int i = 0; i < n; i++) {
            potentialCelebrity = i;
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i,j)) {
                    potentialCelebrity = - 1;
                    break;
                }
            }

            for (int k = 0; k < n && potentialCelebrity != -1; k++) {
                if (k != potentialCelebrity && !knows(k,potentialCelebrity)) {
                    potentialCelebrity = -1;
                    break;
                }
            }

            if (potentialCelebrity != -1) return potentialCelebrity;
        }

        return potentialCelebrity;

    }
}
