package com.satya.application;

import com.satya.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {

    public static void main(String[] args) {

        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        config = new Configuration();

        config.configure();

        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();

        Student student =new Student();
        student.setSid(2);
        student.setScity("Bengaluru");
        student.setSname("Rahul");

        Boolean flag=false;
        try {
            transaction = session.beginTransaction();
            session.persist(student);
             flag = true;
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if(flag == true){
                transaction.commit();
            }
            else{
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }
    }
}
