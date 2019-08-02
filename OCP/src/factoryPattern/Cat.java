package factoryPattern;

public class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("miew miew");
    }

    public Cat() {
        sound();
    }
}
