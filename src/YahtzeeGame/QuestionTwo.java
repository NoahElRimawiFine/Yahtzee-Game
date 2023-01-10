package YahtzeeGame;

import java.util.Arrays;

public class QuestionTwo {

    // write a method called getSmallestDifference that takes in an array of integers and
    // returns the smallest non-negative difference between two integers in the array
    // e.g. getSmallestDifference({1, 2, 3, 4, 5}) returns 1
    // e.g. getSmallestDifference({1, 6, 20}) returns 5
    // e.g. getSmallestDifference({1, 4, 6, 7}) returns 1
    // e.g. getSmallestDifference({1, 3, 6, 10, 12, 15, 20}) returns 2

    // this is the O(n^2) solution
    public static int getSmallestDifference(int[] arr, int n) {
        // TODO: ADD YOUR CODE HERE
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs((arr[i] - arr[j])) < diff) {
                    diff = Math.abs(arr[i] - arr[j]);
                }
            }
        }
        return diff;
    }

    // this is the O(nlogn) solution
    public static int getSmallestDifference2(int[] arr, int n) {
        // TODO: ADD YOUR CODE HERE
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs((arr[i] - arr[i + 1])) < diff) {
                diff = Math.abs(arr[i] - arr[i + 1]);
            }
        }
        return diff;
    }

    // this is the O(n) solution
    public static int getSmallestDifference3(int[] arr, int n) {
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find the min and max values in the array
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }
        int prev = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (count[i] > 0) {
                if (i - prev < diff) {
                    diff = i - prev;
                }
                prev = i;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 12, 22, 5};
        int n = arr.length;
        System.out.println(getSmallestDifference3(arr, n));

    }

}
