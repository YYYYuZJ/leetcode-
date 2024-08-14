class Solution9 {
//    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:0 <= j <= nums[i] and i + j < n
//    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

//    Example 1:
//
//    Input: nums = [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//    Example 2:
//
//    Input: nums = [2,3,0,1,4]
//    Output: 2

//    Constraints:
//
//            1 <= nums.length <= 104
//            0 <= nums[i] <= 1000
//    It's guaranteed that you can reach nums[n - 1].
//Solution1
// 动态规划，d[i]代表当前位置到达n - 1处所需最小跳跃步数，d[i] = max{d[i + 1] -- d[i + j]} + 1
//初始化为 1 + n，然后倒序初始化即可。
//但是动态规划时间复杂度为N(n^2)
//Solution2
//greedy algrithm,think about JumpGame1,you just go forward,and examine whether the position now can reach n - 1
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int line = nums[0];
        int i = 0;
        while(line < n - 1){
            int temp = line;
            while(i <= temp){
                line = Math.max(line, i+nums[i]);
                ++ i;
            }
            if(temp >= line){
                return Integer.MAX_VALUE;
            }
            ++ jumps;
        }
        ++ jumps;
        return jumps;
    }

}
