import sun.text.normalizer.UCharacter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        int[] prices = {0,1,0,2,1,0,1,3,2,1,2,1};
        String ans = solution.intToRoman(9);
        System.out.println(ans);
    }
}

//["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
//        [[],[0],[1],[0],[2],[1],[]]