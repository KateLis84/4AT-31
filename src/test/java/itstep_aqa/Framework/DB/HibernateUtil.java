package itstep_aqa.Framework.DB;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = initSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            configuration.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
