import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;
    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    @DisplayName("test that my phonebook is empty")
    public void testEmptyPhoneBook(){
        assertTrue(phoneBook.isEmpty());
    }


    @Test
    @DisplayName("test that when i add a contact to my phonebook my phonebook is not empty")
    public void addContactToPhonBook(){
        phoneBook.addContact("John","08121844363");
        assertFalse(phoneBook.isEmpty());
    }



}