package problems.medium;

import problem.Problem;

import java.util.Arrays;

/**
 * Created by Matthew E on 5/10/2024 at 10:05 AM for the project LaptopLeetCode
 */
public class StringToIntegerAtoi  extends Problem {
    @Override
    public void start() {

    }

    public  int myAtoi(String s) {
        s = s.trim();

        // Early return for empty or whitespace-only strings
        if (s.isEmpty()) {
            return 0;
        }


        for (String s1 : Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")) {
            if (s.toLowerCase().startsWith(s1)) return 0;
        }


        String pattern = "^[+-]?\\d+";
        java.util.regex.Pattern pat = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher matcher = pat.matcher(s);
        if (matcher.find()) {

            String numberStr = matcher.group(0).trim();
            try {
                long longValue = Long.parseLong(numberStr);
                // Check overflow/underflow
                if (longValue > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (longValue < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    return (int) longValue;
                }
            } catch (NumberFormatException e) {
                // In case the string representation itself is not parseable as a long
                return numberStr.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
