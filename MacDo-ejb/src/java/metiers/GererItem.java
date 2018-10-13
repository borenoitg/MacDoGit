package metiers;

import entites.ItemARajouter;
import entites.ItemARetirer;
import entites.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GererItem implements GererItemLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public List<ItemARajouter> LesItemsARajouter() {
        TypedQuery<ItemARajouter> qr = em.createNamedQuery("entities.ItemARajouter.selectAll", ItemARajouter.class);
        List<ItemARajouter> list = qr.getResultList();
        return list;
    }

    @Override
    public List<ItemARetirer> LesItemsARetirer() {
        TypedQuery<ItemARetirer> qr = em.createNamedQuery("entities.ItemARetirer.selectAll", ItemARetirer.class);
        List<ItemARetirer> list = qr.getResultList();
        return list;
    }

    @Override
    public List<ItemARetirer> ItemARetirerAAfficher(Long proId) {

        TypedQuery<Produit> qr = em.createNamedQuery("entities.Produit.selectProduit", Produit.class);
        qr.setParameter("proId", proId);
        Produit p = qr.getSingleResult();
        List<ItemARetirer> list = (List) p.getItemARetires();

        return list;
    }

    @Override
    public Produit ProduitSelection(Long proId) {

        TypedQuery<Produit> qr = em.createNamedQuery("entities.Produit.selectProduit", Produit.class);
        qr.setParameter("proId", proId);
        Produit p = qr.getSingleResult();
        return p;
    }

    @Override
    public List<Produit> SaucesNugget() {

        TypedQuery<Produit> qr = em.createNamedQuery("entities.Produit.selectSauceNugget", Produit.class);
        List<Produit> list = qr.getResultList();

        return list;
    }
    
    
    @Override
    public List<Produit> SaucesSalade() {

        TypedQuery<Produit> qr = em.createNamedQuery("entities.Produit.selectSauceSalade", Produit.class);
        List<Produit> list = qr.getResultList();

        return list;
    }

    @Override
    public ItemARetirer SelectIItemARetirer(Long id) {

        TypedQuery<ItemARetirer> qr = em.createNamedQuery("entities.ItemARetirer.selectItemARetirer", ItemARetirer.class);
        qr.setParameter("itemId", id);
        ItemARetirer item = qr.getSingleResult();
        return item;
    }
 
    
    public void persist(Object object) {
        em.persist(object);
    }

}
