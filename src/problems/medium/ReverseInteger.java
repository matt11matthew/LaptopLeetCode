package problems.medium;

import problem.Problem;

/**
 * Created by Matthew E on 5/10/2024 at 10:07 AM for the project LaptopLeetCode
 */
public class ReverseInteger  extends Problem {
    @Override
    public void start() {
//        System.out.println(reverse(123));
        reverse(123);
    }

    public int reverse(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        boolean negative = charArray[0]=='-';
        String out = "";
        if (negative)out="-";
        for (int i = charArray.length-1; i >= (negative?1:0); i--) {
            int v = charArray[i]-'0';
            System.out.println(v);
            out+=v;
        }
        int output;
        try {
            output=Integer.parseInt(out);
        } catch (Exception e) {
            System.err.println("OVERFLOW");
            return 0;
        }
        return output;
    }
}
