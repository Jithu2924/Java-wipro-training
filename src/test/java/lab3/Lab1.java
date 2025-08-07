package lab3;


	import java.util.Scanner;

	public class Lab1 {
	    String firstName;
	    String lastName;
	    public enum Gender {M, F}
	    Gender gender;
	    String phone;  
	    public Lab1() {
	    }


	    public Lab1(String firstName, String lastName, Gender gender, String phone) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	        this.phone = phone;
	    }


	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public Gender getGender() {
	        return gender;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public class InvalidNameException extends Exception {
	        public InvalidNameException(String message) {
	            super(message);
	        }
	    }


	    
	    
	    public void setFirstName(String firstName) throws InvalidNameException {
	        if (firstName == null || firstName.trim().isEmpty()) {
	            throw new InvalidNameException("First name cannot be blank.");
	        }
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) throws InvalidNameException {
	        if (lastName == null || lastName.trim().isEmpty()) {
	            throw new InvalidNameException("Last name cannot be blank.");
	        }
	        this.lastName = lastName;
	    }


	    public void setGender(Gender gender) {
	        this.gender = gender;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    // Main method
	    public static void main(String[] args)  {
	        Lab1 person = new Lab1();
	        try {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter First name");
	        person.setFirstName(sc.nextLine());
	        System.out.println("Enter Last name");
	        person.setLastName(sc.nextLine());
	        person.setGender(Gender.M);

//	        System.out.print("Add the phone number: ");
//	        person.setPhone(sc.next());  
//
//	        System.out.println("\n----- Person Details -----");
	        System.out.println("First Name : " + person.getFirstName());
	        System.out.println("Last Name  : " + person.getLastName());
	        System.out.println("Gender     : " + person.getGender());
//	        System.out.println("Phone No   : " + person.getPhone());
	        }catch(InvalidNameException e) {
	        	 System.out.println("Error: " + e.getMessage());
	        }
	    }
	
}
