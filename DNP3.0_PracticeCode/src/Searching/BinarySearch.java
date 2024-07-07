package Searching;

import java.util.Scanner;

public class BinarySearch
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
        System.out.print("Enter the element to be searched: ");
        int x=in.nextInt();
        int p=binaryRecur(arr,x);
        if(p==-1)
            System.out.println(x+" is not present in array");
        else
            System.out.println(x+" is present in array at position "+(p+1));
    }

    public static int binarySearch(int arr[],int x)
    {
        int left=0,right=arr.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]==x)
                return mid;
            if(arr[mid]<x)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
    }

    public static int binaryRecur(int arr[],int x)
    {
        int n=arr.length;
        return helper(arr,0,n-1,x);
    }

    public static int helper(int arr[],int left,int right,int x)
    {
        if(left<=right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                return helper(arr, mid + 1, right, x);
            else
                return helper(arr, left, mid - 1, x);
        }
        return -1;
    }

}


