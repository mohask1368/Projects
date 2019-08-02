import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){

        System.out.println( "1 : sendMessage");
        System.out.println( "2 : sentMessage");
        System.out.println( "3 : receivedMessage");
        System.out.println( "4 : addFriend");
        System.out.println( "5 : viewFriendList");
        System.out.println("");
        System.out.println("Please enter 1 - 5 numbers : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number){

            case 1: sendMessage(); break;
            case 2: sentMessage(); break;
            case 3: receivedMessage(); break;
            case 4: addFriend(); break;
            case 5: viewFriendList(); break;

            default:
                System.out.println("enter valid number");
        }
        showMenu();
    }

    public static void sendMessage(){
        System.out.println("sendMessage called");
        showMenu();

    }
    public static void sentMessage(){
        System.out.println("sentMessage called");
        showMenu();


    }
    public static void receivedMessage(){
        System.out.println("receivedMessage called");
        showMenu();


    }
    public static void addFriend(){
        System.out.println("addFriend called");
        showMenu();


    }
    public static void viewFriendList(){
        System.out.println("viewFriendList called");
        showMenu();


    }

}
