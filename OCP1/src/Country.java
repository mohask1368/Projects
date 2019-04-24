/**
 * @author Mohammad Askari
 */
public class Country {

    private String name ;
    private int population ;



    public Country() {
        name = "Iran";
    }

    public Country(int number) {
    this();
    population = number;

    }

    public Country(String n, int number) {
        this(number);
        name = n ;
    }

    public static void main(String[] args) {
        Country country1 = new Country();
        Country country2 = new Country(2);
        Country country3 = new Country("japon",3);
        System.out.println(country1.name);

    }
}
