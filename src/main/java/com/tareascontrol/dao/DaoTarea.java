/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareascontrol.dao;

import com.tareascontrol.model.Asignatura;
import com.tareascontrol.model.Tarea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Noreña marquez
 */
public class DaoTarea implements IDAO<Tarea>{

     private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;


    @Override
    public void insertar(Tarea entidad) throws SQLException {

        String query = "INSERT INTO tareas (nombre_tareas"
                + ", nota_tareas"
                + ", asignaturas_nombre_asignaturas"
                + ", usuarios_nombre_usuarios) VALUES (?, ?, ?, ?)";
        if (insertar==null){
            insertar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        insertar.setString(1, entidad.getNombre_tareas());
        insertar.setString(2, entidad.getNota_tareas());
        insertar.setString(3, entidad.getAsignaturas_nombre_asignaturas());
        insertar.setString(4, entidad.getUsuarios_nombre_usuarios());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(String id) throws SQLException {

        String query = ( "DELETE FROM tareas WHERE id_tareas = ?");
        if (eliminar==null){
            eliminar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        eliminar.setString(1,id);
        eliminar.executeUpdate();

    }


    @Override
    public ArrayList<Tarea> listar() throws SQLException {

        String query="SELECT * FROM tareas";
                if (listar == null) {
            listar= Conexion.getInstance().getCon().prepareStatement(query);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Tarea> tareas =  new ArrayList<Tarea>();


        while (set.next()){
            Tarea tare = new Tarea();
            tare.setId_tareas(set.getString("id_tareas"));
            tare.setNombre_tareas(set.getString("nombre_tareas"));
            tare.setNota_tareas(set.getString("nota_tareas"));
            tare.setAsignaturas_nombre_asignaturas(set.getString("asignaturas_nombre_asignaturas"));
            tare.setUsuarios_nombre_usuarios(set.getString("usuarios_nombre_usuarios"));
            tareas.add(tare);
        }
        return tareas!=null ? tareas :null;

    }


    @Override
    public Tarea buscar(String id) throws SQLException {

        String query = "SELECT * FROM tareas where id_tareas=?";
        if (buscar == null) {
            buscar= Conexion.getInstance().getCon().prepareStatement(query);
        }
            buscar.setString(1, id);
            ResultSet set = buscar.executeQuery();
            if (set!=null && set.next()){
            Tarea tare = new Tarea();
            tare.setId_tareas(set.getString("id_tareas"));
            tare.setNombre_tareas(set.getString("nombre_tareas"));
            tare.setNota_tareas(set.getString("nota_tareas"));
            tare.setAsignaturas_nombre_asignaturas(set.getString("asignaturas_nombre_asignaturas"));
            tare.setUsuarios_nombre_usuarios(set.getString("usuarios_nombre_usuarios"));
            return tare;
            }
            else return null;
    }


    @Override
    public void actualizar(Tarea entidad, String id) throws SQLException {

        String query = "UPDATE tareas "
                + "SET nombre_tareas=?,"
                + " nota_tareas=?,"
                + " asignaturas_nombre_asignaturas=?,"
                + " usuarios_nombre_usuarios=?"
                + " WHERE id_tareas= ?";
        if (actualizar== null) {
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        actualizar.setString(1,entidad.getNombre_tareas());
        actualizar.setString(2,entidad.getNota_tareas());
        actualizar.setString(3,entidad.getAsignaturas_nombre_asignaturas());
        actualizar.setString(4,entidad.getUsuarios_nombre_usuarios());
        actualizar.setString(5,id);

        actualizar.executeUpdate();
    }
}
