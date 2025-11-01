public class PhoneBook {
    private int size ;

    public boolean isEmpty() {
        return size == 0;
    }

    public void addContact(String name, String contact) {
        size++;
    }
}
