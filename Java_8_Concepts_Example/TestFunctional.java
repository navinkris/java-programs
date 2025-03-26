package com.kyakarotz.cruddemo;

import java.util.ArrayList;

interface FuncInterface {
    
    void abstractFun(int x);
    
    default void normalFun()
    {
        System.out.println("Hello");
    }
}

@FunctionalInterface
interface ZeroParameter {
    void display();
}

@FunctionalInterface
interface Functional {
    int operation(int a, int b);
}

public class TestFunctional {
    public static void main(String args[]) {
        
        // Functional Interface Example
        FuncInterface fobj = (int x) -> System.out.println(2*x);
        fobj.abstractFun(5);
        
        // Lambda expression with zero parameters
        ZeroParameter zeroParamLambda = () -> System.out.println("This is zero parameter lambda expression");
        zeroParamLambda.display();
        
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        
        // Using lambda expression to print all elements
        System.out.println("Elements of the ArrayList : ");
        arrL.forEach(n -> System.out.println(n));
        
        // Using lambda expression to print even elements of arrL
        System.out.println("Even elements of the ArrayList : ");
        arrL.forEach(n -> { 
            if(n%2== 0) {
                System.out.println(n);
            }
        });
        
        Functional sum = (a, b) -> a + b;
        Functional multiply = (a, b) -> a * b;
        
        System.out.println(sum.operation(5, 5));
        System.out.println(multiply.operation(2, 4));
    }
}
