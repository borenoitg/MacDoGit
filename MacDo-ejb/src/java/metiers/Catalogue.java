package metiers;

import entites.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class Catalogue implements CatalogueLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public List<Produit> listeProduit() {

        TypedQuery<Produit> qr01 = em.createNamedQuery("entites.Produit.liste", Produit.class);
        List<Produit> produits = qr01.getResultList();
        return produits;
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
