import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution10 solution = new Solution10();
        int[] prices = {3,0,1,1,1,1,1,1,1,1,5};
        System.out.println(solution.hIndex2(prices));
    }
}

//3,0,1,1,1,1,1,1,1,1,5
//
//1,9,0,1,0,1
//0 1 2 3 4 5
