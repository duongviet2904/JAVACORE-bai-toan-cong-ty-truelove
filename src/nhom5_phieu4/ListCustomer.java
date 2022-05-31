/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_phieu4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ducth
 */
public class ListCustomer implements Serializable {
    TreeMap< Double,Customer> dsKH = new TreeMap<>();
    
    public void tao() {
        try {
            dsKH.put(1000.0,new Customer("01","Le Van A",1000.0));
            dsKH.put(5000.0,new Customer("02","Le Van B",5000.0));
            dsKH.put(500.0,new Customer("03","Le Van C",500.0));
            dsKH.put(7000.0,new Customer("04","Le Van D",7000.0));
            dsKH.put(2000.0,new Customer("05","Le Van E",2000.0));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
    public void hienThi() {
        System.out.println("Danh sách các khách hàng");
        System.out.printf("%-10s %-20s %10s", "Mã KH", "Họ Tên","Doanh Số");
        dsKH.forEach((key, value) -> System.out.printf("\n%-10s %-20s %10.2f", value.getMaKH(), value.getHoTen(), value.getDoanhSo()));
        System.out.println("");
    }
    public void nhapKhachHang(){
        Customer kh = new Customer();
        kh.nhap();
        dsKH.put(kh.getDoanhSo(), kh);
        System.out.println("Đã thêm khách hàng thành công!");
    }
    public void suaTTKhachHang(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String makh = sc.nextLine();
        int flag = 0;
        double doanhSoCu = 0;
        Customer kh = new Customer();
        for(Map.Entry<Double,Customer> entry : dsKH.entrySet()) {
            if(makh == null ? entry.getValue().getMaKH() == null : makh.equals(entry.getValue().getMaKH())){
                flag = 1;
                doanhSoCu = entry.getKey();
                kh = entry.getValue();
            }
        }
        if(flag == 0)
            System.out.println("Không có mã khách hàng này");
        else{
            System.out.println("Nhập thông tin mới của khách hàng");
            try {
                kh.setMaKH(makh);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            kh.sua();
            dsKH.remove(doanhSoCu);
            dsKH.put(kh.getDoanhSo(), kh);
            System.out.println("Đã sủa thành công!");
        }  
    }
    public void xoaKhachHang(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String makh = sc.nextLine();
        int flag = 0;
        double doanhSo = 0;
        for(Map.Entry<Double,Customer> entry : dsKH.entrySet()) {
            if(makh == null ? entry.getValue().getMaKH() == null : makh.equals(entry.getValue().getMaKH())){
                flag = 1;
                doanhSo = entry.getKey();
            }
        }
        if(flag == 0)
            System.out.println("Không có mã khách hàng này");
        else{
            dsKH.remove(doanhSo);
            System.out.println("Đã xóa thành công!");
        }  
    }
    public void timKiemID(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần tìm: ");
        String makh = sc.nextLine();
        int flag = 1;
        for(Map.Entry<Double,Customer> entry : dsKH.entrySet()) {
            if(makh == null ? entry.getValue().getMaKH() == null : makh.equals(entry.getValue().getMaKH())){
                flag = 0;
                System.out.println("Thông tin khách hàng có mã: "+makh);
                System.out.printf("%-10s %-20s %10s", "Mã KH", "Họ Tên","Doanh Số");
                System.out.printf("\n%-10s %-20s %10.2f",entry.getValue().getMaKH(),entry.getValue().getHoTen(),entry.getKey());
            }
        }
        System.out.println("");  
        if(flag == 1)
            System.out.println("Không có mã khách hàng này");  
    }
    public void timKiemDS(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập khách hàng có doanh số tìm: ");
        double ds = sc.nextDouble();
        if(dsKH.containsKey(ds))
        {
            System.out.println("Thông tin khách hàng doanh số: "+ds);
            System.out.printf("%-10s %-20s %10s", "Mã KH", "Họ Tên","Doanh Số");
            System.out.printf("\n%-10s %-20s %10.2f",dsKH.get(ds).getMaKH(),dsKH.get(ds).getHoTen(),dsKH.get(ds).getDoanhSo());
            System.out.println("");  
        }
        else
            System.out.println("Không có khách hàng có doanh số "+ds);  
    }
    
    public void writeData(){
        try{
            FileOutputStream writeData = new FileOutputStream("src\\nhom5_phieu4\\Customer.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(dsKH);
            writeStream.flush();
            writeStream.close();
            System.out.println("Đã ghi thành công vào file Customer.txt!");

        }catch (IOException e) {
            System.err.println("Error: "+e);
        }
    }
    public  void readData(){
        try{
            FileInputStream readData = new FileInputStream("src\\nhom5_phieu4\\Customer.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            
            TreeMap<Double,Customer> dskh = (TreeMap<Double,Customer>) readStream.readObject();
            readStream.close();
            
            System.out.println("Dữ liệu đọc được: ");
            System.out.printf("%-10s %-20s %10s", "Mã KH", "Họ Tên","Doanh Số");
            dskh.forEach((key, value) -> System.out.printf("\n%-10s %-20s %10.2f", value.getMaKH(), value.getHoTen(), key));

            
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: "+e);
        }
    }
}
