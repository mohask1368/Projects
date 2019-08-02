package factoryPattern;

public class Dog extends Animal {
    @Override
    public void sound() {
        int i = 2;
        System.out.println("Hop Hop");
    }

    public Dog() {
        sound();
    }
}
