
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = scanner.next();
        System.out.println("Enter Last Name : ");
        String lastName = scanner.next();

        System.out.println("Your full Name Is : " + name + "" + lastName);
        System.out.println("Save Information In File ?  (y/n) " );
        String s = scanner.next();
        switch (s){

            case ("y") : saveToFile(name,lastName); break;
            case ("n") : System.out.println("Goodbye"); break;
            default:     System.out.println("Enter Valid Answer");

        }


    }
    public static void saveToFile(String fn,String ln) {


            try {
                PrintWriter printWriter = new PrintWriter("c:\\users\\MAM\\Desktop\\test.txt");
                printWriter.write(fn);
                printWriter.println();
                printWriter.write(ln);
                printWriter.flush();
                System.out.println("Saved Successful");
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
