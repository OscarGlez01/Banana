
package mx.itson.banana.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.banana.entidades.Categoria;
import mx.itson.banana.utilerias.HibernateUtils;
import org.hibernate.Session;

/**
 *
 * @author adriana
 */
public class CategoriaDAO {
    
    public static List<Categoria> obtenerTodas(){
    List<Categoria> categorias = new ArrayList<>();
    try {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaQuery<Categoria> criteriaQuery = session.getCriteriaBuilder().createQuery(Categoria.class);
        criteriaQuery.from(Categoria.class);
        categorias = session.createQuery(criteriaQuery).getResultList();
    }catch (Exception ex)
    {
        System.out.println("Error al generar lista de preguntas: "+ ex.getMessage());
    }
        
    return categorias;
    
    }
}
