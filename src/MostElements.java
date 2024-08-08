//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。


import java.util.Arrays;
import java.util.HashMap;


class Solution4 {
    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = arr[left];
        int l = left, r = right;
        boolean flag = false;
        while (l < r) {
            if(!flag){
                if (arr[r] >= k){
                    --r;
                }
                else{
                    flag = true;
                    arr[l] = arr[r];
                }
            }
            else{
                if (arr[l] <= k){
                    ++l;
                }
                else{
                    flag = false;
                    arr[r] = arr[l];
                }
            }
        }
        arr[l] = k;
        sort(arr, l + 1, right);
        sort(arr, left, r - 1);
    }
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return nums[0];
        }
        sort(nums, 0, n - 1);
        int count = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]){
                count ++;
                if(count > n / 2){
                    return nums[i];
                }
            }
            else{
                count = 1;
            }
        }
        return 0;
    } //Timeout
    public int majorityElement2(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        if(n <= 2){
            return nums[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else{
                int count = map.get(num);
                count += 1;
                if(count > n/2){
                    return num;
                }
                map.put(num,count);
            }
        }
        return 0;
    }

}
