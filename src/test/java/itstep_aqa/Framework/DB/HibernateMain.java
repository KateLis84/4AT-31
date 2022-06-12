package itstep_aqa.Framework.DB;
import org.hibernate.Criteria;
import org.hibernate.Session;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HibernateMain {
    public static Object[][] main() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = new User();
        user.setName("NEW_USER");
        user.setLastname("LAST_NAME");
        user.setAge(99);
        user.setEmail("EMAIL");

        //CRUD

        //Create
        session.beginTransaction();
        Serializable id = session.save(user);
        session.getTransaction().commit();
        System.out.println("User " + user + " saved with id" + id);


        //READ
        session.beginTransaction();
        List<User> userList1 = session.createQuery("SELECT a FROM User a WHERE idUser = 1", User.class).getResultList();
        List<User> userList2 = session.createQuery("SELECT a FROM User a WHERE idUser = 2", User.class).getResultList();
        session.getTransaction().commit();

        session.close();
        Object[][] a = new Object[][]{
                {userList1.toString()},
                {userList2.toString()}
        };

        return a;
    }
}
