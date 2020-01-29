/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import static com.mysql.jdbc.Messages.getString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
    
       String name;
        int age;
        String subject;
        int option;
        int course[]=new int[3];
        int id;
        String module;
        String userName;
        String password;
        int sop;

        try (Connection connection = DataBaseConnection.getInstance().getConnection()) {
            Scanner input=new Scanner(System.in);
            
            System.out.println("Welcome to University Management System");
            System.out.println("");
            System.out.println("Please select an option to proceed");
            System.out.println("Press [1] Register as a Student");
            System.out.println("Press [2] Register as a Lecturer");
            
            option=input.nextInt();
            Course sub=new Course();
            
            switch (option){
                case 1:
                    System.out.println("Select [1] for Sign up, [2} for sign in");
                    sop=input.nextInt();
                    switch (sop) {
                        case 1:
                            System.out.println("Student Registration");
                            System.out.println("");
                            System.out.println("Please Submit following information");
                            System.out.println("Student ID:");
                            id = input.nextInt();
                            System.out.println("1:  Name:");
                            input.nextLine();
                            name = input.nextLine();
                            System.out.println("2:  Age:");
                            age = input.nextInt();
                            System.out.println("User name:");
                            userName = input.next();
                            System.out.println("Password:");
                            password = input.next();
                            System.out.println("3: Select course number from following list,");
                            System.out.println("[1]" + Subject.SENG1111_Introduction_to_Programming);
                            System.out.println("[2]" + Subject.SENG1112_Fundamantales_of_Engineering);
                            System.out.println("[3]" + Subject.SENG1113_Data_Structures_and_Algorithms);
                            subject=input.next();
                            Course mod=new Course();
                            String []val = subject.split(",");
                            Student student = new Student();
                            student.SetAge(age);
                            student.SetName(name);
                            student.SetId(id);
                            student.SetPassword(password);
                            student.SetUsername(userName);
                            int i=0;
                            System.out.println(val.length);
                            PreparedStatement stm = connection.prepareStatement("Insert Into Student_details Values(?,?,?,?,?);");
                            
                            stm.setObject(1, student.GetId());
                            stm.setObject(2, student.GetName());
                            stm.setObject(3, student.GetAge());
                            stm.setObject(4, student.GetUsername());
                            stm.setObject(5, student.GetPassword());
                            
                            stm.executeUpdate();
                            for(String ttr: val) {
                                int subId=Integer.parseInt(ttr);
                                mod.setId(subId);
                                System.out.println(subId);
                                
                                PreparedStatement stmm = connection.prepareStatement("INSERT INTO stu_courses VALUES (?,?)");
                                stmm.setObject(2, mod.getId());
                                stmm.setObject(1, student.GetId());
                                stmm.executeUpdate();
                                i++;
                            }
                            
                            System.out.println("Student Registration Completed");
                            System.out.println("Name    :" + student.GetName());
                            System.out.println("Age     :" + student.GetAge());
                            
                            break;
                        case 2:
                            System.out.println("Student Login form");
                            
                            System.out.println("User Name:");
                            userName=input.next();
                            System.out.println("Password:");
                            password=input.next();
                            
                            Statement  stmt=connection.createStatement();
                            ResultSet rs=stmt.executeQuery( "select * from Student_details where S_userName='"+userName+"'and s_password='"+password+"';");
                            
                            if(userName.equals("S_Username")&&password.equals("S_Password")){
                                 while (rs.next()) {
                                System.out.println( "Hi " + rs.getString(2));
                                
                            }
                            ResultSet rst=stmt.executeQuery("SELECT course_Name from courses where id in (SELECT c_Id from stu_courses where s_Id=(Select s_id from student_details where s_userName='"+userName+"'and s_password='"+password+"'));");
                            System.out.println("You have successfully registered for this courses:");
                            while(rst.next()){
                                System.out.println(" "+rst.getString("course_Name"));
                            }
                            }else{
                                System.out.println("Login Error....");
                            }
                            
                            break;
                        default:System.out.println("Please Enter 1 or 2");
                    }
                    break;
                    
                    
                case 2:
                    System.out.println("Select [1] for Sign up, [2} for sign in");
                    sop=input.nextInt();
                    switch (sop) {
                        
                        case 1:
                            System.out.println("Lecturer Registration");
                            System.out.println("");
                            System.out.println("Please Submit following information");
                            System.out.println("Lecturer ID:");
                            id = input.nextInt();
                            System.out.println("1:  Name:");
                            input.nextLine();
                            name = input.nextLine();
                            System.out.println("2:  Age:");
                            age = input.nextInt();
                            System.out.println("User name:");
                            userName = input.next();
                            System.out.println("Password:");
                            password = input.next();
                            System.out.println("3: Select course number from following list,");
                            System.out.println("[1]" + Subject.SENG1111_Introduction_to_Programming);
                            System.out.println("[2]" + Subject.SENG1112_Fundamantales_of_Engineering);
                            System.out.println("[3]" + Subject.SENG1113_Data_Structures_and_Algorithms);
                            subject=input.next();
                            Course mod=new Course();
                            String []val = subject.split(",");
                            Lecturer lecturer = new Lecturer();
                            
                            lecturer.SetLName(name);
                            lecturer.SetLAge(age);
                            lecturer.setId(id);
                            lecturer.SetLUsername(userName);
                            lecturer.SetLPassword(password);
                            int i=0;
                            PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer_details Values(?,?,?,?,?);");
                            stm.setObject(1, lecturer.getId());
                            stm.setObject(2, lecturer.GetLName());
                            stm.setObject(3, lecturer.GetLAge());
                            stm.setObject(4, lecturer.GetLUsername());
                            stm.setObject(5, lecturer.GetLPassword());
                            stm.executeUpdate();
                            System.out.println("Lecturer Registration Completed");
                            System.out.println("Name    :" + lecturer.GetLName());
                            System.out.println("Age     :" + lecturer.GetLAge());
                            
                            for(String ttr: val) {
                                int subId=Integer.parseInt(ttr);
                                mod.setId(subId);
                                System.out.println(subId);
                                
                                PreparedStatement stmm = connection.prepareStatement("INSERT INTO lec_courses VALUES (?,?)");
                                stmm.setObject(2, mod.getId());
                                stmm.setObject(1, lecturer.getId());
                                stmm.executeUpdate();
                                i++;
                            }
                            break;
                        case 2:
                            System.out.println("Lecture Login form");
                            
                            System.out.println("User Name:");
                            userName=input.next();
                            System.out.println("Password:");
                            password=input.next();
                            
                            Statement  stmt=connection.createStatement();
                            ResultSet rs=stmt.executeQuery( "select * from lecturer_details where l_userName='"+userName+"'and l_password='"+password+"';");
                            if(userName.equals("S_Username")&&password.equals("S_Password")){
                            while (rs.next()) {
                                System.out.println( "Hi " + rs.getString(2));
                                
                            }
                            ResultSet rst=stmt.executeQuery("SELECT course_Name from courses where id in (SELECT c_Id from lec_courses where l_Id=(Select l_id from lecturer_details where l_userName='"+userName+"'and l_password='"+password+"'));");
                            System.out.println("You have successfully registered for this courses:");
                            while(rst.next()){
                                System.out.println(" "+rst.getString(1));
                            }
                            }else{
                                System.out.println("Login Error....");
                            }
                            break;
                        default:System.out.println("Please Enter 1 or 2");
                    }
                    break;
                    
            }
        }


        }

    } 
       
       
       
        


