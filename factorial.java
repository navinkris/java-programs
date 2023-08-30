// Program to compute factorial of a given number in java

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int num;
        BigInteger res=BigInteger.ONE;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number whose factorial needs to be computed");
        num = sc.nextInt();
        if(num <= 0) {
            System.out.println("Enter a valid number whose factorial needs to be computed ");
        } else {
            for(int i=1;i<=num;++i) {
                // res *= i;   
                res = res.multiply(BigInteger.valueOf(i));
            }
        }
        System.out.print("Factorial of num "+num+" is "+ res);
        
    }
}
