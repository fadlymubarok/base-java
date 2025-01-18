/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Services;

import BaseLearning.Entities.BaseEntity;
import BaseLearning.Interfaces.IBaseService;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author "231232010-Fadly Mubarok"
 */
public class BaseService implements IBaseService{
    
    public void AssignCreator(BaseEntity entity) {
        entity.CreatedDate = LocalDate.now();
    }

    public void AssignUpdater(BaseEntity entity) {
        entity.UpdatedDate = LocalDate.now();
    }

    public List<String> GetErrors() {
        return Errors;
    }
    
    public void AddError(String message) {
        if(!Errors.contains(message))
            Errors.add(message);
    }
}
