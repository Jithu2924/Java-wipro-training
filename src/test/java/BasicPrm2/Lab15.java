package BasicPrm2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Lab15 {
    String firstName;
    String lastName;
    public enum Gender { M, F }
    Gender gender;
    String phone;
    LocalDate dob;

    public Lab15() {
    }

    public Lab15(String firstName, String lastName, Gender gender, String phone, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
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

    public LocalDate getDob() {
        return dob;
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

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int calculateAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Lab15 person = new Lab15();

        // Input details
        System.out.print("Enter First Name: ");
        person.setFirstName(sc.next());

        System.out.print("Enter Last Name: ");
        person.setLastName(sc.next());

        System.out.print("Enter Gender (M/F): ");
        person.setGender(Gender.valueOf(sc.next().toUpperCase()));

        System.out.print("Enter Phone Number: ");
        person.setPhone(sc.next());

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        person.setDob(LocalDate.parse(sc.next()));

        System.out.println("Full Name : " + person.getFullName());
        System.out.println("Gender : " + person.getGender());
        System.out.println("Phone No : " + person.getPhone());
        System.out.println("DOB : " + person.getDob());
        int age = person.calculateAge();
        System.out.println("Age : " + age);

    }
}

