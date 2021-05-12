/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banana.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.banana.entidades.Pregunta;
import mx.itson.banana.entidades.Usuario;
import mx.itson.banana.utilerias.HibernateUtils;
import org.hibernate.Session;

/**
 * Realiza las consultas a la base de datos correspondientes a la entidad de Usuario
 * @author adriana
 */
public class UsuarioDAO {
    
    /**
     * Añade un nuevo registro de Usuario a la base de datos según los parametros proporcionados
     * @param nombre nombre deregistro del Usuario
     * @param email correo electrónico del Usuario
     * @param nickname nombre de Usuario dentro de la aplicación
     * @param password contraseña del Usuario
     */
    public void Guardar(String nombre, String email, String nickname, String password){
        try{
            
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setNickname(nickname);
            usuario.setPassword(password);
            
            session.save(usuario);
            session.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("Error al guardar pregunta: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene todos los registros de Usuario existentes en la base de datos
     * @return lista de objetos de tipo Usuario
     */
    public static List<Usuario> obtenerTodos(){
    List<Usuario> usuarios = new ArrayList<>();
    try {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaQuery<Usuario> criteriaQuery = session.getCriteriaBuilder().createQuery(Usuario.class);
        criteriaQuery.from(Usuario.class);
        usuarios = session.createQuery(criteriaQuery).getResultList();
    }catch (Exception ex)
    {
        System.out.println("Error al generar lista de preguntas: "+ ex.getMessage());
    }
        
    return usuarios;
    
    }
}
