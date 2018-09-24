/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareascontrol.recursos;

import com.tareascontrol.dao.DaoAsignatura;
import com.tareascontrol.model.Asignatura;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sebastian Noreña marquez
 */

@Path("asignaturas")
public class RecursoAsignatura {
    Asignatura asignatura = new Asignatura();
    DaoAsignatura daoAsignatura = new DaoAsignatura();
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_asignaturas}")
    public Asignatura httpGetAsignaturas(@PathParam("id_asignaturas")String id_asignaturas) {
        
        try {
            asignatura = daoAsignatura.buscar(id_asignaturas);
            System.out.println("Asignatura: "+ asignatura.getNombre_asignaturas());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignatura;
    }
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Asignatura> httpGetAsignaturas() {
        ArrayList<Asignatura> asignaturas = new ArrayList();
        try {
            asignaturas = daoAsignatura.listar();
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignaturas;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void httpPostAsignatura(Asignatura asignatura) {
        try {
            daoAsignatura.insertar(asignatura);
            System.out.println("Asignatura Insertada");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id_asignaturas}")
    public void httpPutAsignatura(@PathParam("id_asignaturas") String id_asignaturas, Asignatura asignatura) {
        try {
            daoAsignatura.actualizar(asignatura,id_asignaturas);
            System.out.println("Asignatura actualizada");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @DELETE
    @Path("{id_asignaturas}")
    public void httpDeleteAsignatura(@PathParam("id_asignaturas")String id_asignaturas) {

        try {
            daoAsignatura.eliminar(id_asignaturas);
            System.out.println("Asignatura eliminada");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
