import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {


    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        boolean a1 = set1.add(3); // true
        boolean a2 = set1.add(2); // true
        boolean a3 = set1.add(1); // false
        boolean a4 = set1.add(1); // true
        boolean a5 = set1.add(0); // true
        for (Integer integer : set1)
            System.out.print(integer + ",");




        Set<Integer> set2 = new TreeSet<>();
        System.out.println("");
         boolean b1 = set2.add(30); // true
         boolean b2 = set2.add(20); // true
         boolean b3 = set2.add(10); // false
         boolean b4 = set2.add(10); // true
         boolean b5 = set2.add(00); // true
         for (Integer integer: set2)
             System.out.print(integer + ",");
        System.out.println("");

        System.out.println(((TreeSet<Integer>) set2).lower(19)); // bozorgtarin addi ki az E kamtar bashe
        System.out.println(((TreeSet<Integer>) set2).floor(20)); // bozorgtarin add ke kuchiktar mosavi E bashe
        System.out.println(((TreeSet<Integer>) set2).ceiling(20)); // kuchiktarin add ke bozorgtar mosavi E bashe
        System.out.println(((TreeSet<Integer>) set2).higher(20)); // kuchiktarin add ke bozorgtar az E bashe



    }

}
