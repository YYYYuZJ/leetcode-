class Solution2 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if (nums[i] != nums[i - 1] ){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
