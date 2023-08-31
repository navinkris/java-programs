// Java program to check if the given string is a palindrome or not and also to check largest palindrome in a given string

public class PalindromeExample {
    
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static String findLargestPalindrome(String str) {
        String largestPalindrome = "";
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (isPalindrome(substring) && substring.length() > largestPalindrome.length()) {
                    largestPalindrome = substring;
                }
            }
        }
        
        return largestPalindrome;
    }
    
    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama!";
       
        if (isPalindrome(input)) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }
        
        String largestPalindromeString = findLargestPalindrome(input);
        System.out.println("Largest palindrome substring: " + largestPalindromeString);
    }
}
