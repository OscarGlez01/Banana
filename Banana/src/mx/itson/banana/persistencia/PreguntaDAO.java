/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banana.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.banana.entidades.Categoria;
import mx.itson.banana.entidades.Pregunta;
import mx.itson.banana.entidades.Usuario;
import mx.itson.banana.utilerias.HibernateUtils;
import org.hibernate.Session;

/**
 *
 * @author adriana
 */
public class PreguntaDAO {
    
    /**
     * Obtiene todos los registros de preguntas existentes en la base de datos
     * @return lista de objetos de tipo pregunta
     */
    public static List<Pregunta> obtenerTodas(){
    List<Pregunta> preguntas = new ArrayList<>();
    try {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaQuery<Pregunta> criteriaQuery = session.getCriteriaBuilder().createQuery(Pregunta.class);
        criteriaQuery.from(Pregunta.class);
        preguntas = session.createQuery(criteriaQuery).getResultList();
    }catch (Exception ex)
    {
        System.out.println("Error al generar lista de preguntas: "+ ex.getMessage());
    }
        
    return preguntas;
    
    }
    
    /**
     * Añade un nuevo registro de pregunta
     */
    public void Guardar(Usuario usuario, Categoria categoria, String titulo){
        try{
            
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            
            Pregunta pregunta = new Pregunta();
            pregunta.setTitulo(titulo);
            pregunta.setUsuario(usuario);
            pregunta.setCategoria(categoria);
            //fecha actual
            pregunta.setFecha(new Date());
            
            session.save(pregunta);
            session.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("Error al guardar pregunta: " + e.getMessage());
        }
    }
}
