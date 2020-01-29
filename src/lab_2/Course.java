/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

/**
 *
 * @author ASUS
 */
public class Course {
    private String courses;
    private  int id;

    

    public Course() {
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course(String courses, int id) {
        this.courses = courses;
        this.id = id;
    }

    public String GetCourse() {
        return courses;
    }

    public void SetCourse(String courses) {
        this.courses = courses;
    }
}
