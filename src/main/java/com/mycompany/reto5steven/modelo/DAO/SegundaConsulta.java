/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto5steven.modelo.DAO;

import com.mycompany.reto5steven.modelo.VO.Proyecto;
import java.lang.System.Logger;
import java.sql.*;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ArqStevenAcuñaEspino
 */
public class SegundaConsulta {
    
     public void segundaconsulta(DefaultTableModel modelo){
        
         try {
             Proyecto proyecto = new Proyecto();
             
             
             Conexion cc = new Conexion();
             Connection cn = cc.conectar();
             
             Statement st = cn.createStatement();
             
             ResultSet rs = st.executeQuery("SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion='Casa Campestre' AND CIUDAD IN('Santa Marta', 'Cartagena', 'Barranquilla')");
             
             
             while(rs.next()){
                 proyecto.setId_proyecto(rs.getInt(1));
                 proyecto.setConstructora(rs.getString(2));
                 proyecto.setNumero_habitaciones(rs.getInt(3));
                 proyecto.setCiudad(rs.getString(4));
                 
                 modelo.addRow(new Object[]{proyecto.getId_proyecto(), proyecto.getConstructora(), proyecto.getNumero_habitaciones(),proyecto.getCiudad()});
                 
             }
             
             
             rs.close();
             cn.close();
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(SegundaConsulta.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
        
    
    }
    
}
