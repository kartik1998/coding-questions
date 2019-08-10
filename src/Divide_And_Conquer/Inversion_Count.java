package Divide_And_Conquer;

import java.util.Scanner;
// Use BigInteger to submit on websites to avoid overflow.
public class Inversion_Count {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(mergeSort(arr,0,n-1));
        }
    }
    public static int mergeSort(int arr[],int s,int e){
        int inv_count=0;
        if(s<e){
            int mid=(s+e)/2;
            inv_count=mergeSort(arr,s,mid);
            inv_count+=mergeSort(arr,mid+1,e);
            inv_count+=merge(arr,s,mid+1,e);
        }
        return inv_count;
    }
    public static int merge(int arr[],int s,int mid,int e){
        int inv_count=0;
        int temp[]=new int[e-s+1];
        int k=0;
        int i=s;
        int j=mid;
        while(i<=(mid-1) && j<=e){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i];
                i++;
            }else{
                temp[k++]=arr[j];
                inv_count+=(mid-i);
                j++;
            }
        }
        while(i<=(mid-1)){
            temp[k++]=arr[i++];
        }
        while(j<=e){
            temp[k++]=arr[j++];
        }
        k=0;
        for(int in=s;in<=e;in++){
            arr[in]=temp[k++];
        }
        return inv_count;

    }
}
