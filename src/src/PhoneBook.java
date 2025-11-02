import PhonebookExceptions.ContactNotFound;

import java.util.HashMap;

public class PhoneBook {
    private int size ;
    private HashMap<String,Contact> phoneBooks = new HashMap<>();
    private String name;

    public PhoneBook(String name){
        this.name = name;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addContact(String name, String contactNo) {
        validateExistingContact(name);
        phoneBooks.put(name,new Contact(name,contactNo));
        size++;
    }

    public void deleteContact(String name) {
        validateAvailableContact(name);
        phoneBooks.remove(name);
        size--;
    }

    public Contact searchByName(String name) {
        validateAvailableContact(name);
        return phoneBooks.get(name);
    }


    public Contact searchByContactNo(String number) {
        for(Contact contact:phoneBooks.values()){
            if(contact.getContact().equalsIgnoreCase(number)) return contact;
        }
        throw new ContactNotFound("Contact Not Found");
    }

    public void editContact(String oldContactName, String newContactName, String newContactNo) {
        validateAvailableContact(oldContactName);
        deleteContact(oldContactName);
        addContact(newContactName,newContactNo);
    }


    private void validateAvailableContact(String name){
        if(!phoneBooks.containsKey(name)) throw new ContactNotFound("Contact Not Available");
    }

    private void validateExistingContact(String name){
        if(phoneBooks.containsKey(name)) throw new ContactExists("Contact Name Exits");
    }

}
