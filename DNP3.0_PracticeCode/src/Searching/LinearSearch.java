package Searching;

import java.util.Scanner;

public class LinearSearch
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
        int p=linearSearch(arr,x);
        if(p==-1)
            System.out.println(x+" is not present in array");
        else
            System.out.println(x+" is present in array at position "+(p+1));
    }

    public static int linearSearch(int arr[],int x)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==x)
                return i;

        }
        return -1;
    }
}


