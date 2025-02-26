import java.util.*;

public class BinarySearch {
  
    public static int binarySearchIterative(int[] arr, int target) {
      int left = 0, right = arr.length - 1;
      while(left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
          return mid;
        } else if (arr[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return -1;
    }
    
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
      if (left <= right) {
        int mid = left + (right - left)/2;
        
        if(arr[mid] == target) {
          return mid;
        } else if (arr[mid] < target) {
          return binarySearchRecursive(arr, mid + 1, right, target);
        } else {
          return binarySearchRecursive(arr, left, mid-1, target);
        }
      }
      return -1;
    }
    
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      System.out.println("Enter the number of elements in the array: ");
      int n = read.nextInt();
      System.out.println("Enter the elements of the array");
      int arr[] = new int[n];
      for(int i=0; i<n; i++) {
        arr[i] = read.nextInt();
      }
      System.out.println("Enter the target element to be searched in the array: ");
      int target = read.nextInt();
      int result1 = binarySearchIterative(arr, target);
      System.out.println(result1 != -1 ? "Element found at index: "+result1: "Element not found");
      int result2 = binarySearchRecursive(arr, 0, arr.length - 1, target);
      System.out.println(result2 != -1 ? "Element found at index: "+result2: "Element not found");
  }
}
