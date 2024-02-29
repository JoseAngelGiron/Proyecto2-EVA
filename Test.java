import Model.User;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("Jose", "Mars", "Jangelgiron@gmail.com","QWER345qwe");

        User user2 = new User("pepe", "Lars", "Jangelgiron5@gmail.com","QWER345qwe");

        System.out.println(user1.equals(user2));
    }

}
