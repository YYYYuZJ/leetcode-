import java.util.Arrays;

class Solution5 {
//    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//            Example 1:
//
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]
//      [1,2,3,4,5,6]
//      [_,2,1,4,5,6] 3
//      [_,2,1,4,3,6] 5
//      [5,2,1,4,3,6]
//      [5,_,1,2,3,6] 4
//      [5,-,1,2,3,4] 6
//      [5,6,1,2,3,4]
    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            k = k % n;
        }
        if(k == 0){
            return;
        }
        int left = 0, right = n - 1;
        int temp = 0;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
        left = 0;
        right = k - 1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
        left = k;
        right = n - 1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
        printArray(nums);
        return;
    }
}
