import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Candy solution = new Candy();
        int[] prices = {1,3,4,5,2};
        int ans = solution.candy(prices);
        System.out.println(ans);
    }
}

//["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
//        [[],[0],[1],[0],[2],[1],[]]