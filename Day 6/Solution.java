// [6 May] Majority Element

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        int mid = len / 2;

        for(int i: nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int majority = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > mid) {
                majority = key;
            }
        }
        return majority;
    }
}