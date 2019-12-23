/*
Task: find the index of two element which add up to the target
Input: a int array and one int target
Output: a int array which contains two element index.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (!hm.containsKey(nums[i])) {
                hm.put(difference, i);
            }
            else {
                result[0] = hm.get(nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
