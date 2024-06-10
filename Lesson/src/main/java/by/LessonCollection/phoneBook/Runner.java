package by.LessonCollection.phoneBook;

public class Runner {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "8029555-55-55");
        phoneBook.add("Петров", "8029222-22-22");
        phoneBook.add("Сидоров", "8029888-88-88");
        phoneBook.add("Петров", "8029777-88-88");
        phoneBook.add("Сидоров", "8029555-88-88");
        phoneBook.add("Смирнов", "8029999-88-88");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println(phoneBook.get("Смирнов"));
    }
}


