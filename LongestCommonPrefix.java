import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int i = 0;
        while(i < s1.length() && i < s2.length()) {
            if(s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return s1.substring(0, i);
    }
        
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            words[i] = read.next();
        }
        System.out.println(longestCommonPrefix(words));
    }
}
