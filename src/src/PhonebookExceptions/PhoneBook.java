package PhonebookExceptions;

public class PhoneBook extends RuntimeException {
    public PhoneBook(String message) {
        super(message);
    }
}
