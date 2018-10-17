package metiers;

import entites.Menu;
import entites.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GererMenu implements GererMenuLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public List<Produit> LesBoissons() {
        TypedQuery<Produit> qr01 = em.createNamedQuery("entities.Produit.selectBoissons", Produit.class);
        List<Produit> list = qr01.getResultList();
        return list;
    }

    @Override
    public List<Menu> LesMenus() {
        TypedQuery<Menu> qr01 = em.createNamedQuery("entities.Menu.selectAll", Menu.class);
        List<Menu> list = qr01.getResultList();
        return list;
    }

    @Override
    public List<Produit> LesAccompagnements(String taille) {
        TypedQuery<Produit> qr01 = em.createNamedQuery("entities.Produit.selectAccompagnements", Produit.class);
        qr01.setParameter("paramTaille", taille);
        List<Produit> list = qr01.getResultList();
        return list;
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
}
