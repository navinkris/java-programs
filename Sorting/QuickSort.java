import java.util.*;

public class QuickSort {
  
    public static int partition(int arr[], int low, int high) {
      int pivot = arr[high];
      int i = low-1;
      
      for(int j=low; j<high; j++) {
        if(arr[j] < pivot) {
          i++;
          //swap
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      i++;
      int temp = arr[i];
      arr[i] = pivot;
      arr[high] = temp;
      return i; // pivot index
    }
    
    public static void quickSort(int arr[], int low, int high) {
      if (low < high) {
        int pidx = partition(arr, low, high);
        
        quickSort(arr, low, pidx-1);
        quickSort(arr, pidx+1, high);
      }
    }
    
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      System.out.println("Enter the size of array: ");
      int n = read.nextInt();
      System.out.println("Enter the elements of the array: ");
      int arr[] = new int[n];
      for(int i=0; i<n; i++) {
        arr[i] = read.nextInt();
      }
      
      quickSort(arr, 0, n-1);
      
      for(int i=0; i<n; i++) {
        System.out.print(arr[i]+" ");
      }
  }
}
