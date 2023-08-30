// Write a program to return the difference between the count of odd numbers and even numbers.

// Note : You are expected to write code in the countOddEvenDifference function only which will receive the first parameter as the number of items in the array and second parameter as the array itself. you are not required to take input from the console.

// Example
// Finding the difference between the count of odd and even numbers from a list of 5  number

// Input
// input 1 : 8
// input 2 : 10 20 30 40 55 66 77 83

// Output
// -2

// Explanation
// The first paramter (8) is the szie of the array. Next is an array of integers. The calculation of difference between count sum of odd and even numbers is as follows:

// 3 (count of odd numbers) minus 5 (count of even numbers) = -2

import java.util.Scanner;

public class CountOddEvenDifference {
    public static void main(String[] args) {
        int num, countOdd = 0, countEven = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array ");
        num = sc.nextInt();
        int[] oddEvenArr = new int[num];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < num; i++) {
            oddEvenArr[i] = sc.nextInt();
        }
        for(int i = 0; i < oddEvenArr.length; i++) {
            if(oddEvenArr[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        num = countOdd - countEven;
        System.out.println("Count of odd numbers in the array is: "+countOdd);
        System.out.println("Count of even numbers in the array is: "+countEven);
        System.out.println("Difference between "+countOdd+" (Count of odd numbers) - "+countEven+" (Count of even numbers) = "+ num);
    }
}
