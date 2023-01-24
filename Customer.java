/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projecttest;
import java.util.ArrayList;
import java.io.Serializable;

public class Customer extends Person implements Serializable{
    
    //data fields
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    private final String CustomerFileName = "Customers.bin";
    
    //constructor
    public Customer() {
    }

    public Customer(String fName, String lName, int age, int id, String gender) {
        super(fName, lName, age, id, gender);
    }
    
    //methods
    public boolean writeToFile() {
        return FManger.write(CustomerFileName, customers);
    }
    
    private void copyFromFile() {
        customers = (ArrayList<Customer>) FManger.read(CustomerFileName);
    }
    
    private int getCustomerIndex(int id) {
        for(int i=0; i<customers.size() ;i++)  
            if(id == customers.get(i).getId())
                return i;
        return -1;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "fName=" + fName + ", lName=" + lName + ", age=" + age + ", id=" + id + ", gender=" + gender + '}';
    }
    
    public boolean addCustomer() {
        copyFromFile();
        if(customers.contains(this.id)){
            customers.add(this);
            return writeToFile();
        }
        else{
            System.out.println("customer's "+this.id+" is already exist");
            return false;
        }
    }
    
    public boolean deleteCustomer(int id) {
        copyFromFile();
        int index = getCustomerIndex(id);
        if(index != -1){
            customers.remove(index);
            return writeToFile();
        }
        return false;    
    }
    
    public boolean updateCustomer(int oldId,Customer c) {
        copyFromFile();
        int index = getCustomerIndex(oldId);
        if(index != -1){
            customers.set(index,c);
            return writeToFile();
        }
        return false;   
    }
    
    public String listCustomer() {
        copyFromFile();
        String s = "\nAll customer Data: \n";
        for (Customer c : customers) {
            s = s + c.toString() + "\n";
        }
        return s;
    } 
    
    public void profileCustomer(int id) {
        disCustomer(id);
        Order o = new Order();
        o.getOrderIndex(id);
    }
    
    //search customer
    public String searchCustomer(int id) {
        copyFromFile();
        int index = getCustomerIndex(id);
        if(index != -1)
            return "found: " + customers.get(index).toString();
        else
            return "not found";
    }
    
    //display profile customer
    public void disCustomer(int id) {
        copyFromFile();
        int index = getCustomerIndex(id);
        if(index != -1)
             System.out.println("customer info : \n "+customers.get(index).toString());
    }
    
    public static void main(String[] args) { 
        Customer c =new Customer();
        Employee e = new Employee();
  
        //e.addCustomer("ahmed", "ezat", 20210077, 20, "male");
        //e.addCustomer("bola", "hanafy", 20210077, 20, "male");
        //e.deleteCustomer(20210077);
        //e.listCustomer(); 
        
        //order
        //e.addOrder(20210077, 1, "apple",1, 10.0);
        //e.addOrder(20210077, 3, "meat",2, 10.0);
        //e.addOrder(2021029, 2, "kol", 3, 100.0);
        //e.listOrder();
        //e.deleteOrder(20210077,"meat");
        //e.listOrder();
        //c.profileCustomer(20210077);
        
        
        //bill
        //e.makeBill(2, 100);
        e.listBill();
    }
   
}


