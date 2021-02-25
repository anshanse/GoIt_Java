import java.util.Scanner;

public class AskPerson {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = in.nextLine();
        System.out.print("Input your city: ");
        String city = in.nextLine();
        System.out.print("Input age: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.print("What is your hobby: ");
        String hobby = in.nextLine();
        System.out.print("Input variant (1/2/3): ");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println("Name: " + name);
                System.out.println("City: " + city);
                System.out.println("Age :" + age);
                System.out.println("Hobby: " + hobby);
                break;
            case 2:
                System.out.printf("Человек по имени %s живет в городе %s.", name, city);
                System.out.println();
                System.out.printf("Этому человеку %d лет и любит он заниматься %s.", age, hobby);
                break;
            case 3:
                System.out.println(name + " - Name");
                System.out.println(city + " - City");
                System.out.println(age + " - Age");
                System.out.println(hobby + " - Hobby");
                break;
        }
        in.close();
    }
}
