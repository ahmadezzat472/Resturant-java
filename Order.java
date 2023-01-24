/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttest;

import java.util.ArrayList;
import java.io.Serializable;

public class Order implements Serializable {
    
    //data  fields
    protected int id;
    protected int count = 0;
    protected int amount;
    protected String nameMeals;
    protected int numTable;
    protected double price;
    protected double totalPrice;
    
    ArrayList<Order> orders = new ArrayList<Order>();
    FileMangerBinary FManger = new FileMangerBinary();
    final String OrderFileName = "Order.bin";

    //constructor
    public Order() {
        
    }

    public Order(int id, int amount, String nameMeals, int numtable, double price) {
        this.id = id;
        this.amount = amount;
        this.nameMeals = nameMeals;
        this.price = price;
        this.numTable = numtable;
    }

    //getter && setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNameMeals() {
        return nameMeals;
    }

    public void setNameMeals(String nameMeals) {
        this.nameMeals = nameMeals;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumTable() {
        return numTable;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }
        
    //methods
    public boolean writeToFile() {
        return FManger.write(OrderFileName, orders);
    }
    
    private void copyFromFile() {
        orders = (ArrayList<Order>) FManger.read(OrderFileName);
    }

    //to delete Order
    private int getOrderIndex(int id,String nameMeal ) {
        for(int i=0; i<orders.size() ;i++)  
            if(id == orders.get(i).getId() && nameMeal.equals(orders.get(i).getNameMeals()))
                return i;
        return -1;
    }
    
    //get orders of id to display profile
    public void getOrderIndex(int id) {
        copyFromFile();
        for(int i=0; i<orders.size() ;i++){  
            if(id == orders.get(i).getId())
                System.out.println("customer's order : "+orders.get(i));
        }
    }       
    
    //get orders of numtable to return bill
    public int getOrderIndexTa(int numtable) {
        copyFromFile();
        for(int i=0; i<orders.size() ;i++)  
            if(numtable == orders.get(i).getNumTable())
                return i;
        return -1;
    }
    
    @Override
    public String toString() {
        return "Order{" + "id=" + id  + ", amount=" + amount + ", nameMeals=" + nameMeals + ",numTable=" + numTable +", price=" + price + " , total price=" + totalPrice + '}';
    }
    
    public boolean addOrder() {
        copyFromFile(); 
        orders.add(this);
        count++;
        return writeToFile();
    }
    
    public boolean deleteOrder(int id, String nameMeal) {
        copyFromFile();
        int index = getOrderIndex(id, nameMeal);
        if(index != -1){
            orders.remove(index);
            count--;
        }
        return writeToFile();
    }
    
    public String listOrder() {
            copyFromFile();
            String s = "\nAll customer's orders Data: \n";
            for (Order c : orders) {
                s = s + c.toString() + "\n";
            }
            return s;
        } 
    }

