/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.util.ArrayList;



/**
 *
 * @author ASUS
 */
public class Student {
    private String name;
    private int  age;
    private String username;
    private String password;
    private ArrayList<Subject> courses;
    private int id;


    public Student(){
        
    }
   
    

    public void student(String name, int age,String username,String password,ArrayList<Subject> courses,int id){
        this.id=id;
        this.name=name;
        this.age=age;
        this.username=username;
        this.password=password;
        this.courses=courses;

    }

    public String GetName() {

        return name;
    }

    public void SetName(String name){

        this.name=name;
    }

    public int GetAge(){

        return age;
    }

    public void SetAge(int age){

        this.age=age;
    }

    public String GetUsername() {

        return username;
    }

    public void SetUsername(String username){

        this.username=username;
    }

    public String GetPassword() {

        return password;
    }

    public void SetPassword(String password){

        this.password=password;
    }

    public ArrayList<Subject> GetCourse() {

        return courses;
    }

    public void SetCourse(ArrayList<Subject> courses){

        this.courses=courses;
    }
    
      public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

}
