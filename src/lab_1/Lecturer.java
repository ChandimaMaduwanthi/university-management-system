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
public class Lecturer {
    private String LName;
    private int  LAge;

    public void lecturer(String LName, int LAge){

        this.LName=LName;
        this.LAge=LAge;

    }

    public String GetLName(){
        return LName;
    }

    public void SetLName(String LName){
        this.LName=LName;
    }

    public int GetLAge(){
        return LAge;
    }

    public void SetLAge(int LAge){
        this.LAge=LAge;
    }
}
