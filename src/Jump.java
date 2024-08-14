class Solution8 {
//    You are given an integer array nums. You are initially positioned at the array's first index,
//    and each element in the array represents your maximum jump length at that position.
//    Return true if you can reach the last index, or false otherwise.
//
//    Example1:
//    Input: nums = [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//    Example2:
//    Input: nums = [3,2,1,0,4]
//    Output: false
//    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//    Constraints:
//    1 <= nums.length <= 104
//    0 <= nums[i] <= 105
//不断搜索当前索引i + nums[i]的最大值，判断这个值是否大于当前数组最后一个位置的索引，如果大于，就说明能到达
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int line = nums[0];
        for(int i = 0; i < n; i++){
            if(i > line){
                return false;
            }
            line = Math.max(line, i + nums[i]);
            if(line >= n - 1){
                return true;
            }
        }
        return true;
    }
}
