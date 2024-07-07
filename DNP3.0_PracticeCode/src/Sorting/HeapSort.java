package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort
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
        heapSort(arr);
        System.out.print("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[])
    {
        // Build heap(rearrange the array
        for(int i=(arr.length/2)-1;i>=0;i--)
        {
            heapify(arr,i,arr.length);
        }

        for(int i=arr.length-1;i>=0;i--)
        {
            int temp=arr[0]; // Swap heap root with the last element
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i); // Heapify root with heapsize=i
        }
    }

    public static void heapify(int heap[],int curr,int size)
    {
        int largest=curr;
        int l=2*curr+1; //left child
        int r=2*curr+2; //right child

        if(l<size && heap[l]>heap[largest])
        {
            largest=l;
        }
        if(r<size && heap[r]>heap[largest])
        {
            largest=r;
        }
        if(largest!=curr)
        {
            int temp=heap[curr];
            heap[curr]=heap[largest];
            heap[largest]=temp;

            heapify(heap,largest,size);
        }
    }

}


