package org.prince;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {


        Student s = new Student();
        s.getId(1);
        s.getName("Prince kumar");
        s.getRoll(10);
        s.getMarks(80);

        SessionFactory factory = null;
        Session Session  = new Session();
        Session.save(s);
    }

}