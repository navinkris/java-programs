
import java.util.ArrayList;
import java.util.Arrays;

interface FuncInterface {
  void abstractFun(int x);

  default void normalFun() {
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

public class LambdasDemo {
  public static void main(String[] args) {
      FuncInterface fObj = (int x) -> System.out.println(2*x);
      fObj.abstractFun(5);
    
      ZeroParameter zeroParamLambda = () -> System.out.println("This is a zero-parameter lamda expression!");
      zeroParamLambda.display();

      ArrayList<Integer> arrL = new ArrayList<>();
      arrL.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4}));
      System.out.println("Elements of the ArrayList: ");
      arrL.forEach(n -> System.out.println(n));
      System.out.println("Even elements of the ArrayList :");
      arrL.forEach(n -> {
        if(n%2==0) {
          System.out.println(n);
        }
      });

      Functional add = (a, b) -> a + b;
      Functional multiply = (a, b) -> a * b;
      System.out.println(add.operation(6, 3));
      System.out.println(multiply.operation(4, 5));
  }
}
