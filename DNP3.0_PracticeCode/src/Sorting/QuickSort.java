package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort
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
        quickSort(arr,0,arr.length-1);
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[],int begin,int end)
    {
        if(begin<end)
        {
            int pivot=partition(arr,begin,end); //returns the pivot index
            quickSort(arr,begin,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    public static int partition(int arr[],int begin,int end)
    {
        int pivot=arr[end];
        int i=begin-1;

        for(int j=begin;j<end;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;
        return i;
    }

}


