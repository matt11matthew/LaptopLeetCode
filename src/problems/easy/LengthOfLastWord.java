package problems.easy;

import problem.Problem;

/**
 * Created by Matthew E on 5/10/2024 at 10:27 AM for the project LaptopLeetCode
 */
public class LengthOfLastWord  extends Problem {
    @Override
    public void start() {

    }
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty())return 0;

        String[] s1 = s.split(" ");
        String last = s1[s1.length-1];
        return last.length();
    }

}
