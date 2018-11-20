package domain;


import config.Datasource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.util.Date;
import java.util.logging.Logger;

public class EventManager {

    public static void main(String[] args) throws Exception{
        try{
        Event  event=new Event();
        event.setDate(new Date());
        event.setTitle("click");

        SessionFactory sessionFactory= Datasource.getSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(event);
        transaction.commit();
        }catch (Exception e){
            throw e;
            }
    }



}
