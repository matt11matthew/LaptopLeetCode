package problem;

/**
 * Created by Matthew E on 5/8/2024 at 10:40 AM for the project LaptopLeetCode
 */
public abstract class Problem {

    public abstract void start();

    protected void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
