public class Person implements Comparable {

int age ;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;
        return this.age - other.age;
    }

    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        System.out.println(person1.compareTo(person2));

    }
}