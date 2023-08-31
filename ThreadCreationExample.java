// Program to demonstrate thread creation in Java using Runnable interface and Thread class

public class ThreadCreationExample {
    public static void main(String[] args) {
        
        // Creating a Thread using Runnable interface
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        
        // Creating a Thread using Thread class
        MyThread thread2 = new MyThread();
        
        // Starting both threads
        thread1.start();
        thread2.start();
    }
}

// Using Runnable interface
class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        for(int i = 1; i <= 5 ; i++) {
            System.out.println("Thread using Runnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Using Thread class 
class MyThread extends Thread {
    
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Thread using Thread class: "+ i);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
