/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.util;

import com.facitec.dao.InsumosDao;
import com.facitec.dao.InsumosDaoImpl;
import com.facitec.model.Insumos;

public class ConexionManagerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Insumos ins = new Insumos("Oficina", "porta mina", 10, 5000.00);
        
        InsumosDao dao = new InsumosDaoImpl();
        
        dao.guadar(ins);
        
    }
    
}
