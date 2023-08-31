// Create three threads, one thread should print odd numbers, after that thread executes second thread needs to print even numbers and later third thread should print sum of first two threads in Java

public class NumberThreads {
    private static final int MAX_COUNT = 10;
    private static int oddCounter = 1;
    private static int evenCounter = 2;
    private static int sum = 0;
    
    public static void NumberThreads(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (oddCounter <= MAX_COUNT) {
                synchronized (NumberThreads.class) {
                    System.out.println("Odd Thread: "+ oddCounter);
                    sum += oddCounter;
                    oddCounter += 2;
                    NumberThreads.class.notifyAll();
                    try {
                        if (oddCounter <= MAX_COUNT) {
                            NumberThreads.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        Thread evenThread = new Thread(() -> {
            while (evenCounter <= MAX_COUNT) {
                synchronized(NumberThreads.class) {
                    System.out.println("Even Thread: "+ evenCounter);
                    sum += evenCounter;
                    evenCounter += 2;
                    NumberThreads.class.notifyAll();
                    try {
                        if (evenCounter <= MAX_COUNT) {
                            NumberThreads.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        Thread sumThread = new Thread(() -> {
            synchronized(NumberThreads.class) {
                while (oddCounter <= MAX_COUNT || evenCounter <= MAX_COUNT) {
                    try {
                        NumberThreads.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Sum Thread: Sum of Odd and Even Threads: " + sum);
            }
        });
        
        oddThread.start();
        evenThread.start();
        sumThread.start();
    }
}
