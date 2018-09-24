/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareascontrol.recursos;

import com.tareascontrol.dao.DaoTarea;
import com.tareascontrol.model.Tarea;
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

@Path("tareas")
public class RecursoTareas {
    Tarea tarea = new Tarea();
    DaoTarea daoTarea = new DaoTarea();
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_tareas}")
    public Tarea httpGetTarea(@PathParam("id_tareas")String id_tareas) {
        
        try {
            tarea = daoTarea.buscar(id_tareas);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarea;
    }
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tarea> httpGetUsuarios() {
        ArrayList<Tarea> tareas = new ArrayList();
        try {
            tareas = daoTarea.listar();
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tareas;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tarea httpPostTarea(Tarea tarea) {
        try {
            daoTarea.insertar(tarea);
            System.out.println("tarea insertado");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarea;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id_tareas}")
    public Tarea httpPutTarea(@PathParam("id_tareas") String id_tareas, Tarea tarea) {
        try {
            daoTarea.actualizar(tarea,id_tareas);
            System.out.println("Usuario actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarea;
    }
    
    @DELETE
    @Path("{id_tareas}")
    public void httpDeleteTarea(@PathParam("id_tareas")String id_tareas) {

        try {
            daoTarea.eliminar(id_tareas);
            System.out.println("tarea eliminada");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
