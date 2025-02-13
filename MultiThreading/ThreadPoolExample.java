/*📌 Why ExecutorService?

  Reuses threads instead of creating new ones.
  Controls the number of concurrent threads.

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
  public static void main(String[] args) {
      ExecutorService executor = Executors.newFixedThreadPool(3);

      for(int i=1; i<=6; i++) {
        final int taskID = i;
        executor.execute(() -> {
          System.out.println("Task "+ taskID+ " executed by "+Thread.currentThread().getName());
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
      }

      executor.shutdown();
  }
}
