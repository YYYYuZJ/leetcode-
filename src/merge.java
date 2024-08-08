class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for(int i = 0; i < m; i++){
            nums3[i] = nums1[i];
        }
        for (int i = 0, j = 0; i < m || j < n;) {
            if (i >= m) {
                nums1[i + j] = nums2[j];
                j ++;
                continue;
            }
            if (j >= n) {
                nums1[i + j] = nums3[i];
                i ++;
                continue;
            }
            if (nums3[i] < nums2[j]) {
                nums1[i + j] = nums3[i];
                i ++;
            }
            else {
                nums1[i + j] = nums2[j];
                j ++;
            }
        }

    }
}
