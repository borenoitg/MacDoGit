package essais;

import entites.Allergene;
import entites.Infos;
import entites.Ingredient;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class essais {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("MacDo-ejbPU");
        EntityManager em = emf.createEntityManager();

// ----------------------------------- Alexandre -------------------------------
        //Creation des objets
        
        //Associations
    
        //Persist
    
// ----------------------------------- Momo ------------------------------------
        //Creation des objets
    
        //Associations
    
        //Persist
    
// -------------------------------- Thierry ------------------------------------
        //Creation des objets
        
        //Associations
        
        //Persist
        
// ---------------------------------Nourdine------------------------------------
        //Creation des objets
    
        //Associations
    
        //Persist
    
// ----------------------------------- Edem ------------------------------------
        //Creation des objets
        // ********* Les Ingredients *********
        Ingredient ingredientPain = new Ingredient("Pain");
        Allergene allergeneSoja = new Allergene("Soja");
        Infos infosCoca = new Infos("Le coca est Bon");
        //Associations
        
        //Persist
        em.persist(ingredientPain);
        em.persist(allergeneSoja);
        em.persist(infosCoca);
//------------------------------ Transactions ----------------------------------
        EntityTransaction et = em.getTransaction();

        et.begin();
        et.commit();

        em.close();
        emf.close();
    }
}
