// [10 May] Find the Town Judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N == 1) return 1;
        int[] arr = new int[N + 1];
        for(int[] i: trust) {
            arr[i[0]]--;
            arr[i[1]]++;
        }
        for(int i = 0; i <= N; i++) {
            if(arr[i] == N - 1) return i;
        }
        return -1;
    }
}