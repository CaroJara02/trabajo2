/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kro02
 */
public class agregar {
    public static void main(String[] args) {
        //Conexion
        conexion con= new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;   
        
        //Datos a agregar
        String nombre = "Carolina";
        String apellido = "Jaramillo";
        String edad = "25";
        
        //Instruccion SQL
        String sql = "INSERT INTO persona (nombre, apellido, edad) values ('"+nombre+"','"+apellido+"','"+edad+"')";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //Agregar datos
            rs = st.executeQuery("SELECT * FROM persona"); //Traer datos de la tabla de cursos
            rs.next();
            
            //Imprimir en concola los datos de la tabla curso
            do {
                System.out.println(rs.getInt("id") + ": " + rs.getString("nombre")+" - "+rs.getString("apellido")+" - "+rs.getString("edad"));
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
