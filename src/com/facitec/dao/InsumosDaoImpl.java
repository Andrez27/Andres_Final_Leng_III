/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.dao;

import com.facitec.model.Insumos;
import com.facitec.util.ConexionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InsumosDaoImpl implements InsumosDao{

    private String sql;
    public void guadar(Insumos insumo) {
        sql ="INSERT INTO insumos"
                + "(nombre, descripcion, cantidad, precio_costo) "
                + "VALUES ('"+insumo.getNombre()+"', '"+insumo.getDescripcion()+"', "
                + ""+insumo.getCantidad()+", "+insumo.getPrecioCosto()+");";
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.st.execute(sql);
            JOptionPane.showMessageDialog(null, "Articulo guardado exitosamente", "Aviso", 1);
            System.out.println("SQL "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar articulo "+ex, "Aviso", 1);
            System.out.println("Error"+ex);
        }
        
        ConexionManager.desconectar();
    }
    
    public void modificar(Insumos insumo) {
        sql ="UPDATE insumos "
                + "SET nombre='"+insumo.getNombre()+"', descripcion='"+insumo.getDescripcion()+"', "
                + "cantidad="+insumo.getCantidad()+", precio_costo="+insumo.getPrecioCosto()+" "
                + "WHERE codigo="+insumo.getCodigo()+";";
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.st.execute(sql);
            JOptionPane.showMessageDialog(null, "Articulo modificado exitosamente", "Aviso", 1);
            System.out.println("SQL "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar articulo "+ex, "Aviso", 1);
            System.out.println("Error"+ex);
        }
        
        ConexionManager.desconectar();
    }

    public void eliminar(int codigo) {
        sql ="DELETE FROM insumos WHERE codigo="+codigo+";";
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.st.execute(sql);
            JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente", "Aviso", 1);
            System.out.println("SQL "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar articulo "+ex, "Aviso", 1);
            System.out.println("Error"+ex);
        }
        
        ConexionManager.desconectar();
    }

    public Insumos consultarPorCodigo(int codigo) {
        
        sql ="SELECT nombre, descripcion, cantidad, precio_costo FROM insumos WHERE codigo = "+codigo+";";
        ResultSet rs;
        
        Insumos ins = null;
        
        ConexionManager.conectar();
        
        try {
            rs = ConexionManager.st.executeQuery(sql);
            
            if (rs.next()) {
                ins = new Insumos();
                ins.setNombre(rs.getString("nombre"));
                ins.setDescripcion(rs.getString("descripcion"));
                ins.setCantidad(rs.getInt("cantidad"));
                ins.setPrecioCosto(rs.getDouble("precio_costo"));
            }
            System.out.println("SQL "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al consultar articulo "+ex, "Aviso", 1);
            System.out.println("Error"+ex);
        }
        
        ConexionManager.desconectar();
        
        return ins;
    }

    public Insumos obtenerMaximo() {
        
        sql ="SELECT MAX (codigo) as codigo FROM insumos;";
        
        ResultSet rs;
        
        Insumos ins = null;
        
        ConexionManager.conectar();
        
        try {
            rs = ConexionManager.st.executeQuery(sql);
            
            if (rs.next()) {
                ins = new Insumos();
                ins.setCodigo(rs.getInt("codigo")+1);
            }
            System.out.println("SQL "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al consultar maximo valor "+ex, "Aviso", 1);
            System.out.println("Error"+ex);
        }
        
        ConexionManager.desconectar();
        
        return ins;
    }
}
