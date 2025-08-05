package inheritance_and_polymorphism;

public class Lab5 {
	public abstract class Account {
	    protected long accNum;
	    protected double balance;

	    public Account(long accNum, double balance) {
	        this.accNum = accNum;
	        this.balance = balance;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public abstract void withdraw(double amount);  
	}

}
