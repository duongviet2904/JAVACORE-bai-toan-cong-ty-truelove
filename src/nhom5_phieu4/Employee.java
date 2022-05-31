/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_phieu4;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author duongv
 */
public class Employee implements Serializable{
    private String maNV;
    private String tenNV;
    
    private int dangKiDL; // 0: khong dki;  1: co dki
    private String ngayDKi;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) throws Exception{
        if(maNV.isEmpty() || "".equals(maNV.replaceAll("\\s", "")))
            throw new Exception("Mã nhân viên không được để trống!");
        else
            this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) throws Exception{
        if(tenNV.isEmpty() || "".equals(tenNV.replaceAll("\\s", "")))
            throw new Exception("Tên nhân viên không được để trống!");
        else
            this.tenNV = tenNV;
    }

    public int getDangKiDL() {
        return dangKiDL;
    }

    public void setDangKiDL(int dangKiDL) throws Exception{
        if(dangKiDL == 1 || dangKiDL == 0)
            this.dangKiDL = dangKiDL;
        else
            throw new Exception("Vui lòng nhập lại! (0: Không đăng kí | 1: Có đăng kí)");
            
    }

    
    public String getNgayDKi() {
        return ngayDKi;
    }

    public void setNgayDKi(String ngayDKi) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        Date x = dateFormat.parse(ngayDKi);
        this.ngayDKi = dateFormat.format(x);
    }

    public Employee() {
    }

    public Employee(String maNV, String tenNV, int dangKiDL) throws Exception {
        setMaNV(maNV);
        setTenNV(tenNV);
        setDangKiDL(dangKiDL);
    }

    public Employee(String maNV, String tenNV, int dangKiDL, String ngayDKi) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            setMaNV(maNV);
            setTenNV(tenNV);
            setDangKiDL(dangKiDL);
            setNgayDKi(ngayDKi);
        } catch (ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void nhapNV(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("Nhập mã nhân viên: ");
            try {
                setMaNV(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                flag = true;
            }
        }while(flag == true);
        
        flag = true;
        do{
            System.out.print("Nhập tên nhân viên: ");
            try {
                setTenNV(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                flag = true;
            }
        }while(flag == true);
        
        
        flag = true;
        do{
            System.out.print("Nhân viên có đăng kí du lịch hay không(0:Không đăng kí| 1:Có đăng kí): ");
            try {
                setDangKiDL(Integer.parseInt(scan.nextLine()));
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                flag = true;
            }
        }while(flag == true);
        
        if(dangKiDL == 1){
            flag = true;
            do{
                System.out.print("Nhập ngày đăng kí (dd/mm/yyyy): ");
                try {
                    String ngay = scan.nextLine();
                    setNgayDKi(ngay);
                    flag = false;
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                    flag = true;
                }
            }while(flag == true);
        }
    }
    
    public void capNhat(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("Nhập tên nhân viên: ");
            try {
                setTenNV(scan.nextLine());
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                flag = true;
            }
        }while(flag == true);
        
        
        flag = true;
        do{
            System.out.print("Nhân viên có đăng kí du lịch hay không(0:Không đăng kí| 1:Có đăng kí): ");
            try {
                setDangKiDL(Integer.parseInt(scan.nextLine()));
                flag = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                flag = true;
            }
        }while(flag == true);
        
        if(dangKiDL == 1){
            flag = true;
            do{
                System.out.print("Nhập ngày đăng kí (dd/mm/yyyy): ");
                try {
                    String ngay = scan.nextLine();
                    setNgayDKi(ngay);
                    flag = false;
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                    flag = true;
                }
            }while(flag == true);
        }
    }
    
    public void tieuDe(){
        System.out.printf("\n%-10s%-20s%-10s%-15s", "Mã NV", "Tên NV","DKi", "Ngày DKi");
    }
    
    public void hienThi(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(dangKiDL == 0)
            System.out.printf("%-10s%-20s%-10s%-15s", maNV, tenNV, "không", "không");
        else
            System.out.printf("%-10s%-20s%-10s%-15s", maNV, tenNV, "có", ngayDKi);
    }
    
}
