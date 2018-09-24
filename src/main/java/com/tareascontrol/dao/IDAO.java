
package com.tareascontrol.dao;

import com.tareascontrol.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sebastian Noreña marquez
 * @param <T>
 */
public interface IDAO<T> {
    void insertar(T entidad) throws SQLException;
    void eliminar(String id)throws SQLException;
    List<T> listar()throws SQLException;
    T buscar(String id)throws SQLException;
    void actualizar(T entidad, String id)throws SQLException;
}
