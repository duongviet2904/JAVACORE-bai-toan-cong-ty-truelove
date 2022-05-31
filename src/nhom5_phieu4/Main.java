/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_phieu4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ducth
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListCustomer lstCus = new ListCustomer();
        ListEmployee lstEm = new ListEmployee();
        ListProduct lstPro = new ListProduct();
        lstCus.tao();
        ArrayList<Employee> lst = new ArrayList<Employee>();
        try {
            lst.add(new Employee("NV01", "Nhan vien A", 0));
            lst.add(new Employee("NV02", "Nhan vien B", 1, "12/12/2022"));
            lst.add(new Employee("NV03", "Nhan vien C", 0));
            lst.add(new Employee("NV04", "Nhan vien D", 1, "13/12/2022"));
            lst.add(new Employee("NV05", "Nhan vien B", 1, "10/12/2022"));
            lst.add(new Employee("NV06", "Nhan vien E", 1, "14/12/2022"));
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        lstEm.setListEm(lst);
        String chon;
        do{
            System.out.println("\n                  MENU");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Quản lý danh sách nhân viên");
            System.out.println("3. Nhân viên ngẫu nhiên được tặng quà trong tháng");
            System.out.println("4. Cung cấp tên cho sản phẩm");
            System.out.println("5. Tên phổ biến cho sản phẩm");
            System.out.println("6. Hiển thị danh sách nhân viên đăng kí du lịch");
            System.out.println("7. Hiển thị danh sách khách hàng tăng dần doanh thu");
            System.out.println("8. Quản lý danh sách khách hàng");
            System.out.println("9. Đọc ghi file");
            System.out.println("0. Thoát");
            System.out.print("=>");
            chon = sc.nextLine();
            switch(chon){
                case "1":
                    lstEm.hienThiDSNV();
                    break;
                case "2":
                    quanLyNhanVien(lstEm);
                    break;
                case "3":
                    lstEm.chonNVTangQua();
                    break;
                case "4":
                    lstPro.setListEm(lstEm);
                    lstPro.chonTenSanPham();
                    lstPro.hienThi();
                    break;
                case "5":
                    System.out.println(lstEm.tenNVPhoBien());
                    break;
                case "6":
                    lstEm.capNhatDanhSachDKiDL();
                    lstEm.hienThiDSDL();
                    break;
                case "7":
                    lstCus.hienThi();
                    break;
                case "8":
                    quanLyKhachHang(lstCus);
                    break;
                case "9":
                    docGhiFile(lstEm, lstCus, lstPro);
                    break;
                
            }
        }while(!"0".equals(chon));
    }
    public static void quanLyKhachHang(ListCustomer lstCus){
    Scanner sc = new Scanner(System.in);
        String chon;
        do{
            System.out.println("\n         MENU QUẢN LÝ KHÁCH HÀNG");
            System.out.println("1.Thêm một khách hàng");
            System.out.println("2.In thông tin tất cả khách hàng");
            System.out.println("3.Sửa thông tin khách hàng theo mã khách hàng");
            System.out.println("4.Tìm kiếm theo mã khách hàng");
            System.out.println("5.Tìm kiếm theo doanh số");
            System.out.println("6.Xóa khách hàng theo mã khách hàng");
            System.out.println("0.Trở về MENU");
            System.out.print("=>");
            chon = sc.nextLine();
            switch(chon){
                case "1":
                    lstCus.nhapKhachHang();
                    break;
                case "2":
                    lstCus.hienThi();
                    break;
                case "3":
                    lstCus.suaTTKhachHang();
                    break;
                case "4":
                    lstCus.timKiemID();
                    break;
                case "5":
                    lstCus.timKiemDS();
                    break;
                case "56":
                    lstCus.xoaKhachHang();
                    break;
            }
        }while(!"0".equals(chon));
    }
    public static void quanLyNhanVien(ListEmployee lstEm){
    Scanner sc = new Scanner(System.in);
        String chon;
        do{
            System.out.println("\n      MENU QUẢN LÝ NHÂN VIÊN");
            System.out.println("1.Thêm một nhân viên");
            System.out.println("2.In thông tin tất cả nhân viên");
            System.out.println("3.Sửa thông tin nhân viên theo mã nhân viên");
            System.out.println("4.Tìm kiếm theo mã nhân viên");
            System.out.println("5.Xóa nhân viên theo mã nhân viên");
            System.out.println("0.Trở về MENU chinh");
            System.out.print("=>");
            chon = sc.nextLine();
            switch(chon){
                case "1":
                    lstEm.themNV();
                    break;
                case "2":
                    lstEm.hienThiDSNV();
                    break;
                case "3":
                    lstEm.suaNV();
                    break;
                case "4":
                    lstEm.timNV();
                    break;
                case "5":
                    lstEm.xoaNV();
                    break;
            }
        }while(!"0".equals(chon));
    }
    public static void docGhiFile(ListEmployee lstEm, ListCustomer lstCus, ListProduct lstPro){
    Scanner sc = new Scanner(System.in);
        String chon;
        do{
            System.out.println("\n    MENU QUẢN LÝ ĐỌC GHI FILE");
            System.out.println("1.Xuất thông tin nhân viên ra file");
            System.out.println("2.Đọc thông tin nhân viên từ file");
            System.out.println("3.Xuất thông tin sản phẩm ra file");
            System.out.println("4.Đọc thông tin sản phẩm từ file");
            System.out.println("5.Xuất thông tin khách hàng ra file");
            System.out.println("6.Đọc thông tin khách hàng từ file");
            System.out.println("0.Trở về MENU chinh");
            System.out.print("=>");
            chon = sc.nextLine();
            switch(chon){
                case "1":
                    lstEm.writeData();
                    break;
                case "2":
                    lstEm.readData();
                    break;
                case "3":
                    lstPro.writeData();
                    break;
                case "4":
                    lstPro.readData();
                    break;
                case "5":
                    lstCus.writeData();
                    break;
                case "6":
                    lstCus.readData();
                    break;
            }
        }while(!"0".equals(chon));
    }
    
}
