package inheritance_and_polymorphism;

public class Lab1 {
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
		private static long accCounter = 1000;
		private long  AccNum;
		private double balance;
		private Person Acchold;
		private final double Min_balance=500;
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
		
		
	}
public static void main(String[] args) {
	Person smith=new Lab1.Person("Smith", 23);
	Person kathy=new Lab1.Person("Kathy", 23);
	Account smith1=new Lab1.Account(2000, smith);
	Account kathy1=new Lab1.Account(3000, kathy);
	
	smith1.Deposit(2000);
	
	kathy1.WithDraw(2000);
	
	
	System.out.println(smith1);
	System.out.println(kathy1);
	
	
	
}
}
