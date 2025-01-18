/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BaseLearning.Interfaces;

import BaseLearning.Entities.BaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public interface IBaseService {
    void AssignCreator(BaseEntity entity);
    void AssignUpdater(BaseEntity entity);
    List<String> Errors = new ArrayList<String>();
    List<String> GetErrors();
    void AddError(String message);
    
    boolean ServiceState = !Errors.isEmpty();
}
