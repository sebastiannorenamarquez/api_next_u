
package com.tareascontrol.dao;


import com.tareascontrol.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Noreña marquez
 */
public class DaoUsuario implements IDAO<Usuario>{

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;


    @Override
    public void insertar(Usuario entidad) throws SQLException {

        String query = "INSERT INTO usuarios (nombre_usuarios, contrasena_usuarios, rol_usuarios) VALUES (?, ?, ?)";
        if (insertar==null){
            insertar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        insertar.setString(1, entidad.getNombre());
        insertar.setString(2, entidad.getContrasena());
        insertar.setString(3, entidad.getRol());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(String id) throws SQLException {

        String query = ( "DELETE FROM usuarios WHERE id_usuarios = ?");
        if (eliminar==null){
            eliminar= Conexion.getInstance().getCon().prepareStatement(query);
        }
        eliminar.setString(1,id);
        eliminar.executeUpdate();

    }


    @Override
    public ArrayList<Usuario> listar() throws SQLException {

        String query="SELECT * FROM usuarios";
                if (listar == null) {
            listar= Conexion.getInstance().getCon().prepareStatement(query);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();


        while (set.next()){
            Usuario user = new Usuario();
            user.setNombre(set.getString("nombre_usuarios"));
            user.setRol(set.getString("rol_usuarios"));
            user.setId(set.getString("id_usuarios"));
            user.setContrasena(set.getString("contrasena_usuarios"));
            usuarios.add(user);
        }
        return usuarios!=null ? usuarios :null;

    }


    @Override
    public Usuario buscar(String id) throws SQLException {

        String query = "SELECT * FROM usuarios where id_usuarios=?";
        if (buscar == null) {
            buscar= Conexion.getInstance().getCon().prepareStatement(query);
        }
            buscar.setString(1, id);
            ResultSet set = buscar.executeQuery();
            if (set!=null && set.next()){
            Usuario user = new Usuario();
            user.setNombre(set.getString("nombre_usuarios"));
            user.setRol(set.getString("rol_usuarios"));
            user.setId(set.getString("id_usuarios"));
            return user;
            }
            else return null;
    }


    @Override
    public void actualizar(Usuario entidad, String id) throws SQLException {

        String query = "UPDATE usuarios SET nombre_usuarios=?, contrasena_usuarios=? WHERE id_usuarios = ?";
        if (actualizar== null) {
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        actualizar.setString(1,entidad.getNombre());
        actualizar.setString(2,entidad.getContrasena());
        actualizar.setString(3, id);

        actualizar.executeUpdate();
    }

}
