class MyThread extends Thread {
  public void run() {
    System.out.println("Thread running: " + Thread.currentThread().getName());
  }
}

class RunnableThread implements Runnable {
  @Override
  public void run() {
    System.out.println("Runnable thread running: " + Thread.currentThread().getName());
  }
}

public class ThreadExample {
    public static void main(String[] args) {
      MyThread t1 = new MyThread();
      t1.setName("Thread from class");
      t1.start();
      Thread t2 = new Thread(new RunnableThread());
      t2.setName("Thread implementing runnable interface");
      t2.start();
    }
}
