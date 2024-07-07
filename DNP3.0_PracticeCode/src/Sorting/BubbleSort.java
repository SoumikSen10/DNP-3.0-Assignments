package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n=in.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements in array: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        System.out.print("The original array is: ");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr,arr.length);//modified bubble sort
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[],int n)
    {
        int flag=1;
        for(int i=0;i<n-1;i++)
        {
            if(flag==0)
                break;
            flag=0;
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
        }
    }
}


