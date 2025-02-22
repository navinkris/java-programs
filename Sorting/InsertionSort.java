/* Insertion Sort in Java
Insertion Sort is a simple and efficient sorting algorithm that works similarly to how we sort playing cards in our hands. It builds the sorted list one element at a time by shifting larger elements to the right and inserting the new element at the correct position.

Algorithm
Start from the second element (index 1).
Compare it with elements before it.
Shift larger elements one position to the right.
Insert the current element at the correct position.
Repeat for all elements.
*/


import java.util.*;

public class Main {
  
    public static void insertionSort(int[] arr) {
      int n = arr.length;
      for(int i=1; i<n; i++) {
        int key = arr[i];
        int j = i-1;
        
        while(j>=0 && arr[j] > key) {
          arr[j+1] = arr[j];
          j--;
        }
        
        arr[j+1] = key;
      }
    }
    
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      
      System.out.println("Enter the number of elements: ");
      int n = read.nextInt();
      int[] arr = new int[n];
      
      System.out.println("Enter the elements: ");
      for(int i=0; i<n; i++) {
        arr[i] = read.nextInt();
      }
      
      insertionSort(arr);
      
      System.out.println("Sorted array: ");
      for(int num: arr) {
        System.out.print(num + " ");
      }
      
      read.close();
  }
}
