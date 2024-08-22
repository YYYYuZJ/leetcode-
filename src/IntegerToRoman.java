import sun.text.normalizer.UCharacter;

import java.util.Stack;

public class IntegerToRoman {
//Seven different symbols represent Roman numerals with the following values:
//Symbol	Value
//
//Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
//
//    If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
//    append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
//    If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
//    for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
//    Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
//    Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
//    You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
//    If you need to append a symbol 4 times use the subtractive form.
//
//Given an integer, convert it to a Roman numeral.
//
//
//
//Example 1:
//
//Input: num = 3749
//
//Output: "MMMDCCXLIX"
//
//Explanation:
//
//3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
// 700 = DCC as 500 (D) + 100 (C) + 100 (C)
//  40 = XL as 10 (X) less of 50 (L)
//   9 = IX as 1 (I) less of 10 (X)
//Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
//
//Example 2:
//
//Input: num = 58
//
//Output: "LVIII"
//
//Explanation:
//
//50 = L
// 8 = VIII
//
//Example 3:
//
//Input: num = 1994
//
//Output: "MCMXCIV"
//
//Explanation:
//
//1000 = M
// 900 = CM
//  90 = XC
//   4 = IV
//
//
//
//Constraints:
//
//    1 <= num <= 3999
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//Thousands place: Add as many M's as the thousands digit.
//Hundreds place:
//    900: CM
//    500 < x < 900: D + (x-500)/100 C's
//    500: D
//    400: CD
//    100 <= x < 400: x/100 C's
//Tens place:
//    90: XC
//    50 < x < 90: L + (x-50)/10 X's
//    50: L
//    40: XL
//    10 <= x < 40: x/10 X's
// Units place:
//    9: IX
//    5 < x < 9: V + (x-5)/1 I's
//    5: V
//    4: IV
//    1 <= x < 4: x I's
    public String intToRoman(int num) {
        String ans = "";
        int i = 0;
        int j = 0;
        char a,b,c;
        Stack<Character> stack = new Stack<>();
        while (num > 0) {
            j = num % 10;
            if (i == 0) {
                a = 'I';
                b = 'V';
                c = 'X';
            } else if (i == 1) {
                a = 'X';
                b = 'L';
                c = 'C';
            } else if (i == 2) {
                a = 'C';
                b = 'D';
                c = 'M';
            } else {
                for (int k = 0; k < j; k++) {
                    stack.push('M');
                }
                break;
            }
            if (j > 0 && j < 4){
                for (int k = 0; k < j; k++) {
                    stack.push(a);
                }
            } else if (j == 4) {
                stack.push(b);
                stack.push(a);
            } else if (j == 5) {
                stack.push(b);
            } else if (j > 5 && j < 9) {
                for (int k = 0; k < j - 5; k++) {
                    stack.push(a);
                }
                stack.push(b);
            } else if (j == 9) {
                stack.push(c);
                stack.push(a);
            }
            ++ i;
            num /= 10;
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
