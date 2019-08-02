package factoryPattern;

public class Fish extends Animal{

    @Override
    public void sound(){
        System.out.println("bubble bubble");
    }

    public Fish() {
        sound();
    }
}
