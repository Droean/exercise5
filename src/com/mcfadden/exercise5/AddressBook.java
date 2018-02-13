package com.mcfadden.exercise5;
//Ean McFadden
//February 13, 2018
//Exercise 5
import java.util.Scanner;
import java.util.TreeMap;
class ContactInfo {
    String name;
    String email;
    public ContactInfo(String name, String email){
        this.name = name;
        this.email = email;

    }
}

public class AddressBook {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeMap<String, String> addressBook = new TreeMap<String, String>();
        System.out.println("Choose one of the following options: \n(0) Exit. \n(1) Add contact. \n(2) Lookup email for first name. \n(3) Display all contacts. " );
        String choice = input.nextLine();
        while (!choice.equals("0")){
            if (choice.equals("1")) {
                String contactName = inputContactName();
                String contactEmail = inputContactEmail();
                ContactInfo contact = new ContactInfo(contactName, contactEmail);
                addressBook.put(contact.name, contact.email);
            }
            else if(choice.equals("2")){
                emailLookup(addressBook);
            }
            else if(choice.equals("3")){
                for (String key: addressBook.keySet()) {
                    String email = addressBook.get(key);
                    System.out.println("Name: " + key + "\nContact: " + email);
                }
            }
            else{
                System.out.println("That is not a valid entry");
            }
            System.out.println("\nChoose one of the following options: \n(0) Exit. \n(1) Add contact. \n(2) Lookup email for first name. \n(3) Display all contacts. " );
            choice = input.nextLine();
        }
    }
    static String inputContactName(){
        Scanner contactInput = new Scanner(System.in);
        System.out.println("Enter the contact's full name");
        String contactName = contactInput.nextLine();
        return contactName;
    }
    static String inputContactEmail(){
        Scanner contactInput = new Scanner(System.in);
        System.out.println("Enter the contact's e-mail.");
        String contactEmail = contactInput.nextLine();
        return contactEmail;
    }
    static void emailLookup(TreeMap<String, String> addressBook){
        Scanner nameLookup = new Scanner(System.in);
        System.out.println("What is the name of the person who's email you want?");
        String lookedName = nameLookup.nextLine();
        String email = addressBook.get(lookedName);
        System.out.println("Their email is: " + email);
    }
}
