import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
  private final Queue<Integer> queue = new LinkedList<>();
  private final int LIMIT = 5;

  public synchronized void produce(int value) throws InterruptedException {
    while (queue.size() == LIMIT) {
      wait();
    }
    queue.add(value);
    System.out.println("Produced: "+value);
    notify();
  }

  public synchronized void consume() throws InterruptedException {
    while (queue.isEmpty()) {
      wait();
    }
    int value = queue.poll();
    System.out.println("Consumed: "+value);
    notify();
  }
}

public class ProducerConsumer {
  public static void main(String[] args) {
    SharedQueue queue = new SharedQueue();

    Thread producer = new Thread(() -> {
      try {
        for(int i = 1; i <= 10; i++) {
          queue.produce(i);
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread consumer = new Thread(() -> {
      try {
          for (int i = 1; i <= 10; i++) {
            queue.consume();
            Thread.sleep(1000);
          }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    producer.start();
    consumer.start();
  }
}
