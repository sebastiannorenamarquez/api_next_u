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
public class Tarea {
    
    String id_tareas;
    String nombre_tareas;
    String nota_tareas;
    String asignaturas_nombre_asignaturas;
    String usuarios_nombre_usuarios;

    public Tarea() {
    }

    public String getId_tareas() {
        return id_tareas;
    }
    public void setId_tareas(String id_tareas) {
        this.id_tareas = id_tareas;
    }
    public String getNombre_tareas() {
        return nombre_tareas;
    }
    public void setNombre_tareas(String nombre_tareas) {
        this.nombre_tareas = nombre_tareas;
    }
    public String getNota_tareas() {
        return nota_tareas;
    }
    public void setNota_tareas(String nota_tareas) {
        this.nota_tareas = nota_tareas;
    }
    public String getAsignaturas_nombre_asignaturas() {
        return asignaturas_nombre_asignaturas;
    }
    public void setAsignaturas_nombre_asignaturas(String asignaturas_nombre_asignaturas) {
        this.asignaturas_nombre_asignaturas = asignaturas_nombre_asignaturas;
    }
    public String getUsuarios_nombre_usuarios() {
        return usuarios_nombre_usuarios;
    }
    public void setUsuarios_nombre_usuarios(String usuarios_nombre_usuarios) {
        this.usuarios_nombre_usuarios = usuarios_nombre_usuarios;
    }
    
    
    
}
