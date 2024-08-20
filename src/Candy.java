public class Candy {
//There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//
//You are giving candies to these children subjected to the following requirements:
//
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//
//Return the minimum number of candies you need to have to distribute the candies to the children.
//
//
//
//Example 1:
//
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//
//Example 2:
//
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
//
//
//
//Constraints:
//
//    n == ratings.length
//    1 <= n <= 2 * 10^4
//    0 <= ratings[i] <= 2 * 10^4
// [1,3,2,2,1]
// [1,2,1,2,1]
// [.....min....min1.....min2......]
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = 0;
        int[] allocate = new int[n];
        allocate[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                allocate[i] = allocate[i - 1] + 1;
            }
            else {
                allocate[i] = 1;
            }
        }
        candies += allocate[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && allocate[i] <= allocate[i + 1]) {
                allocate[i] = allocate[i + 1] + 1;
            }
            candies += allocate[i];
        }
        return candies;
    }
}
