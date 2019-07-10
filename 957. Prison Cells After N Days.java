class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {

        int ans[] = new int[cells.length];
        int arr[] = new int[cells.length];

        for (int i = 0; i < cells.length; i++)
            ans[i] = cells[i];

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j < cells.length - 1; j++) {
                if (ans[j-1] == ans[j+1])
                    arr[j] = 1;
                else
                    arr[j] = 0;
            }

            ans = Arrays.copyOfRange(arr, 0, arr.length);

            if (i%14 == N%14)
                break;
        }

        return ans;
    }
}
