import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//another approach
class ConsequetiveSum1
{

    public static List<List<Integer>> findSum(int N){
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 1;
        int currentSum = 0;

        while (start <= N ) {
            if (currentSum < N) {
                currentSum += end;
                end++;
            } else if (currentSum > N) {
                currentSum -= start;
                start++;
            } else {
                List<Integer> sequence = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
                currentSum -= start;
                start++;
            }
        }
        if (N == currentSum) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(N);
            result.add(sequence);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int N = sc.nextInt();
        System.out.println(findSum(N));
        sc.close();
    }
}