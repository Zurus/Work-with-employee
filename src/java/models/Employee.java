/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
public class Employee {
    private String name;
    private int age;
    private float wage;
    private int id;
    private static Connection connect = null;
    public static void connect(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Загрузилось");
            connect = null;
            String str = "jdbc:mysql://localhost/ufa_jobs";
            connect = DriverManager.getConnection(str, "root","");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<Employee> all(){
        List<Employee> list = null;
        try{
            list = new ArrayList<Employee>(); 
            Statement state = null;
            ResultSet res = null;
            state = connect.createStatement();
            res = state.executeQuery("Select name,age,wage,employee_id from employees");
            while(res.next()){
                list.add(new Employee(res.getString(1),res.getInt(2),res.getFloat(3),res.getInt(4)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
        }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public float getWage(){
        return wage;
    }
    public int getId(){
        return id;
    }
    Employee(String _name,int _age,float _wage, int _id){
        this.age = _age;
        this.name = _name;
        this.wage = _wage;
        this.id=_id;
    }
    public static void addNew(String _name,int _age,float _wage){
     try{
            Statement state = null;
            int res;
            state = connect.createStatement();
            res = state.executeUpdate("Insert into employees (name,age,wage) Values ('"+_name+"','"+_age+"','"+_wage+"')");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int id){
    try{
        Statement state = null;
        int res;
        state = connect.createStatement();
        res = state.executeUpdate("DELETE FROM employees WHERE employee_id = '"+id+"';");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
}

