import PhonebookExceptions.PhoneBookExceptions;

import javax.swing.*;

public class MainApplication {
    static void main() {
        gotoMainMenu();
    }
    private static PhoneBooks phoneBooks = new PhoneBooks();

    public static String input(String prompt){
        return JOptionPane.showInputDialog(prompt).toLowerCase();
    }
    public static void print(String prompt){
        System.out.println(prompt);
    }

    public static String displayMenu(){
        return """
                Choose From the following Options
                1. Create a PhoneBook
                2. Delete a PhoneBook
                3. Search For PhoneBook
                4. Login to PhoneBook
                0. To Exit
                """;
    }

    public static void gotoMainMenu(){
        String prompt = input(displayMenu());
        switch (prompt){
            case "1" -> createPhoneBook();
            case "2" -> deletePhoneBook();
            case "3" -> searchForPhoneBook();
            case "4" -> loginToPhoneBook();
            case "0" -> System.exit(0);
            default -> gotoMainMenu();
        }

    }


    public static void createPhoneBook(){
        String name = input("Enter PhoneBook Name");
        try{
            phoneBooks.add(name);
            print("PhoneBook Created Successfully");
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoMainMenu();

        }
    }

    public static void deletePhoneBook(){
        String name = input("Enter PhoneBook Name");
        try{
            phoneBooks.delete(name);
            print("PhoneBook Deleted Successfully");
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoMainMenu();

        }

    }


    private static void loginToPhoneBook() {
        String name = input("Enter PhoneBook Name TO login");
        try{
            PhoneBook currentPhoneBook = phoneBooks.findByName(name);
            gotoSubMenu(currentPhoneBook);
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoMainMenu();
        }
    }

    private static void searchForPhoneBook() {
        String name = input("Enter PhoneBook Name");
        try{
            print(phoneBooks.findByName(name).toString());
        }catch (PhoneBookExceptions e) {
            print(e.getMessage());
        }finally {
            gotoMainMenu();
        }

    }

    private static String displaySubMenu(){
        return """
                Choose From the following Options
                1. Add a contact
                2. Delete a Contact 
                3. Search By Name
                4. Search By Number
                5. Edit a Contact
                6. Display Available Contact
                00 Go Back To SubMenu
                0. To Exit
                 """;
    }

    private static void gotoSubMenu(PhoneBook currentPhoneBook){
        String prompt = input(displaySubMenu());
        switch(prompt){
            case "1" -> addAContact(currentPhoneBook);
            case "2" -> deleteAContact(currentPhoneBook);
            case "3" -> searchByName(currentPhoneBook);
            case "4" -> searchByContactNo(currentPhoneBook);
            case "5" -> editContact(currentPhoneBook);
            case "6" -> displayAvailableContact(currentPhoneBook);
            case "00" -> gotoMainMenu();
            case "0" -> System.exit(0);
            default -> gotoSubMenu(currentPhoneBook);
        }

    }

    private static void editContact(PhoneBook currentPhoneBook) {
        String name = input("Enter Contact Name to edit");
        String newName = input("Enter Contact New Name");
        String newContact = input("Enter New Contact Number");
        try {
            getCurentPhoneBook(currentPhoneBook).editContact(name,newName,newContact);
            print("Contact Edited Successfully");
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        } finally {
            gotoSubMenu(currentPhoneBook);
        }
    }

    private static void displayAvailableContact(PhoneBook currentPhoneBook) {
            print(getCurentPhoneBook(currentPhoneBook).toString());
    }

    private static void searchByContactNo(PhoneBook currentPhoneBook) {
        String contactNo = input("Enter Contact Number");
        try {
            print(getCurentPhoneBook(currentPhoneBook).searchByContactNo(contactNo).toString());
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoSubMenu(currentPhoneBook);
        }
    }

    private static void searchByName(PhoneBook currentPhoneBook) {
        String name = input("Enter Contact Name");
        try{
            print(getCurentPhoneBook(currentPhoneBook).searchByName(name).toString());
        }catch (PhoneBookExceptions e){
            print(e.getMessage());

        }finally {
            gotoSubMenu(currentPhoneBook);
        }
    }

    private static void deleteAContact(PhoneBook currentPhoneBook) {
        String name = input("Enter Name of Contact");
        try {
            getCurentPhoneBook(currentPhoneBook).deleteContact(name);
            print("Deleted Successfully");
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoSubMenu(currentPhoneBook);
        }
    }

    private static void addAContact(PhoneBook currentPhoneBook) {
        String name = input("Enter Contact Name");
        String contact = input("Enter Contact Number");
        try{
           getCurentPhoneBook(currentPhoneBook).addContact(name,contact);
            print("Contact Successfully Created");
        }catch (PhoneBookExceptions e){
            print(e.getMessage());
        }finally {
            gotoSubMenu(currentPhoneBook);
        }
    }

    private static PhoneBook getCurentPhoneBook(PhoneBook currentPhoneBook){
        return phoneBooks.findByName(currentPhoneBook.getName());
    }

}
