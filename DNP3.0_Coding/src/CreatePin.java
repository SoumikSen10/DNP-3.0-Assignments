/*
pCreate PIN using three given input numbers
"Secure Assets Private Ltd", a small company that deals with lockers has recently started manufacturing
digital locks which can be locked and unlocked using PINs (passwords). You have been asked to work on
the module that is expected to generate PINs using three input numbers.
Assumptions: The three given input numbers will always consist of three digits each i.e. each of them
will be in the range >=100 and <=999
100 <= input1 <= 999
100 <= input2 <= 999
100 <= input3 <= 999
Below are the rules for generating the PIN -
- The PIN should be made up of 4 digits
- The unit (ones) position of the PIN should be the least of the units position of the three input numbers
- The tens position of the PIN should be the least of the tens position of the three input numbers
- The hundreds position of the PIN should be the least of the hundreds position of the three input
numbers
- The thousands position of the PIN should be the maximum of all the digits in the three input numbers
Example 1 -
input1 = 123
input2 = 582
input3 = 175
then, PIN = 8122
Example 2 -
input1 = 190
input2 = 267
input3 = 853
then, PIN = 9150
*/

import java.util.Scanner;

public class CreatePin
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1=in.nextInt();
        System.out.print("Enter the second number: ");
        int num2=in.nextInt();
        System.out.print("Enter the third number: ");
        int num3=in.nextInt();

        int pin=generatePin(num1,num2,num3);
        System.out.println("The generated PIN = "+pin);
    }

    public static int generatePin(int A,int B,int C)
    {
       int digitsA[] = extractDigits(A);
       int digitsB[] = extractDigits(B);
       int digitsC[] = extractDigits(C);

       //ones position
       int ones= Math.min(digitsA[2],Math.min(digitsB[2],digitsC[2]));
       int tens= Math.min(digitsA[1],Math.min(digitsB[1],digitsC[1]));
       int hundreds= Math.min(digitsA[0],Math.min(digitsB[0],digitsC[0]));
       int maxDigit = getMaxDigit(digitsA,digitsB,digitsC);

       return maxDigit*1000+hundreds*100+tens*10+ones;
    }

    private static int[] extractDigits(int N)
    {
        int digits[]=new int[3];
         digits[0]=(N/100)%10;
         digits[1]=(N/10)%10;
         digits[2]=N%10;
        return digits;
    }

    private static int getMaxDigit(int[] digitsA,int[] digitsB,int[] digitsC)
    {
        int maxDigit=digitsA[0];
        for(int i=0;i<3;i++)
        {
            maxDigit=Math.max(maxDigit,digitsA[i]);
            maxDigit=Math.max(maxDigit,digitsB[i]);
            maxDigit=Math.max(maxDigit,digitsC[i]);
        }
        return maxDigit;
    }

}
