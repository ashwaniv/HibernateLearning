package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.sql.DataSource;

public class Datasource {
    private static SessionFactory sessionFactory = null;

    private Datasource() throws Exception {
        if (sessionFactory != null) {
            throw new Exception("Can not create session factory object.");
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            Configuration configuration = new Configuration().configure();
            org.hibernate.service.ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            // Creating Hibernate SessionFactory Instance
            sessionFactory = configuration.buildSessionFactory(serviceRegistryObj);
            return sessionFactory;

        }
        return sessionFactory;
    }

}
