import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        int[] prices = {-1,2,3,5};
        int[] ans = solution.productExceptSelf(prices);
        System.out.println(Arrays.toString(ans));
    }
}

//["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
//        [[],[0],[1],[0],[2],[1],[]]