package builderPattern;

public class PersonBuilder {

    private int age;
    private String name ;


    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;

    }

    public Person build(){

    return new Person(age,name);

    }
}
