package com.satya.application;

import com.satya.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApplication {

    public static void main(String[] args) {

        Configuration config = new Configuration();

        config.configure();

        //Create sessionFactory factory object
        SessionFactory sessionFactory = config.buildSessionFactory();

        //Get Session Object
        Session session = sessionFactory.openSession();

        //Begin Transaction
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setSid(1);
        student.setSname("Rohit");
        student.setScity("Pune");

        //perform operation
        session.persist(student);

        //perform transaction operation
        transaction.commit();

        //close session
        session.close();

    }
}
