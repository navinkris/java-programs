class Deadlock {
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  void method1() {
    // Method to show deadlock getting caused
    // synchronized (lock1) {
    //   System.out.println("Thread1: Holding lock1...");
    //   try {
    //       Thread.sleep(100);
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }

    //   synchronized (lock2) {
    //       System.out.println("Thread1: Holding lock2...");
    //   }
    // }

    synchronized (lock1) {
      synchronized (lock2) {
        System.out.println("Thread1:Holding both locks...");
      }
    }
  }

  void method2() {
    // Method to show deadlock getting caused
    // synchronized (lock2) {
    //   System.out.println("Thread2: holding lock2...");
    //   try {
    //     Thread.sleep(100);
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }
    //   synchronized (lock1) {
    //     System.out.println("Thread2: Holding lock1...");
    //   }
    // }
    synchronized (lock1) {
      synchronized (lock2) {
        System.out.println("Thread2:Holding both locks...");
      }
    }
  }
}

public class DeadlockExample {
  public static void main(String[] args) {
    Deadlock obj = new Deadlock();
    Thread t1 = new Thread(obj::method1);
    Thread t2 = new Thread(obj::method2);
    t1.start();
    t2.start();
  }
}
