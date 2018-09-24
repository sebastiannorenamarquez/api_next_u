/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareascontrol.model;

/**
 *
 * @author Sebastian Noreña marquez
 */
public class Asignatura {
    String id_asignaturas;
    String nombre_asignaturas;

    public Asignatura() {
    }

    public Asignatura(String id_asignaturas, String nombre_asignaturas) {
        this.id_asignaturas = id_asignaturas;
        this.nombre_asignaturas = nombre_asignaturas;
    }

    public String getId_asignaturas() {
        return id_asignaturas;
    }
    public void setId_asignaturas(String id_asignaturas) {
        this.id_asignaturas = id_asignaturas;
    }
    public String getNombre_asignaturas() {
        return nombre_asignaturas;
    }
    public void setNombre_asignaturas(String nombre_asignaturas) {
        this.nombre_asignaturas = nombre_asignaturas;
    }
    
    
}
