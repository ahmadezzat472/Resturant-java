package projecttest;
//import java.io.File;
//import java.io.FileWriter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//import java.io.IOException;
//import java.io.Writer;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.Scanner;
//import java.util.Random;
 public class Bill extends Order implements Serializable {
     
    //data fields
    protected final static double service = 10.0;
    protected double totalBill;
    protected double pay;
    protected double remain;
    Date date;
    
    ArrayList<Bill> bills = new ArrayList<Bill>();
    FileMangerBinary FManger = new FileMangerBinary();
    final String billFileName = "Bill.bin";

    public Bill() {
    }

    public Bill( double totalBill, double pay, double remain) {
        this.totalBill = totalBill;
        this.pay = pay;
        this.remain = remain;
    }
    
    public Bill(Order o, double pay) {
        super(o.id,o.amount,o.nameMeals,o.numTable,o.price );
        this.pay = pay;
        date = new Date();
    }

    public double getService() {
        return service;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }
    
    //methods
    public boolean writeToFile() {
        return FManger.write(billFileName, bills);
    }
    
    private void copyFromFile() {
        bills = (ArrayList<Bill>) FManger.read(billFileName);
    }

    @Override
    public String toString() {
        return "Bill{" + "totalBill=" + totalBill + ", pay=" + pay + ", remain="+ remain + ",numTable=" + numTable + ",count=" + count + ",nameMeals="+ nameMeals + ",price=" + price + ",totalPrice=" + price*amount+ ", Date and time = " +date +'}';
    }
    
    public String listBill() {
            copyFromFile();
            String s = "\nAll Bilss Data: \n";
            for (Bill b : bills) {
                s = s + b.toString() + "\n";
            }
            return s;
    } 
    
    
    public boolean addBill(int numTable, double pay) {
        copyFromFile(); 
        Order o = new Order();
        int index = o.getOrderIndexTa(numTable);
        Bill b = new Bill(o.orders.get(index), pay);
        b.setTotalBill(o.orders.get(index).getTotalPrice()+Bill.service);
        b.setRemain(Math.abs(b.getTotalBill() - pay));
        bills.add(b);
        return writeToFile();
    }
     
     
}
