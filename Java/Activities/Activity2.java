package activities;
// In this activity, we are writing a program to check if the sum of all the 10's
// in the array is exactly 30.
import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args){

        int numArr[] = {10, 77, 10, 54, -11, 10};
        System.out.println("Array Provided is " + Arrays.toString(numArr));

        int findNum =10, sum =30;
        System.out.println("The Result is " + result(numArr, findNum, sum));

    }
    public static boolean result(int[] numbers, int findNum, int sum){
        int temp_sum = 0;
        for (int num : numbers){
            if (num == findNum){
                temp_sum += findNum;
            }
            if (temp_sum > sum){
                break;
            }
        }
        return temp_sum == sum;
    }
}
