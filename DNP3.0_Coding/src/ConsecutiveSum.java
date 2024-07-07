/*
Consecutive Sum
Write a function to find the sum of all possible consecutive numbers that add up to a given positive
integer N. The function should return a list of lists, where each sublist represents a consecutive sequence
of numbers that add up to N.
Assumption: The input number N will be a positive integer >= 1 and <= 25000.
Examples:
• If N is 5, the function should return [[2, 3], [5]] because 2 + 3 = 5 and 5 = 5.
• If N is 15, the function should return [[1, 2, 3, 4, 5], [4, 5, 6], [7, 8], [15]] because 1 + 2 + 3 + 4 + 5
= 15, 4 + 5 + 6 = 15, 7 + 8 = 15, and 15 = 15.
• If N is 10, the function should return [[1, 2, 3, 4], [4, 5], [10]] because 1 + 2 + 3 + 4 = 10, 4 + 5 =
10, and 10 = 10.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsecutiveSum
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int N = in.nextInt();
        List<List<Integer>> consecutives = findConsecutives(N);
        System.out.println("All possible consecutives numbers that add upto "+N+" are: ");
        System.out.println(consecutives);
    }

    private static List<List<Integer>> findConsecutives(int N) {
        List<List<Integer>> result = new ArrayList<>();

        for (int start = 1; start <= N; start++) {
            int currentSum = 0;
            int num = start;
            while (currentSum < N) {
                currentSum += num;
                num++;
            }
            if (currentSum == N) {
                List<Integer> sequence = new ArrayList<>();
                for (int i = start; i < num; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
            }
        }

        return result;
    }
}
