import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    
    public static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<expr.length(); i++) {
            char ch = expr.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                       return false;
                   }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String input = read.nextLine();
        System.out.println(input + " is " + (areBracketsBalanced(input) ? "Balanced" : "Not Balanced"));
    }
}
