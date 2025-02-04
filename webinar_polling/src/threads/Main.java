package threads;

public class Main {

    public static void main(String[] args) {
        Design d1 = new Design(1, "D1");
        
        // Creating object of the VotingRunnable for design 1
        VotingRunnable vr1 = new VotingRunnable(d1);
        
        // Creating object of the CountingRunnable for design 1
        CountingRunnable cr1 = new CountingRunnable(d1);
        
        // Creating a new Thread instance, passing in the VotingRunnable object for design1
        Thread td11 = new Thread(vr1);
        
        // Creating a new Thread instance, passing in the CountingRunnable object for design1
        Thread td12 = new Thread(cr1);
        
        // Starting the voting thread for design 1
        td11.start();
        
        // Starting the counting thread for design 1
        td12.start();
        
        Design d2 = new Design(2, "D2");
        
        // Creating object of the VotingRunnable for design 2
        VotingRunnable vr2 = new VotingRunnable(d2);
        
        // Creating object of the CountingRunnable for design 2
        CountingRunnable cr2 = new CountingRunnable(d2);
        
        // Creating a new Thread instance, passing in the VotingRunnable object for design 2
        Thread td21 = new Thread(vr2);
        
        // Creating a new Thread instance, passing in the CountingRunnable object for design 2
        Thread td22 = new Thread(cr2);
        
        // Starting the voting thread for design 2
        td21.start();
        
        // Starting the counting thread for design 2
        td22.start();
        
        Design d3 = new Design(3, "D3");
        
        // Creating object of the VotingRunnable for design 3
       VotingRunnable vr3 = new VotingRunnable(d3);
       
       // Creating object of the CountingRunnable for design 3
       CountingRunnable cr3 = new CountingRunnable(d3);
       
       // Creating a new Thread instance, passing in the VotingRunnable object for design3
       Thread td31 = new Thread(vr3);
       
       // Creating a new Thread instance, passing in the CountingRunnable object for design3
       Thread td32 = new Thread(cr3);
       
       // Starting the voting thread for design 3
       td31.start();
       
       // Starting the counting thread for design 3
       td32.start();
       
       try {
           Thread.currentThread().sleep(30000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       
       vr1.doStop = true;
       vr2.doStop = true;
       vr3.doStop = true;
       cr1.doStop = true;
       cr2.doStop = true;
       cr3.doStop = true;
       
       System.out.println("Voting has stopped for design "+ d1.getName());
       System.out.println("Total votes for " + d1.getName() + ": " + d1.getVotes().size());
       System.out.println("Voting has stopped for design "+ d2.getName());
       System.out.println("Total votes for " + d2.getName() + ": " + d2.getVotes().size());
       System.out.println("Voting has stopped for design "+ d3.getName());
       System.out.println("Total votes for " + d3.getName() + ": " + d3.getVotes().size());
    }
}
