package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort
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
        mergeSort(arr,0,arr.length-1);
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int arr[],int begin,int end)
    {
       if(begin<end)
       {
           int mid=begin+(end-begin)/2;
           mergeSort(arr,begin,mid);
           mergeSort(arr,mid+1,end);
           merge(arr,begin,mid,end);
       }
    }

    public static void merge(int arr[],int begin,int mid,int end)
    {
        int n1=mid-begin+1;
        int n2=end-mid;

        //Creating the two sub-arrays
        int sub1[]=new int[n1];
        int sub2[]=new int[n2];

        for(int i=0;i<n1;i++)
        {
            sub1[i]=arr[begin+i];
        }

        for(int j=0;j<n2;j++)
        {
            sub2[j]=arr[mid+1+j];
        }

        //Indexes of sub1,sub2
        int i=0,j=0;
        int k=begin; // initial index of merged sub-array
        while(i<n1 && j<n2)
        {
            if(sub1[i]<=sub2[j])
            {
                arr[k]=sub1[i];
                i++;
            }
            else
            {
                arr[k]=sub2[j];
                j++;
            }
            k++;
        }

        while(i<n1)
        {
            arr[k]=sub1[i];
            i++;
            k++;
        }

        while(j<n2)
        {
            arr[k]=sub2[j];
            j++;
            k++;
        }
    }
}


