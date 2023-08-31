// Given an array of numbers n, return output array such that the resulting array at particular indices are the product of the other indices except at that index in java

// Example Input: [ 1, 2, 3, 4]
// Example Output: [24, 12, 8, 6]

public class ProductArrayExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] output = new int[n];
        
        //Calculate left products
        int leftProduct = 1;
        for(int i=0; i<n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        //Calculate right products
        int rightProduct = 1;
        for(int i=n-1; i>=0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }
        
        //Calculate output array
        for(int i = 0; i < n; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }
        
        return output;
    }
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] output = productExceptSelf(input);
        
        for(int num: output) {
            System.out.print(num + " ");
        }
    } 
}
