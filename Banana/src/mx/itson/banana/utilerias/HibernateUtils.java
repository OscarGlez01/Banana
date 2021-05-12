package mx.itson.banana.utilerias;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author adriana
 * Implementa los métodos básicos para la creación y administración de la conexión a la base de datos con Hibernate.
 */
public class HibernateUtils {

    private static SessionFactory factory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            factory = configuration.buildSessionFactory();
        } catch (HibernateException ex) {
            System.out.println("No se pudo crear la sesión de Hibernate. " + ex);
        }
    }

    /**
     * Obtiene la sesión activa de Hibernate.
     * @return Sesión activa de Hibernate en objeto de tipo SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return factory;
    }

    /**
     * Asigna la sesión activa de Hibernate.
     * @param factory Sesión activa de Hibernate.
     */
    public static void setSessionFactory(SessionFactory factory) {
        HibernateUtils.factory = factory;
    }
}


