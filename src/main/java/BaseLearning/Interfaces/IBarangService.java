/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BaseLearning.Interfaces;

import BaseLearning.Entities.Barang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public interface IBarangService extends IBaseService{
    List<Barang> GetListBarang();
    Barang InsertData(Barang barang);
    Barang UpdateData(String kodeBarangLama, Barang barangUpdate);
    boolean DeleteData(int Id);
}
