import PhonebookExceptions.PhoneBookDoesNotExit;
import PhonebookExceptions.PhoneBookExits;

import java.util.HashMap;

public class PhoneBooks {
    int size;
    private HashMap<String,PhoneBook> phoneBooks = new HashMap<>();
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String phonebookName) {
        checkExistingPhonebook(phonebookName);
        phoneBooks.put(phonebookName,new PhoneBook(phonebookName));
        size++;
    }

    public void delete(String phonebookName) {
        size--;
        checkPhonebooks(phonebookName);
        phoneBooks.remove(phonebookName);
    }

    public PhoneBook findByName(String name) {
        checkPhonebooks(name);
        return phoneBooks.get(name);
    }

    private void checkPhonebooks(String name){
        if(!phoneBooks.containsKey(name)) throw new PhoneBookDoesNotExit("Phone Book Does Not Exit");
    }
    private void checkExistingPhonebook(String name){
        if(phoneBooks.containsKey(name)) throw new PhoneBookExits("PhoneBook With " + name + " Exits");

    }
}
