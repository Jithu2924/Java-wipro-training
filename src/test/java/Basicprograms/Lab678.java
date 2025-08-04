package Basicprograms;

import java.awt.GraphicsEnvironment;
import java.util.Scanner;

public class Lab678 {
    String firstName;
    String lastName;
    public enum Gender {M, F}
    Gender gender;
    String phone;  
    public Lab678() {
    }


    public Lab678(String firstName, String lastName, Gender gender, String phone) {
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

    
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Main method
    public static void main(String[] args) {
        Lab678 person = new Lab678();

        person.setFirstName("Sreejith");
        person.setLastName("Mohan");
        person.setGender(Gender.M);

        Scanner sc = new Scanner(System.in);
        System.out.print("Add the phone number: ");
        person.setPhone(sc.next());  

        System.out.println("\n----- Person Details -----");
        System.out.println("First Name : " + person.getFirstName());
        System.out.println("Last Name  : " + person.getLastName());
        System.out.println("Gender     : " + person.getGender());
        System.out.println("Phone No   : " + person.getPhone());
    }
}

