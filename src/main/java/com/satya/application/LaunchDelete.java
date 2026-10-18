package com.satya.application;

import com.satya.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;


        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Student student = session.get(Student.class,1);
            student.setSid(1);
            student.setSname("Rahulatra");
            student.setScity("Mumbai");

            session.remove(student);
            flag = true;
        }
        catch (HibernateException e) {
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

