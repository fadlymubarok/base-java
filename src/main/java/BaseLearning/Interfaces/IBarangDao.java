/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BaseLearning.Interfaces;

import BaseLearning.Entities.Barang;
/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public interface IBarangDao extends IBaseDao<Barang>{
    
    Barang GetBarangByKode(String kode);
}
