import PhonebookExceptions.ContactExists;
import PhonebookExceptions.ContactNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;
    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook("Family");
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
    @Test
    @DisplayName("test that when i delete a contact from my phonebook is now empty")
    public void test_DeleteContact(){
        phoneBook.addContact("John","08121844363");
        phoneBook.deleteContact("John");
        assertTrue(phoneBook.isEmpty());
    }

    @Test
    @DisplayName("test that when i add to contact and i delete one my phonebook is not empty")
    public void addTwoDeleteOne(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        phoneBook.deleteContact("John");
        assertFalse(phoneBook.isEmpty());
    }

    @Test
    @DisplayName("test that when i add i can Search For My contact")
    public void test_Search(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        assertEquals("Chris", phoneBook.searchByName("Chris").getName());
    }

    @Test
    @DisplayName("test that when i add two contact i can get the first Contact Name")
    public void test_AddTwoReturnFirst(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        assertEquals("John", phoneBook.searchByName("John").getName());
    }

    @Test
    @DisplayName("test that i when i search for a contact not in my phoneBook")
    public void searchForContact(){
        assertThrows(ContactNotFound.class,()->phoneBook.searchByName("Ronaldo"));
    }

    @Test
    @DisplayName("when i add a contact and i delete it does not remian in my phonebook")
    public void delete_And_Search(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        phoneBook.deleteContact("Chris");
        assertThrows(ContactNotFound.class, ()-> phoneBook.searchByName("Chris"));
    }

    @Test
    @DisplayName("test that when i tried deleting a contact not Available")
    public void delete_NonAvailableContact(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        assertThrows(ContactNotFound.class, ()-> phoneBook.searchByName("Trump"));
    }
    @Test
    @DisplayName("test that i can search by ContactNo")
    public void searchByContactNo(){
        phoneBook.addContact("John","08121844363");
        phoneBook.addContact("Chris","0705052162");
        assertEquals("08121844363", phoneBook.searchByContactNo("08121844363").getContact());
    }

    @Test
    @DisplayName("test when i search my for a contact no not in my phonebook")
    public void searchByContactNoForInvalid(){
        assertThrows(ContactNotFound.class,()->phoneBook.searchByContactNo("Invalid Contact Number"));
    }

    @Test
    @DisplayName("test that when i tried to add to duplicate contact Name")
    public void duplicateName(){
        phoneBook.addContact("Chris","0705052162");
        assertThrows(ContactExists.class,()->phoneBook.addContact("Chris","0705052162"));
    }

    @Test
    @DisplayName("test that i can Edit a contact that has been added")
    public void editContact(){
        phoneBook.addContact("Chris","0705052162");
        phoneBook.editContact("Chris","Ade","08104260657");
        assertEquals("08104260657",phoneBook.searchByName("Ade").getContact());
    }

    @Test
    @DisplayName("test that when i tried editing a contact not existing ")
    public void editInvalidContact(){
        phoneBook.addContact("Chris","0705052162");
        phoneBook.editContact("Chris","Ade","08104260657");
        assertEquals("08104260657",phoneBook.searchByName("Ade").getContact());
        assertThrows(ContactNotFound.class, ()-> phoneBook.editContact("Farid","CHI","09027100266"));
    }




}