// Write a program to calculate and return the sum of absolute difference between the adjacent number in an array of positive integers from the position entered by the user.

// Note : You are expected to write code in the findTotalSum function only which receive three positional arguments:

// 1st : number of elements in the array
// 2nd : array
// 3rd : position from where the sum is to be calculated

// Example

// Input
// input 1 : 7
// input 2 : 11 22 12 24 13 26 14
// input 3 : 5

// Output
// 25

// Explanation

// The first parameter 7 is the size of the array. Next is an array of integers and input 5 is the position from where you have to calculate the Total Sum. The output  is 25 as per calculation below. 
// | 26-13 | = 13
// | 14-26 | =  12
// Total Sum = 13 + 12 = 25

import java.util.Scanner;
import java.lang.Math;

public class FindTotalSumFromPos{
    public static int findTotalSum(int num, int[] arr, int pos) {
        int difference, sum=0;
        for(int i = pos-1; i<num-1; i++) {
            difference = Math.abs(arr[i]-arr[i+1]);
            sum = sum + difference;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int num, pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to be present in an array");
        num = sc.nextInt();
        int[] arr = new int[num]; 
        System.out.println("Enter the elements of the array ");
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the position from where the total sum needs to be computed ");
        pos = sc.nextInt();
        int result = findTotalSum(num, arr, pos);
        System.out.println("The total sum from the pos = "+ result);
    }
}
