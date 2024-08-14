class Solution10 {
//Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
//
//According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

//Example 1:
//
//Input: citations = [3,0,6,1,5]
//Output: 3
//Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
//Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
//
//Example 2:
//
//Input: citations = [1,3,1]
//Output: 1

//Constraints:
//
//    n == citations.length
//    1 <= n <= 5000
//    0 <= citations[i] <= 1000
// Sort in descending order. For each index i,
// the value i + 1 represents the number of papers with citations greater than or equal to citations[i].
// We need to find the largest citations[i] such that i + 1 >= citations[i].
    public void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pr = sort(nums, low, high);
            quicksort(nums, low, pr - 1);
            quicksort(nums, pr + 1, high);
        }
        return;
    }

    int sort(int[] nums, int low, int high) {
        int pr = high;
        int num_mid = nums[high];
        while(low < high) {
            while(nums[low] >= num_mid && low < high) {
                ++ low;
            }
            nums[pr] = nums[low];
            pr = low;
            while(nums[high] <= num_mid && low < high) {
                -- high;
            }
            nums[pr] = nums[high];
            pr = high;
        }
        nums[pr] = num_mid;
        return pr;
    }
    public int hIndex(int[] citations) {
        int n = citations.length;
        quicksort(citations, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i + 1 > citations[i]){
                return i;
            }
            if (i + 1 == citations[i]){
                return i + 1;
            }
        }
        return n;
    }
    public int hIndex2(int[] citations) {
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            arr[citations[i]]++;
        }
        //3,0,1,1,1,1,1,1,1,1,5
// arr  //1,8,0,1,0,1
        //0 1 2 3 4 5
        int total = 0;
        for (int h = max; h >= 0; h--) {
            if(arr[h]<=h){
                total+=arr[h];
            }else{
                return h;
            }
            if(total>=h){
                return h;
            }
        }
        return 0;
    }
}

//class Solution {
//    public int hIndex(int[] citations) {
//        int max = 0;
//        for (int i = 0; i < citations.length; i++) {
//            max = Math.max(max, citations[i]);
//        }
//        int[] arr = new int[max + 1];
//        for (int i = 0; i < citations.length; i++) {
//            arr[citations[i]]++;
//        }
//        //至此，我们得到一个排序完成的数组
//        //按照h-index的定义，我们需要找一个最大的h，使其满足至少有h篇文章的引用次数大于等于h
//        //因此我们按照引用次数将citations数组从高到低排序，然后按引用次数从高到低统计文章数量
//        //total记录引用次数大于等于当前h的文章总数，如果total大于等于当前h，那就满足至少有h篇
//        //引用次数大于等于h的文章，可以返回当前h，如果一直到循环结束都没有找到足够数量的文章，那
//        //只能返回0
//        int total = 0;
//        for (int h = max; h >= 0; h--) {
//            total+=arr[h];
//            if(total>=h){
//                return h;
//            }
//        }
//        return 0;
//    }
//}