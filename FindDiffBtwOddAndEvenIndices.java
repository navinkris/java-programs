// Write a program to find the difference between the elements at odd index and even index.

// Note : You are expected to write code in the findDifference function only which receive the first parameter as the numbers of items in the array and second parameter as the array itself. You are not required to take the input from the console.

// Example

// Finding the maximum difference between adjacent items of a list of 5 numbers

// Input
// input 1 : 7
// input 2 : 10 20 30 40 50 60 70

// Output
// 40

// Explanation
// The first parameter 7 is the size of the array. Sum of element at even index of array is 10 + 30 + 50 + 70 = 160 and sum of elements at odd index of array is 20 + 40 + 60 = 120. The difference between both is 40

import java.util.Scanner;
import java.lang.Math;

public class FindDiffBtwOddAndEvenIndices {
    
    public static int findDifference(int n, int[] arr) {
        int oddSum = 0, evenSum = 0;
        for(int i = 0; i < n; i++) {
            if(i%2==0) {
                evenSum = evenSum + arr[i];
            } else {
                oddSum = oddSum + arr[i];
            }
        }
        System.out.println("Odd Sum is "+oddSum);
        System.out.println("Even Sum is "+evenSum);
        return Math.abs(oddSum - evenSum);
    }
    
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array ");
        num = sc.nextInt();
        int[] arr = new int[num];
        System.out.println("Enter the elements of the array ");
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int result = findDifference(num, arr);
        System.out.println("The difference between sum of elements at odd index and sum of elements at even index is "+result);
    }
    
}
