package builderPattern;

public class Test {

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setAge(10);
        personBuilder.setName("asb");
        Person person = personBuilder.build();
        System.out.println(person);
    }
}
