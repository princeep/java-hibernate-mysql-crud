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

//        s.setId(3);
//        s.setName("ramu Kumar");
//        s.setRoll(100);
//        s.setMarks(800);

        // Hibernate Configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Student.class);

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        Student s1 = session.get(Student.class, 1);
        Student s2 = session.load(Student.class, 1);

        Transaction transaction = session.beginTransaction();

        session.persist(s);

        transaction.commit();

        session.close();
        factory.close();

        System.out.println("Data inserted successfully!");
    }
}