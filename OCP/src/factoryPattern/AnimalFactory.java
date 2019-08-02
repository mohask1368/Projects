package factoryPattern;

import java.util.Scanner;

public class AnimalFactory {

    public static void main(String[] args) {
        inputtedFromUser();
    }


    public static void inputtedFromUser(){
        System.out.println("enter animal name :");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        make(next);
        inputtedFromUser();
    }


    public static Animal make(String input){

        Animal animal = null;
        switch (input){

            case "dog": animal = new Dog();break;
            case "cat": animal = new Cat();break;
            case "fish": animal = new Fish();break;

        }
    return animal;


    }


}
