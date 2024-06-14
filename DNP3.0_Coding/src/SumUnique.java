/*
Sum of Unique Digits
Write a function to find the sum of unique digits in a given number N. The number will be passed to the
function as an input parameter of type int.
Assumption: The input number will be a positive integer >= 1 and <= 25000.
Examples:
• If the given number is 292, the function should return 9 because the unique digit '9' in this
number has a sum of 9.
• If the given number is 1015, the function should return 6 because the unique digits '1', '0', and
'5' in this number have a sum of 1 + 0 + 5 = 6.
• If the given number is 108, the function should return 9 because the unique digits '1', '0', and '8'
in this number have a sum of 1 + 0 + 8 = 9.
• If the given number is 22, the function should return 0 because there are NO unique digits in this
number.
* */

import java.util.Scanner;

public class SumUnique
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int N = in.nextInt();
        System.out.println("Sum of unique digits in the given number is "+ calcUniqueSum(N) + "." );
    }

    private static int calcUniqueSum(int N)
    {
        int digits[]=new int[10];
        int sum=0;
        while(N!=0)
        {
            int d=N%10;
            digits[d]++;
            N=N/10;
        }
        for(int i=0;i<10;i++)
        {
            if(digits[i]==1)
                sum+=i;
        }
        return sum;
    }
}
