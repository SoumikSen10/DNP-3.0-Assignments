package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort
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
        insertionSort(arr,arr.length);
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int arr[],int n)
    {
        for(int i=1;i<n;i++)
        {
            int key=arr[i];
            int j=i-1;
            while(j>-1 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}


