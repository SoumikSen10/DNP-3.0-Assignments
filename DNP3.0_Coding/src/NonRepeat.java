/*

Non-Repeated Digits Count
Write a function to find the count of non-repeated digits in a given number N. The number will be
passed to the function as an input parameter of type int.
Assumption: The input number will be a positive integer number >= 1 and <= 25000.
Some examples are as below -
If the given number is 292, the function should return 1 because there is only 1 non-repeated digit '9' in
this number
If the given number is 1015, the function should return 2 because there are 2 non-repeated digits in this
number, '0', and '5'.
If the given number is 108, the function should return 3 because there are 3 non-repeated digits in this
number, '1', '0', and '8'.
If the given number is 22, the function should return 0 because there are NO non-repeated digits in this
number.

*/


import java.util.Scanner;

class NonRepeat
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int N = in.nextInt();
        System.out.println("Number of non-repeated digits in the given number is "+ calcNonRepeat(N) + "." );
    }

    private static int calcNonRepeat(int N)
    {
        int digits[]=new int[10];
        int count=0;
        while(N!=0)
        {
            int d=N%10;
            digits[d]++;
            N=N/10;
        }
        for(int i=0;i<10;i++)
        {
            if(digits[i]==1)
                count++;
        }
        return count;
    }
}
