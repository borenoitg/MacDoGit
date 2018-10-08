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
        TypedQuery<ItemARajouter> qr01 = em.createNamedQuery("entities.ItemARajouter.selectAll", ItemARajouter.class);
        List<ItemARajouter> list = qr01.getResultList();
        return list;
    }

    @Override
    public List<ItemARetirer> LesItemsARetirer() {
        TypedQuery<ItemARetirer> qr01 = em.createNamedQuery("entities.ItemARetirer.selectAll", ItemARetirer.class);
        List<ItemARetirer> list = qr01.getResultList();
        return list;
    }

    @Override
    public void ChoixItemARajouter(String id, Produit pro) {
        ItemARajouter item = new ItemARajouter();
        List<ItemARajouter> listItemARa = LesItemsARajouter();
        for (int i = 0; i < listItemARa.size(); i++) {
            if (listItemARa.get(i).getId().equals(Long.valueOf(id))) {
                item = listItemARa.get(i);
                pro.getItemARajoutes().add(item);
            }
        }
    }

    @Override
    public List<ItemARetirer> ItemARetirerAAfficher(String proId) {

        TypedQuery<Produit> qr02 = em.createNamedQuery("entities.Produit.selectProduit", Produit.class);
        qr02.setParameter("proNom", proId);
        Produit p = qr02.getSingleResult();
        List<ItemARetirer> list = (List) p.getItemARetires();
        System.out.println(p);
        System.out.println("c'est là que ça coince !!! " + list);
        return list;
    }

    @Override
    public void ChoixItemARetirer(String id, Produit pro) {
        ItemARetirer item = new ItemARetirer();

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
