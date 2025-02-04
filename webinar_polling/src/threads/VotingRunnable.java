package threads;

public class VotingRunnable implements Runnable{
    
    private Design d;
    protected boolean doStop = false;
    
    public VotingRunnable(Design d) {
        this.d = d;
    }
    
    @Override
    public void run() {
        while(!doStop) {
            System.out.println("Voting for the design "+ d.getName());
            d.getVotes().add(1L);
            
            Double randomNumber = Math.random() * 1000;
            
            try {
                Thread.sleep(randomNumber.longValue());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
