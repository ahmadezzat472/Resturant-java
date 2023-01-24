/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttest;

import java.io.Serializable;

public class Person implements Serializable{
    
    //data fields
    protected String fName;
    protected String lName;
    protected int age;
    protected int id;
    protected String gender;
    
    FileMangerBinary FManger = new FileMangerBinary();
    
    //constructor
    public Person() {
        
    }
    
    public Person(String fName, String lName, int id, int age, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.id = id;
        this.gender = gender;
    }
    
    //getter && setter
    public String getfName() {
        return fName;
    }
   
    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
