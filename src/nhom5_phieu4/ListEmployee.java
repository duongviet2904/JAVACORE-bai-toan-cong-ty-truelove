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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duongv
 */
public class ListEmployee implements Serializable {
    private List<Employee> listEm;
    private List<Employee> listRegistrator;
    private List<Employee> danhSachNVDaNhanQua;
    
    
    public List<Employee> getListEm() {
        return listEm;
    }

    public void setListEm(List<Employee> listEm) {
        this.listEm = listEm;
    }

    public List<Employee> getListRegistrator() {
        return listRegistrator;
    }

    public void setListRegistrator(List<Employee> listRegistrator) {
        this.listRegistrator = listRegistrator;
    }

    public ListEmployee() {
        listEm = new ArrayList<Employee>();
        listRegistrator = new ArrayList<Employee>();
        danhSachNVDaNhanQua = new ArrayList<Employee>();
    }

    public ListEmployee(List<Employee> listEm, List<Employee> listRegistrator) {
        this.listEm = listEm;
        this.listRegistrator = listRegistrator;
    }
    
    public void themNV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên muốn thêm:");
        Employee em = new Employee();
//        int index = 0;
//        do{
//            em.nhapNV();
//        }while(checkMaNV(em.getMaNV(), index));
        int index = 0;
        
        boolean flag;
        do{
            try {
                String cloneMaNV;
                do{
                    System.out.print("Nhập mã nhân viên:");
                    cloneMaNV = sc.nextLine();
                    if(checkMaNV(cloneMaNV, index))
                        System.out.println("Mã nhân viên đã tồn tại!");
                }while(checkMaNV(cloneMaNV, index));
                em.setMaNV(cloneMaNV);
                flag = false;
                
            } catch (Exception ex) {
                flag = true;
                System.out.println(ex.getMessage());
            }
        }while(flag);
        
        em.capNhat();
        listEm.add(em);
    }
    
    public Integer getIndexByMaNV(String maNV) {
        for(Employee em : listEm){
            if(em.getMaNV().equals(maNV)) {
                return listEm.indexOf(em);
            }
        }
        return -1;
    }
    
    public void suaNV(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên muốn sửa:");
        String maNV = scan.nextLine();
        int index = getIndexByMaNV(maNV);
        
        if(checkMaNV(maNV, index)){
            listEm.get(index).capNhat();
        }else{
            System.out.println("Mã nhân viên không tồn tại");
        }
        
    }
    
    public void xoaNV(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên muốn xóa:");
        String maNV = scan.nextLine();
        int index = getIndexByMaNV(maNV);
        
        if(checkMaNV(maNV, index)){
            listEm.remove(index);
        }else{
            System.out.println("Mã nhân viên không tồn tại");
        }
    }
    public void timNV(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên muốn tìm kiếm:");
        String maNV = scan.nextLine();
        int index = getIndexByMaNV(maNV);
        
        if(checkMaNV(maNV, index)){
            listEm.get(index).hienThi();
        }else{
            System.out.println("Mã nhân viên không tồn tại");
        }
    }
    
    public boolean checkMaNV(String maNV, int index){
        for(int i = 0; i < listEm.size(); i++){
            if(listEm.get(i).getMaNV().equalsIgnoreCase(maNV))
            {
                index = i;
                return true;
            }     
        }
        return false;
    }
    
    public boolean checkNhanQua(int index){
        if(index == -1)
            return false;
        for(int i = 0; i < danhSachNVDaNhanQua.size(); i++){
            if(danhSachNVDaNhanQua.get(i).getMaNV().equalsIgnoreCase(listEm.get(index).getMaNV()))
                return true;
        }
        return false;
    }
    
    public void chonNVTangQua(){
        Random ran = new Random();
        int index;
        do{
            index = ran.nextInt(listEm.size());
//            if(danhSachNVDaNhanQua.size() == listEm.size()){
//                System.out.println("Toàn bộ nhân viên đã được tặng quà");
//                System.out.println("Làm mới danh sách");
//                danhSachNVDaNhanQua = new ArrayList<Employee>();
//                break;
//            }
            if(!checkNhanQua(index)){
                danhSachNVDaNhanQua.add(listEm.get(index));
                System.out.print("Nhan viên được chọn có MaNV: "+listEm.get(index).getMaNV()+" Tên: "+listEm.get(index).getTenNV());
                System.out.println("\nDS nhân viên đã được nhận quà:");
                hienThiDSNhanQua();
                if(danhSachNVDaNhanQua.size() == listEm.size()){
                    System.out.println("Toàn bộ nhân viên đã được tặng quà");
                    System.out.println("Làm mới danh sách");
                    danhSachNVDaNhanQua = new ArrayList<Employee>();
                }
                break;
            }
        }while(true);
    }
    
    public void hienThiDSNhanQua(){
        int dem = 1;
        System.out.printf("%-5s%-10s%-20s\n", "STT", "Mã NV", "Tên NV");
        for(Employee em : danhSachNVDaNhanQua){
            System.out.printf("%-5d%-10s%-20s\n", dem,em.getMaNV(), em.getTenNV());
            dem++;
        }
    }
    
    public void capNhatDanhSachDKiDL(){
        for(int i = 0; i < listEm.size(); i++){
            if(listEm.get(i).getDangKiDL() == 1)
                listRegistrator.add(listEm.get(i));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Comparator c = new Comparator<Employee>() {
            @Override
            public int compare(Employee o2, Employee o1) {
                try {
                    if(dateFormat.parse(o1.getNgayDKi()).before(dateFormat.parse(o2.getNgayDKi())))
                        return 1;
                } catch (ParseException ex) {
                    Logger.getLogger(ListEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
                return -1;
            }
        };
        
        listRegistrator.sort(c);
    }
    
    public String tenNVPhoBien(){
        int soLanLap = 0;
        
        Hashtable<String, Integer> soLanTrungLap = new Hashtable<String, Integer>();
        
        for(int i = 0; i < (listEm.size() - 1); i++){
            soLanLap = 0;
            if(!soLanTrungLap.containsKey(listEm.get(i).getTenNV())){
                for(int j = i + 1; j < listEm.size(); j++){
                    if(listEm.get(i).getTenNV().equalsIgnoreCase(listEm.get(j).getTenNV())){
                        soLanLap++;
                    }
                }
                soLanTrungLap.put(listEm.get(i).getTenNV(), soLanLap);
            }else{
                continue;
            }
        }
        
        int max = 0;
        for(String key: soLanTrungLap.keySet()) {
            if(soLanTrungLap.get(key) > max){
                max = soLanTrungLap.get(key);
            }
        }
        
        for(String key: soLanTrungLap.keySet()) {
            if(soLanTrungLap.get(key) == max){
                return key;
            }
        }
        return null;
    }
    public void hienThiDSNV(){
        int dem = 1;
        System.out.printf("\n%-5s%-10s%-20s%-10s%-15s","STT", "Mã NV", "Tên NV","DKi", "Ngày DKi");

        for(Employee em : listEm){
            System.out.printf("\n%-5d", dem);
            em.hienThi();
            dem++;
        }
    }
    public void hienThiDSDL(){
        int dem = 1;
        System.out.printf("\n%-5s%-10s%-20s%-10s%-15s","STT", "Mã NV", "Tên NV","DKi", "Ngày DKi");

        for(Employee em : listRegistrator){
            System.out.printf("\n%-5d", dem);
            em.hienThi();
            dem++;
        }
    }
    
    public void writeData(){
        try{
            FileOutputStream writeData = new FileOutputStream("src\\nhom5_phieu4\\Employee.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(listEm);
            writeStream.flush();
            writeStream.close();
            System.out.println("Đã ghi thành công vào file Employee.txt!");

        }catch (IOException e) {
            System.err.println("Error: "+e);
        }
    }
    public  void readData(){
        try{
            FileInputStream readData = new FileInputStream("src\\nhom5_phieu4\\Employee.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            
            List<Employee> dsnv = (List<Employee>) readStream.readObject();
            readStream.close();
            
            System.out.println("Dữ liệu đọc được: ");
            System.out.printf("%-5s%-10s%-20s\n", "STT", "Mã NV", "Tên NV");
            int dem = 1;
            for(Employee em : dsnv){
                System.out.printf("%-5d%-10s%-20s\n", dem,em.getMaNV(), em.getTenNV());
                dem++;
            }
            listEm.addAll(dsnv);
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: "+e);
        }
    }
}
