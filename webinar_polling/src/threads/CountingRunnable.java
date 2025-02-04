package threads;


public class CountingRunnable implements Runnable{
    
    private Design d;
    protected boolean doStop = false;
    
    public CountingRunnable(Design d) {
        this.d = d;
    }
    
    @Override
    public void run() {
        while(!doStop) {
            System.out.println("Counting the vote of "+ d.getName() + " has " + d.getVotes().size() + " votes");
        
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
