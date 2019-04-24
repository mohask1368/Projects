import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {


        Person person = new Person(1,"sasan","moj");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.save(person);
        transaction.commit();
        sessionFactory.close();

        Person person1 = new Person();

    }
}
