package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort
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
        selectionSort(arr,arr.length);
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int arr[],int n)
    {
        for(int i=0;i<n-1;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            }
        }
    }
}


