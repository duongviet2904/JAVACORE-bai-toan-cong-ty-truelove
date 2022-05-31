/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_phieu4;

import java.io.Serializable;


/**
 *
 * @author duongv
 */
public class Product implements Serializable{
    private String tenSP;

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Product() {
    }

    public Product(String tenSP) {
        this.tenSP = tenSP;
    }
    
    public void tieuDe(){
        System.out.printf("\n%-15s", "Tên SP");
    }
    
    public void hienThi(){
        System.out.printf("\n%-15s", tenSP);
    }
}
