package BaseLearning.Entities;

import jakarta.persistence.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author "231232010-Fadly Mubarok"
 */

@Entity
@Table(name = "barang")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Barang extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    
    public String KodeBarang, NamaBarang;
    public double HargaBarang;
    
    public Barang(){}
    public Barang(String _kode, String _nama, double _harga)
    {
        KodeBarang = _kode;
        NamaBarang = _nama;
        HargaBarang = _harga;
    }
    public Barang(int _id, String _kode, String _nama, double _harga)
    {
        Id = _id;
        KodeBarang = _kode;
        NamaBarang = _nama;
        HargaBarang = _harga;
    }
}
