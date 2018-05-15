package db;

import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBBook {

    private static Session session;
    private static Transaction transaction;

    public static void save(models.Book book) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (org.hibernate.HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static models.Book find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        models.Book result = null;
        try {
            String hql = "from Book where id = :id";
            org.hibernate.Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (models.Book) query.uniqueResult();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<Book> getBooks() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<models.Book> results = null;
        try {
            String hql = "from Book";
            results = session.createQuery(hql).list();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void update(models.Book book) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
