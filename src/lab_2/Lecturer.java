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
public class Lecturer {
    private String LName;
    private int  LAge;
    private String Lusername;
    private String Lpassword;
    private ArrayList<Subject> Lcourses;
    private int id;
    
    public Lecturer(){
        
    }


    public void lecturer(String LName, int LAge,String Lusername,String Lpassword,ArrayList<Subject> Lcourses,int id){
        this.id=id;
        this.LName=LName;
        this.LAge=LAge;
        this.Lusername=Lusername;
        this.Lpassword=Lpassword;
        this.Lcourses=Lcourses;

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

    public String GetLUsername() {

        return Lusername;
    }

    public void SetLUsername(String Lusername){

        this.Lusername=Lusername;
    }

    public String GetLPassword() {

        return Lpassword;
    }

    public void SetLPassword(String Lpassword){

        this.Lpassword=Lpassword;
    }

    public ArrayList<Subject> GetLCourse() {

        return Lcourses;
    }

    public void SetLCourse(ArrayList<Subject> Lcourses){

        this.Lcourses=Lcourses;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
