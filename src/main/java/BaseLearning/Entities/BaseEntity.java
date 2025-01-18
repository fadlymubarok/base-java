/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseLearning.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author "231232010-Fadly Mubarok"
 */

@MappedSuperclass
public class BaseEntity {
    public String CreatedBy, UpdatedBy;
    public LocalDate CreatedDate, UpdatedDate;
}
