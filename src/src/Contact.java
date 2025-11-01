import PhonebookExceptions.ContactNumber;
import PhonebookExceptions.EmptyArgs;

public class Contact {
    private String name;
    private String contact;

    public Contact(String name, String contact) {
        validateInput(name,contact);
        validateNumber(contact);
        this.name = name;
        this.contact = contact;
    }

    private void validateInput(String name,String contact){
        if(name.isBlank() || contact.isBlank()) throw new EmptyArgs("Cannot Create Contact With Empty Args");
    }

    private void validateNumber(String contact){
        boolean isLetter = false;
        for(int count = 0; count < contact.length();count++) {
            if(Character.isLetter(contact.charAt(count))) isLetter = true;
        }
        if(isLetter) throw new ContactNumber("Contact Number Cannot be Letter");
    }


}
