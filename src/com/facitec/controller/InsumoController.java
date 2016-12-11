/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.controller;

import com.facitec.model.Insumos;

public interface InsumoController {
    void guadar(Insumos insumo);
    void modificar(Insumos insumo);
    void eliminar(int codigo);
    Insumos consultarPorCodigo(int codigo);
    Insumos obtenerMaximo();
}
