package pokemon.ejemplo.crudexamen.Models;

import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DatabaseManager {

    public static EntityManagerFactory managerFactory =
            Persistence.createEntityManagerFactory("Persistencia");

    public static Granjero comprobarLogin(String correo, String password){
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        TypedQuery<Granjero> query =
                manager.createQuery("FROM Granjero WHERE email= :email AND password= :password", Granjero.class);
        query.setParameter("email", correo);
        query.setParameter("password", password);

        List<Granjero> granjeros = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return granjeros.getFirst();
    }

    public static List<Animal> obtenerAnimalesSolos(){
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        TypedQuery<Animal> query =
                manager.createQuery("FROM Animal animal WHERE animal.granjeros IS EMPTY", Animal.class);

        List<Animal> animales = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return animales;
    }

    public static void actualizarSaldo(Granjero granjero){
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        manager.merge(granjero);

        manager.getTransaction().commit();
        manager.close();
    }

    public static void comprarAnimal(Granjero granjero){
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        manager.merge(granjero);

        manager.getTransaction().commit();
        manager.close();
    }
}
