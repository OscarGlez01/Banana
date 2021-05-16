
package mx.itson.banana.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.banana.entidades.Respuesta;
import mx.itson.banana.utilerias.HibernateUtils;
import org.hibernate.Session;

/**
 *
 * @author 
 */
public class RespuestaDAO {
    /**
     * Obtiene todos los registros de preguntas existentes en la base de datos
     * @return lista de objetos de tipo respuesta
     */
    public static List<Respuesta> obtenerTodas(){
    List<Respuesta> preguntas = new ArrayList<>();
    try {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaQuery<Respuesta> criteriaQuery = session.getCriteriaBuilder().createQuery(Respuesta.class);
        criteriaQuery.from(Respuesta.class);
        preguntas = session.createQuery(criteriaQuery).getResultList();
    }catch (Exception ex)
    {
        System.out.println("Error al generar lista de respuestas: "+ ex.getMessage());
    }
        
    return preguntas;
    
    }
}
