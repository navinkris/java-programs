// Program to compute Fibonacci series of n numbers in Java

import java.util.Scanner;

public class SimpleFibonacci{
	public static void main(String[] args) {
		int firstNum=0, secondNum=1, res, num;
		Scanner s1 = new Scanner(System.in);
		num = s1.nextInt();
		for(int i=1; i<=num; i++) {
			if(i != num) {
					System.out.print(firstNum+ " ");
			} else {
					System.out.print(firstNum);
			}
			res = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = res;
		}
	}
}
