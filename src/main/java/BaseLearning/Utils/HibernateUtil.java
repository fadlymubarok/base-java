/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
            try{
                registry = new StandardServiceRegistryBuilder().configure().build();
                
                MetadataSources sources = new MetadataSources(registry);
                
                Metadata meta = sources.getMetadataBuilder().build();
                sessionFactory = meta.getSessionFactoryBuilder().build();
                
            }catch (Exception e) {
                System.err.println("Failed to getSessionFactory. Error: " + e.getMessage());
                shutdown();
            }
        }
        return sessionFactory;
    }
    
    public static void shutdown()
    {
        if(registry != null)
            StandardServiceRegistryBuilder.destroy(registry);
    }
}
