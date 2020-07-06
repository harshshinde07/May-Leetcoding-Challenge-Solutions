// [8 May] Check If It Is a Straight Line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];

        float slope = calculateSlope(point1, point2);

        for(int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[0];
            int[] p2 = coordinates[i];
            float s = calculateSlope(p1, p2);

            if(s != slope) return false;
        }
        return true;
    }

    float calculateSlope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}