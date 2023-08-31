// Count the number of characters and occurrence of each character in the string.

public class StringCompressionExample {
    public static String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        
        char currentChar = input.charAt(0);
        int charCount = 1;
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                charCount++;
            } else {
                compressed.append(charCount).append(currentChar);
                currentChar = input.charAt(i);
                charCount = 1;
            }
        }
        
        compressed.append(charCount).append(currentChar);
        return compressed.toString();
    };
    
    public static void main(String[] args) {
        String input = "aaaaaabbcccccddaaa";
        String compressed = compressString(input);
        System.out.println(compressed);
    }
}
