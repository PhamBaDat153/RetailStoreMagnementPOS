
package com.doan.possystem;

import java.sql.Connection;

public class Database {
       public static Connection myCon(){
           Connection con = null;
           try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","1234"); // Kết nối với database MySQL
               return con;
           }catch(Exception e){
               System.out.println(e);
               return null;
           }
       }
}
