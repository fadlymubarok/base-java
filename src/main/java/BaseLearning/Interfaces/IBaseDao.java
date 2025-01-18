/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BaseLearning.Interfaces;

import BaseLearning.Entities.Barang;
import java.util.List;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public interface IBaseDao<T> {
    T Insert(T data);
    List<T> GetList();
    T GetData(int id);
    void Update(T data);
    boolean Delete(int id);
}
