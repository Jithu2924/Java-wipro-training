package lab3;


public class Lab2{
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }}

	
	
	public class Person{
		private String name;
		private float age;
		public Person(String name,float age )throws InvalidAgeException {
			if(age<18.0) {
				throw new InvalidAgeException("The should be minimum 18");
			}
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
	    try {
	        Person kathy = new Lab2().new Person("Kathy", 23);
	        Account kathy1 = new Lab2.Account(3000, kathy);

	        kathy1.WithDraw(2000);
	        System.out.println(kathy1);
	        Person smith = new Lab2().new Person("Smith", 18); 
	        Account smithAcc = new Lab2.Account(2000, smith);
	        System.out.println(smithAcc);
	        
	    } catch (InvalidAgeException e) {
	        System.out.println("Exception: " + e.getMessage());
	    }
	}

}
