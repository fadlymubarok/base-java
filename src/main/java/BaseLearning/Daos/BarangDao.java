/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Daos;

import BaseLearning.Entities.Barang;
import BaseLearning.Interfaces.IBarangDao;
import BaseLearning.Utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public class BarangDao extends BaseDao<Barang> implements IBarangDao{

    public BarangDao(Class<Barang> _type) {
        super(_type);
    }

    public Barang GetBarangByKode(String kode)
    {
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            String sql = "SELECT * FROM barang where KodeBarang = :kode";
            Barang data = session.createNativeQuery(sql, Barang.class)
                        .setParameter("kode", kode)
                        .getSingleResultOrNull();
            return data;
        }
    }
}
