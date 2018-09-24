
package com.tareascontrol.recursos;

import com.tareascontrol.model.Usuario;
import com.tareascontrol.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

@Path("usuarios")
public class RecursoUsuario {
    Usuario usuario = new Usuario();
    DaoUsuario daoUsuario = new DaoUsuario();
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_usuarios}")
    public Usuario httpGetUsuario(@PathParam("id_usuarios")String id_usuarios) {
        
        try {
            usuario = daoUsuario.buscar(id_usuarios);
            //System.out.println("Usuario: "+ usuario.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> httpGetUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            usuarios = daoUsuario.listar();
            //System.out.println(usuarios.get(0).getNombre()+ usuarios.get(1).getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void httpPostUsuario(Usuario usuario) {
        try {
            daoUsuario.insertar(usuario);
            System.out.println("Usuario insertado");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id_usuarios}")
    public void httpPutUsuario(@PathParam("id_usuarios") String id_usuarios, Usuario usuario) {
        try {
            daoUsuario.actualizar(usuario,id_usuarios);
            System.out.println("Usuario actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @DELETE
    @Path("{id_usuarios}")
    public void httpDeleteUsuario(@PathParam("id_usuarios")String id_usuarios) {

        try {
            daoUsuario.eliminar(id_usuarios);
            System.out.println("Usuario eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(RecursoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
