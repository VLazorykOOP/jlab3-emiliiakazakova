import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    private String position;

    public Employee(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Position: " + position);
    }
}

class Worker extends Person {
    private int experience;

    public Worker(String name, int age, int experience) {
        super(name, age);
        this.experience = experience;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Experience: " + experience + " years");
    }
}

class Engineer extends Worker {
    private String specialization;

    public Engineer(String name, int age, int experience, String specialization) {
        super(name, age, experience);
        this.specialization = specialization;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Specialization: " + specialization);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person[] people = new Person[4];

        for (int i = 0; i < people.length; i++) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            if (i == 1) {
                System.out.println("Enter position: ");
                String position = scanner.nextLine();
                people[i] = new Employee(name, age, position);
            } else if (i == 2) {
                System.out.println("Enter experience (in years): ");
                int experience = scanner.nextInt();
                scanner.nextLine();
                people[i] = new Worker(name, age, experience);
            } else if (i == 3) {
                System.out.println("Enter experience (in years): ");
                int experience = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter specialization: ");
                String specialization = scanner.nextLine();
                people[i] = new Engineer(name, age, experience, specialization);
            } else {
                people[i] = new Person(name, age);
            }
        }

        for (Person person : people) {
            person.show();
            System.out.println();
        }

        scanner.close();
    }
}
