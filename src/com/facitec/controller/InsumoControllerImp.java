/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.controller;

import com.facitec.dao.InsumosDaoImpl;
import com.facitec.dao.InsumosDao;
import com.facitec.model.Insumos;

public class InsumoControllerImp implements InsumoController{
    
    InsumosDao insumoDao = new InsumosDaoImpl();

    public void guadar(Insumos insumo) {
        insumoDao.guadar(insumo);
    }

    public void modificar(Insumos insumos) {
        insumoDao.modificar(insumos);
    }

    public void eliminar(int codigo) {
        insumoDao.eliminar(codigo);
    }

    public Insumos consultarPorCodigo(int codigo) {
        return insumoDao.consultarPorCodigo(codigo);
    }

    public Insumos obtenerMaximo() {
        return insumoDao.obtenerMaximo();
    }
    
}
