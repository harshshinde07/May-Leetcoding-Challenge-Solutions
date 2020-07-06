// [9 May] Valid Perfect Square

class Solution {
    public boolean isPerfectSquare(int n) {
        if(n < 0) return false;
        if(n == 0) return true;

        long left = 1;
        long right = n;
        while(left <= right) {
            long mid = left + (right - left)/2;
            long square = mid * mid;

            if(square == n) {
                return true;
            } else if(square < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}