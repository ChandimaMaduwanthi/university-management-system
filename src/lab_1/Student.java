/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_1;

/**
 *
 * @author ASUS
 */
public class Student {
    private String name;
    private int age;

    public void student(String name, int age){

        this.name=name;
        this.age=age;

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

}
