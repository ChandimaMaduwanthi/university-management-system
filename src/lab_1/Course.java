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
public class Course {
    CourseName course;

    public void course(CourseName course){
        this.course=course;
    }

    public CourseName GetCourse() {
        return course;
    }

    public void SetCourse(CourseName course) {
        this.course = course;
    }
}
