/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_phieu4;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ducth
 */
public class Customer implements Serializable{
    private String maKH;
    private String hoTen;
    private double doanhSo;    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) throws Exception{
        if(maKH.isBlank()|| "".equals(maKH.replaceAll("\\s", "")))
            throw new Exception("Mã khách hàng không được để trống!");
        else
            this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) throws Exception{
        if(hoTen.isBlank() || "".equals(hoTen.replaceAll("\\s", "")))
            throw new Exception("Tên khách hàng không được để trống!");
        else
            this.hoTen = hoTen;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) throws Exception {
        if(String.valueOf(doanhSo).isBlank())
            throw new Exception("Doanh số không được để trống!");
        else
            this.doanhSo = doanhSo;
    }
    
    public Customer() {
    }
    
    public Customer(String maKH, String hoTen, double doanhSo){
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.doanhSo = doanhSo;
    }
    
    public void nhap(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("Mã khách hàng: ");
            try {
                setMaKH(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Hãy nhập lại");
                flag = true;
            }
        }while(flag == true);
        
        flag = true;
        do{
            System.out.print("Tên khách hàng: ");
            try {
                setHoTen(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Hãy nhập lại");
                flag = true;
            }
        }while(flag == true);
        
        
        flag = true;
        do{
            System.out.print("Doanh số: ");
            try {
                setDoanhSo(scan.nextDouble());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Hãy nhập lại");
                flag = true;
            }
        }while(flag == true);
        
    }
    public void sua(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("Tên khách hàng: ");
            try {
                setHoTen(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Hãy nhập lại");
                flag = true;
            }
        }while(flag == true);
        
        
        flag = true;
        do{
            System.out.print("Doanh số: ");
            try {
                setDoanhSo(scan.nextDouble());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Hãy nhập lại");
                flag = true;
            }
        }while(flag == true);
        
    }
    
    @Override
    public String toString(){
        return (maKH+"  "+ hoTen+"  "+ doanhSo);
    }
    
}
