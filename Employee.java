/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttest;

import java.io.Serializable;

public class Employee extends Person implements Serializable{
    
    //data fields
    protected String username;
    protected String pass;
    protected double salary;
    
    
    //constructer
    public Employee(){
        
    }
    
    public Employee(String username,String pass,double salary,String fName, String lName, int age, int id, String gender) {
        super( fName,  lName,  age,  id,  gender);
        this.username= username;
        this.pass = pass;
        this.salary = salary; 
    }

    
    //getter && setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    //methods Customer
    public void addCustomer(String fname, String lname, int id, int age, String gender) {
        Customer c = new Customer(fname, lname, id, age, gender);
        if (c.addCustomer()) 
                System.out.println(c.toString() + "Added Successfully.");
        else 
            System.out.println("Failed to insert !");
    }
    
    public void listCustomer() {
        Customer x = new Customer();
        System.out.println(x.listCustomer());
    }
    
    public void deleteCustomer(int Id) {
        Customer x = new Customer();
        if (x.deleteCustomer(Id)) 
           System.out.println("Customer: "+ Id + " Deleted Successfully.");
        else 
            System.out.println("Failed to Deleted !");
    }
    
    public void searchCustomer(int id) {
        Customer c = new Customer();
        System.out.println(c.searchCustomer(id));
    }

    public void updateCustomer(int oldID, Customer newCustomerValues) {
        Customer c = new Customer();
        if (c.updateCustomer(oldID, newCustomerValues)) 
            System.out.println(newCustomerValues.toString() + "Updated Successfully.");
        else 
            System.out.println("Failed to Updated !");
    }
    
    //oreder
    public void addOrder(int id, int amount, String nameMeals, int numTable, double price) {
        Order o = new Order(id, amount, nameMeals, numTable, price);
        o.setTotalPrice(price*amount);
        if (o.addOrder()) 
            System.out.println(o.toString() + "Added Successfully.");
        else 
            System.out.println("Failed to insert !");
    }
    
    public void listOrder() {
        Order o = new Order();
        System.out.println(o.listOrder());
    }
    
    public void deleteOrder(int Id, String nameMeal) {
        Order o = new Order();
        if (o.deleteOrder(Id, nameMeal)) {
           System.out.println("customer's Order: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    //bill
    public void makeBill(int numTable, double pay){
        Bill b = new Bill();
        b.addBill(numTable, pay);
    }
    
    public void listBill() {
        Bill b = new Bill();
        System.out.println(b.listBill());
    }
    
    
}
