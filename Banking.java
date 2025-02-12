abstract class Account {
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void calculateInterest(double amount, int days);
}

class SavingsAccount extends Account{
    
    private int rateOfInterest = 3;
    private double balance = 0;
    
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " into savings account");
        balance+=amount;
        System.out.println("Remaining balance in savings account is "+balance);
    }
    
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrew " + amount + " from savings account");
        balance-=amount;
        System.out.println("Remaining balance in savings account is "+balance);
    }
    
    @Override
    public void calculateInterest(double amount, int days) {
        System.out.println("Interest is being calculated for remaining balance in account for "+days+" days");
        System.out.println("Remaining balance in current account is "+balance);
        System.out.println("Please wait........");
        System.out.println("The current balance and interest by the end of "+ days +" days will be "+ (balance * days * rateOfInterest)/100);
    }
    
}

class CurrentAccount extends Account{
    
    double balance = 0;
    
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " into current account");
        balance+=amount;
        System.out.println("Remaining balance in current account is "+balance);
    }
    
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrew " + amount + " from current account");
        balance-=amount;
        System.out.println("Remaining balance in current account is "+balance);
    }
    
    @Override
    public void calculateInterest(double amount, int days) {
        System.out.println("Interest is being calculated for remaining balance in account for "+days+" days");
        System.out.println("Remaining balance in current account is "+balance);
        System.out.println("Please wait........");
        System.out.println("The current balance and interest by the end of "+ days +" days will be "+ amount);
    }
}

public class Banking {
    public static void main(String[] args) {
        Account curAccount = new CurrentAccount();
        curAccount.deposit(10000);
        curAccount.withdraw(5000);
        curAccount.calculateInterest(5000, 100);
        Account savAccount = new SavingsAccount();
        savAccount.deposit(10000);
        savAccount.withdraw(5000);
        savAccount.calculateInterest(5000, 100);
    }
}
