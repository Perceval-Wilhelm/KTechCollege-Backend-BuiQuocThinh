package vn.edu.likelion.hibernate;

import org.hibernate.Session;

public class testConnection {
    public static void main(String[] args) {
        
        //Get Session
        Session HibernateUtil = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
