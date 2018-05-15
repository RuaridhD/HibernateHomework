package db;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBAuthor {

    private static Session session;
    private static Transaction transaction;

    public static void save(models.Author author) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (org.hibernate.HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static models.Author find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        models.Author result = null;
        try {
            String hql = "from Author where id = :id";
            org.hibernate.Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (models.Author) query.uniqueResult();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<models.Author> getAuthors() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<models.Author> results = null;
        try {
            String hql = "from Author";
            results = session.createQuery(hql).list();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void update(models.Author author) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
