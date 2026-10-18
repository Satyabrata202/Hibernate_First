package com.satya.application;

import com.satya.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchRetrieve {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;



        try {
            session = sessionFactory.openSession();

            Student student = session.find(Student.class,2);

            System.out.println(student);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            session.close();
            sessionFactory.close();
        }
    }
}
