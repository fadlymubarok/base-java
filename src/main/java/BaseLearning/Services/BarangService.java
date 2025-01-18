/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Services;

import BaseLearning.Daos.BarangDao;
import BaseLearning.Entities.Barang;
import BaseLearning.Interfaces.IBarangDao;
import BaseLearning.Interfaces.IBarangService;
import java.util.List;
/**
 *
 * @author "231232010-Fadly Mubarok"
 */
 public class BarangService extends BaseService implements IBarangService {
    IBarangDao dao;
    public BarangService()
    {
        dao = new BarangDao(Barang.class);
        Errors.clear();
    }
    @Override
    public List<Barang> GetListBarang() {
        return dao.GetList();
    }
    
    public Barang GetDataByKode(String kode) {
        return dao.GetBarangByKode(kode);
    }

    @Override
    public Barang InsertData(Barang barang) {
        if(!ValidateData(barang)) return null;
        
        Barang oldBarang = dao.GetBarangByKode(barang.KodeBarang);
        if(oldBarang != null)
        {
            AddError(String.format("Data Barang dengan kode %s sudah ada didatabase", barang.KodeBarang));
            return null;
        }
        AssignCreator(barang);
        return dao.Insert(barang);
    }

    @Override
    public Barang UpdateData(String kodeBarangLama, Barang barangUpdate) {
        if(kodeBarangLama.isBlank())
        {
            AddError("Kode barang kosong, data tidak dapat diproses");
            return null;
        }
        if(!ValidateData(barangUpdate)) return null;
        if(!kodeBarangLama.toLowerCase().equals(barangUpdate.KodeBarang.toLowerCase()))
        {
            Barang existingBarang = dao.GetBarangByKode(barangUpdate.KodeBarang);
            if(existingBarang != null)
            {
                AddError(String.format("Data Barang dengan kode %s sudah ada didatabase", barangUpdate.KodeBarang));
                return null;
            }
        }
        
        AssignUpdater(barangUpdate);
        dao.Update(barangUpdate);
        return barangUpdate;
    }

    @Override
    public boolean DeleteData(int Id) 
    {
        return dao.Delete(Id);
    }
    
    
    private boolean ValidateData(Barang barang)
    {
        Errors.clear();
        if(barang.KodeBarang.isBlank())
            AddError("Kode barang tidak boleh kosong");
        if(barang.NamaBarang.isBlank())
            AddError("Nama Barang tidak boleh kosong");
        if(barang.HargaBarang <= 0)
            AddError("Harga barang harus lebih dari 0");
        
        return Errors.isEmpty();
    }
}
