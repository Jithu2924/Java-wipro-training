package lab2;


public class Lab2 {
	public static class Person{
		private String name;
		private float age;
		public Person(String name,float age ) {
			this.name=name;
			this.age=age;
		}

		public String toString() {
			return "Person={name :"+name+" age :"+age+"}";
		}
		
	}
	public static class Account{
		protected static long accCounter = 1000;
		protected long  AccNum;
		protected double balance;
		protected Person Acchold;
		protected final double Min_balance=500;
		public Account(double balance,Person Acchold) {
			this.AccNum=accCounter++;
			this.Acchold=Acchold;
			this.balance=balance;
		}
		public String Deposit(double amount) {
			if(amount>0) {
				this.balance=this.balance+amount;
				return "Balance : Rs."+this.balance;
				
			}else {
				return "Invalid amount";
			}
			
		}
		public String WithDraw(double amount) {
			if(this.balance-amount>500) {
			this.balance=this.balance-amount;
			return "Withdraw successful and balance : Rs."+this.balance;
			} else {
				return "Inefficient balance";
			}
		}

		public String toString() {
	            return "Account{" +
	                    "accNum=" + AccNum +
	                    ", balance=" + balance +
	                    ", accHolder=" + Acchold +
	                    '}';
	        }
		
		
		public static class SavingsAcc extends Account{
			private static final double MINIMUM_BALANCE = 500;

			public SavingsAcc(double balance, Person Acchold) {
				super(balance, Acchold);
			}
			@Override
			public String WithDraw(double amount) {
				if(this.balance-amount>MINIMUM_BALANCE) {
				this.balance=this.balance-amount;
				return "Withdraw successful from savings and balance : Rs."+this.balance;
				} else {
					return "Inefficient balance";
				}
			}
			
		}
		public static class CurrentAcc extends Account{
			private double overdraftlimit;
			
			public CurrentAcc(double balance, Person Acchold, double overdraftlimit) {
				super(balance, Acchold);
				this.overdraftlimit=overdraftlimit;
			}
			@Override
			public String WithDraw(double amount) {
				if(this.balance-amount>= -overdraftlimit) {
					this.balance=this.balance-amount;
					return "Withdraw successful from current and balance : Rs."+this.balance;
				} else {
					return "Inefficient balance";
				}
			}
			
		}
	}
public static void main(String[] args) {
	Person smith=new Lab2.Person("Smith", 23);
	
	Account savings = new Account.SavingsAcc(1000, smith);
    Account current = new Account.CurrentAcc(1000, smith, 1500);
	
	
	
	
	System.out.println(savings);
	System.out.println(current);
	
	
	
}
}
