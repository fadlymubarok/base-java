/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Daos;

import BaseLearning.Interfaces.IBaseDao;
import BaseLearning.Utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public class BaseDao<T> implements IBaseDao<T> {
    private final Class<T> type;
    
    public BaseDao(Class<T> _type)
    {
        this.type = _type;
    }
    
    public T Insert(T data) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            session.persist(data);
            transaction.commit();
        } catch(Exception e)
        {
            System.err.println("Insert Error : " + e.getMessage());
            if(transaction != null) transaction.rollback();
        }
        return data;
    }

    public List<T> GetList() {
        List<T> datas = new ArrayList<T>();
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            String table = type.getSimpleName();
            datas = session.createQuery("FROM " + table, type).list();
        }
        return datas;
    }

    public T GetData(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            return session.get(type, id);
        }
    }

    public void Update(T data) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            session.merge(data);
            transaction.commit();
        }catch(Exception e)
        {
            if(transaction != null) transaction.rollback();
            System.err.println("Failed to update. Error: " + e.getMessage());
        }
    }

    public boolean Delete(int id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            String sql = "DELETE FROM barang where id = :id";
            int rowEffected = session.createNativeQuery(sql, type)
                    .setParameter("id", id)
                    .executeUpdate();
            if(rowEffected > 0)
            {
                transaction.commit();
                return true;
            }
        }catch(Exception e)
        {
            if(transaction != null) transaction.rollback();
            System.err.println("Failed to update. Error: " + e.getMessage());
        }
        return false;
    }
    
}
