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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author duongv
 */
public class ListProduct implements Serializable{
    private ListEmployee listEm = new ListEmployee();
    private Set<Product> listProName = new HashSet<Product>();

    public ListEmployee getListEm() {
        return listEm;
    }

    public void setListEm(ListEmployee listEm) {
        this.listEm = listEm;
    }

    public Set<Product> getListProName() {
        return listProName;
    }

    public void setListProName(Set<Product> listProName) {
        this.listProName = listProName;
    }

    public ListProduct() {
        
    }
    public ListProduct(ArrayList<Employee> lst) {
        listEm.setListEm(lst);
    }
    
    public void capNhatTenSP(){
        for(Employee em : listEm.getListEm()){
            Product pro = new Product(em.getTenNV());
            listProName.add(pro);
        }
    }
    
    public String tenPhoBien(){
        return listEm.tenNVPhoBien();
    }
    
    public void hienThi(){
        System.out.println("Danh sách các sản phẩm:");
        int dem = 1;
        System.out.printf("%-5s%-20s\n", "STT", "Tên SP");
        for(Product pro : listProName){
            System.out.printf("%-5d%-20s\n", dem, pro.getTenSP());
            dem++;
        }
    }
    public boolean checkName(String name, Set<Product> h)
    {
        if(h.isEmpty())
            return false;
        for(Product p: h)
        {
            if(name.equals(p.getTenSP()))
                return true;
        }
        return false;
    }
    public void chonTenSanPham(){
        Set<String> s = new HashSet<>();
        for(Employee e: listEm.getListEm())
            s.add(e.getTenNV());
        Random ran = new Random();
        boolean flag = true;
        int dem = 0;
        do{
            if(s.size() == listProName.size())
            {
                System.out.println("Toàn bộ tên nhân viên đã được dử dụng!");
                break;
            }
            int index = ran.nextInt(s.size());
            
            String name="";
            for(String a: s)
            {
                if(dem == index)
                {
                    name = a;
                    dem = 0;
                    break;
                }
                else dem++;
            }
            Product p = new Product(name);
            if(!checkName(name, listProName))
            {
                System.out.println("Tên sản phẩm được tạo :" + name);
                listProName.add(p);
                flag = false;
            }
        }while(flag);
    }
    public void writeData(){
        try{
            FileOutputStream writeData = new FileOutputStream("src\\nhom5_phieu4\\Product.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(listProName);
            writeStream.flush();
            writeStream.close();
            System.out.println("Đã ghi thành công vào file Product.txt!");

        }catch (IOException e) {
            System.err.println("Error: "+e);
        }
    }
    public  void readData(){
        try{
            FileInputStream readData = new FileInputStream("src\\nhom5_phieu4\\Product.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            
            HashSet<Product> dssp = (HashSet<Product>) readStream.readObject();
            readStream.close();
            
            System.out.println("Dữ liệu đọc được: ");
            System.out.printf("%-5s%-10s%-20s\n", "STT", "Mã NV", "Tên NV");
            int dem = 1;
            for(Product p : dssp){
                System.out.printf("%-5d%-20s\n", dem,p.getTenSP());
                dem++;
            }
            listProName.addAll(dssp);
            
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: "+e);
        }
    }
}
