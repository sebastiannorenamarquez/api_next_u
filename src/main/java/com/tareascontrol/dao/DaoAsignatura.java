/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareascontrol.dao;

import com.tareascontrol.model.Asignatura;
import com.tareascontrol.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Noreña marquez
 */
public class DaoAsignatura implements IDAO<Asignatura>{

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;


    @Override
    public void insertar(Asignatura entidad) throws SQLException {

        String query = "INSERT INTO asignaturas (nombre_asignaturas) VALUES (?)";
        if (insertar==null){
            insertar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        insertar.setString(1, entidad.getNombre_asignaturas());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(String id) throws SQLException {

        String query = ( "DELETE FROM asignaturas WHERE id_asignaturas = ?");
        if (eliminar==null){
            eliminar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        eliminar.setString(1,id);
        eliminar.executeUpdate();

    }


    @Override
    public ArrayList<Asignatura> listar() throws SQLException {

        String query="SELECT * FROM asignaturas";
                if (listar == null) {
            listar= Conexion.getInstance().getCon().prepareStatement(query);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Asignatura> asignaturas =  new ArrayList<Asignatura>();


        while (set.next()){
            Asignatura asig = new Asignatura();
            asig.setId_asignaturas(set.getString("id_asignaturas"));
            asig.setNombre_asignaturas(set.getString("nombre_asignaturas"));
            asignaturas.add(asig);
        }
        return asignaturas!=null ? asignaturas :null;

    }


    @Override
    public Asignatura buscar(String id) throws SQLException {

        String query = "SELECT * FROM asignaturas where id_asignaturas=?";
        if (buscar == null) {
            buscar= Conexion.getInstance().getCon().prepareStatement(query);
        }
            buscar.setString(1, id);
            ResultSet set = buscar.executeQuery();
            if (set!=null && set.next()){
            Asignatura asig = new Asignatura();
            asig.setId_asignaturas(set.getString("id_asignaturas"));
            asig.setNombre_asignaturas(set.getString("nombre_asignaturas"));
            return asig;
            }
            else return null;
    }


    @Override
    public void actualizar(Asignatura entidad, String id) throws SQLException {

        String query = "UPDATE asignaturas SET nombre_asignaturas=? WHERE id_asignaturas= ?";
        if (actualizar== null) {
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        actualizar.setString(1,entidad.getNombre_asignaturas());
        actualizar.setString(2,id);

        actualizar.executeUpdate();
    }
}
