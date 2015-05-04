/*
 * Paquete que contiene los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioLocal extends CrudRepository<Local, Integer>{
    
    /**
     * Método que carga la información de los locales.
     * @return Una lista con la información.
     */
    @Query("SELECT local FROM Local local")
    List<Local> cargarLocales();

    /**
     * Método que se encarga de buscar un local por medio de su id.
     * @param id El id del local. 
     * @return Un local.
     */
    @Query("SELECT local FROM Local local WHERE local.id = ?")
    Local buscarLocal(Integer id);
    
    /**
     * Método que carga los comentarios del local que resibe como parametro.
     * @param local El local que se desea obtener los comentarios.
     * @return Una lista con la información.
     */
    @Query("SELECT c FROM Comentario c WHERE c.local = ?")
    List<Comentario> cargarComentarios(Local local);
    
    /**
     * Método que busca el comentario de un local que fuere realizado por un usuario.
     * @param local El local del que se desea obtener el comentario.
     * @param usuario El usuario que realiza el comentario.
     * @return Un comentario.
     */
    @Query("SELECT c FROM Comentario c WHERE c.local = ? AND c.usuario = ?")
    Comentario buscarComentario(Local local, Usuario usuario);
    
}
