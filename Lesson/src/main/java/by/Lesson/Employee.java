package by.Lesson;

public class Employee {

    private final String fullname;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final double salary;
    private final int age;

    public Employee(String fullname, String position,
                    String email, String phoneNumber,
                    double salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
       public void printInfo() {
            System.out.println("ФИО: "+fullname );
            System.out.println("должность: "+position);
            System.out.println("email: "+email);
            System.out.println("телефон: "+phoneNumber);
            System.out.println("зарплата: "+salary);
            System.out.println("возраст: "+age);
            System.out.println();
        }
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "официант", "ivanov@mail.ru",
                "80294567584", 300, 18);
        employees[1] = new Employee("Петров Петр Петрович", "повар", "petrov@mail.ru",
                "80294567825",  420, 25);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "директор", "sidorov@mail.ru",
                "80291354586", 700, 37);
        employees[3] = new Employee("Сергеев Сергей Сергеевич", "бармен", "sergeev@mail.ru",
                "80293546719", 205, 45);
        employees[4] = new Employee("Козлов Павел Васильевич", "менеджер", "kozlov@mail.ru",
                "80293657586", 500, 58);

        for (Employee employee : employees) {
            employee.printInfo();
        }
    }
}


