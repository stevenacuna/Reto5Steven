/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto5steven.modelo.DAO;

import com.mycompany.reto5steven.modelo.VO.Cliente;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ArqStevenAcuñaEspino
 */
public class TerceraConsulta {
    
    public void terceraconsulta(DefaultTableModel modelo){
        
        try {
            Cliente cliente = new Cliente();
            
            
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON (c.ID_Proyecto=p.ID_Proyecto) WHERE Proveedor = 'Homecenter' AND p.Ciudad='Salento'");
            
            
            
            while(rs.next()){
                cliente.setId_compra(rs.getInt(1));
                cliente.setConstructora(rs.getString(2));
                cliente.setBanco(rs.getString(3));
                modelo.addRow(new Object[]{cliente.getId_compra(),cliente.getConstructora(),cliente.getBanco()});
                
            }
            
            
            rs.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TerceraConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    
    }
    
}
