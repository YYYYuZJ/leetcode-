import java.util.Stack;

public class TappingRainWater {
//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
//
//Example 1:
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
//In this case, 6 units of rain water (blue section) are being trapped.
//
//Example 2:
//
//Input: height = [4,2,0,3,2,5]
//Output: 9
//

//Constraints:
//
//    n == height.length
//    1 <= n <= 2 * 10^4
//    0 <= height[i] <= 10^5
// We can fix a left pointer in place and move the right pointer to the right, accumulating the values along the way.
// Once we encounter a value at the right pointer that is greater than or equal to the value at the left pointer,
// we can calculate the amount of water trapped using the formula:
//min(left,right)×(right−left−1)−accumulated sum
//where 'accumulated sum' represents the total value added along the path.
//but there's a problem:maybe we will never found a value greater than the left
//What we need to do is fix the left pointer and continuously move to the right to find a value greater than or equal to the value
//at the left pointer, while maintaining a monotonic stack throughout the search.
// If we find such a value, we can directly calculate the trapped water for that segment and then move the left pointer
// to the position of the right pointer. If no such value is found, we then sequentially pop indexes from the monotonic stack
// and calculate the trapped water for each segment until the stack is empty.
//    public int trap(int[] height) {
//        int n = height.length;
//        Stack<Integer> stack = new Stack<>();
//        int left = 0, right = 1;
//        int water = 0;
//        int sum = 0;
//        while (right < n) {
//            if (height[right] >= height[left]) {
//                water += (height[left] * (right - left - 1) - sum);
//                left = right;
//                ++ right;
//                stack.clear();
//                sum = 0;
//            }
//            else {
//                sum += height[right];
//                while (!stack.isEmpty() && height[right] >= height[stack.peek()]) {
//                    stack.pop();
//                }
//                stack.push(right);
//                ++ right;
//            }
//        }
//        int h = stack.size();
//        int[] queue = new int[stack.size()];
//        int j = stack.size() - 1;
//        while (!stack.isEmpty()) {
//            queue[j--] = stack.pop();
//        }
//        int k = 0;
//        while (k < h) {
//            right = queue[k];
//            sum = 0;
//            for (int i = left + 1; i < right; i++) {
//                sum += height[i];
//            }
//            water += ((Math.min(height[left], height[right])) * (right - left - 1) - sum);
//            left = right;
//            ++ k;
//        }
//        return water;
//    }
// 4,0,0,0,3
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
