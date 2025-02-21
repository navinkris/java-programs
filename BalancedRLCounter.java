/*  Given a string containing only R and L. Find the number of balanced substrings(equal number of L’s and R’s) 
    you will encounter where you can traverse only in the left-right direction.
    
    Example 1: RLRRLLRLRL  Answer: 4 (RL, RRLL, RL, RL)
    
    Example 2: LLLLRRRR  Answer:1 (LLLLRRRR)
    
    Example 3: RLLLLRRRLR  Answer:3 (RL, LLLRRR, LR)

    Solve in java

*/

import java.util.Scanner;

public class BalancedRLCounter {
    public static int countBalancedSubstrings(String s) {
        int count = 0, balancedCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                count++;
            } else if (ch == 'L') {
                count--;
            }

            // If count is 0, we found a balanced substring
            if (count == 0) {
                balancedCount++;
            }
        }

        return balancedCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string containing only 'R' and 'L': ");
        String input = scanner.next();

        // Closing the scanner
        scanner.close();

        // Displaying the result
        System.out.println("Number of balanced substrings: " + countBalancedSubstrings(input));
    }
}
