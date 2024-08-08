class Solution3 {
//    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//
//    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

//    输入：nums = [1,1,1,2,2,3]
//    输出：5, nums = [1,1,2,2,3]

//    有序意味着重复元素一定出现在一起
    public int removeElement(int[] nums) {
        int n = nums.length;
        if (n<=2){
            return n;
        }
//        int last = nums[0]; //记录上一个元素是什么
//        int rep = 1; //计数器，记录当前元素重复出现次数
//        无需计数器，因为重复元素一定出现在一起
        int k = 2;
        for(int i = 2; i < n; i++){
            if (nums[i] != nums[k-2]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
