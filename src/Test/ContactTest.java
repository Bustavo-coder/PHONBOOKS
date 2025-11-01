import PhonebookExceptions.ContactNumber;
import PhonebookExceptions.EmptyArgs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
   @Test
   @DisplayName("test that i cannot create a contact with empty String")
    public void testEmptyArgs(){
       assertThrows(EmptyArgs.class,()->new Contact("  ",""));
   }
   @Test
    @DisplayName("test that i cannot create my contact with a contact no that not a number")
    public void test_CreateWithLetterHasContactNo(){
       assertThrows(ContactNumber.class,()->new Contact("Ade","Not A Number"));
   }

   @Test
    @DisplayName("test that when i create an contact with correct it does not throw error")
    public void noErrorThrown(){
       Contact contact = new Contact("Name","0812184436");
   }

}