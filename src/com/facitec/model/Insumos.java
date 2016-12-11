/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.model;

/**
 *
 * @author User_2
 */
public class Insumos {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private Double precioCosto;

    public Insumos() {
        this.codigo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.precioCosto = 0d;
    }

    public Insumos(String nombre, String descripcion, int cantidad, Double precioCosto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
    }

    public Insumos(int codigo, String nombre, String descripcion, int cantidad, Double precioCosto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }
    
    
}
