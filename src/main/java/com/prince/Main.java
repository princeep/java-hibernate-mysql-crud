package com.prince;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Create Student Object
        Student s = new Student();
        s.setId(1);
        s.setName("Prince Kumar");
        s.setRoll(10);
        s.setMarks(80);

        // Hibernate Configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Student.class);

        // Build SessionFactory
        SessionFactory factory = config.buildSessionFactory();

        // Open Session
        Session session = factory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Save Object
        session.persist(s);

        // Commit Transaction
        transaction.commit();

        // Close Resources
        session.close();
        factory.close();

        System.out.println("Data inserted successfully!");
    }
}