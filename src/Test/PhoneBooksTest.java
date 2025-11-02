import PhonebookExceptions.PhoneBookDoesNotExit;
import PhonebookExceptions.PhoneBookExits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBooksTest {
    private PhoneBooks phoneBooks;

    @BeforeEach
    void setUp() {
        phoneBooks = new PhoneBooks();
    }
    @Test
    @DisplayName("test that my phonebooks is empty")
    public void isEmpty(){
        assertTrue(phoneBooks.isEmpty());
    }

    @Test
    @DisplayName("test that i can add a phonebook")
    public void addPhoneBook_toMyPhonebooks(){
        phoneBooks.add("phonebook Name");
        assertFalse(phoneBooks.isEmpty());
    }

    @Test
    @DisplayName("test that when i add one phonebook and i delete it remain empty")
    public void addPhoneBook_DeletePhone(){
        phoneBooks.add("Phonebook Name");
        phoneBooks.delete("Phonebook Name");
        assertTrue(phoneBooks.isEmpty());
    }

    @Test
    @DisplayName("test that when i add two i can get the phonebook added by name")
    public void addTwogetLastOne(){
        phoneBooks.add("Family");
        phoneBooks.add("Work");
        assertEquals("Work", phoneBooks.findByName("Work").getName());
    }

    @Test
    @DisplayName("add to phonebook find the first added phonebook")
    public void addTwoGetFirst(){
        phoneBooks.add("Family");
        phoneBooks.add("Work");
        assertEquals("Family", phoneBooks.findByName("Family").getName());
    }

    @Test
    @DisplayName("test that when i delete phonebook and i tried finding")
    public void delete_ndFind(){
        phoneBooks.add("Family");
        phoneBooks.add("Work");
        phoneBooks.delete("Family");
        assertThrows(PhoneBookDoesNotExit.class,()-> phoneBooks.findByName("Family"));
    }

    @Test
    @DisplayName("test that when i tried creating phonebook of duplicate name")
    public void DuplicatePhoneBook(){
        phoneBooks.add("Family");
        assertThrows(PhoneBookExits.class,()->phoneBooks.add("Family"));
    }





}