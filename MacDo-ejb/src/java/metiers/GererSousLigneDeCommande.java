
package metiers;

import entites.Commande;
import entites.LigneDeCommande;
import entites.SousLigneDeCommande;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateful
public class GererSousLigneDeCommande implements GererSousLigneDeCommandeLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

 
    @Override
    public List<SousLigneDeCommande> listSsLigne(){
    String nom = "En cours";
    String rq = "select s from SousLigneDeCommande s where s.statut like :param";
    TypedQuery<SousLigneDeCommande> rqSsligne = em.createQuery(rq,SousLigneDeCommande.class);
    rqSsligne.setParameter("param",nom+"%");
    List<SousLigneDeCommande> sousLigne = rqSsligne.getResultList();
    return sousLigne;
}
    @Override
    public void listSsLigne(long id){
    SousLigneDeCommande s = em.find(SousLigneDeCommande.class,id);
    s.setStatut("valide");
    
}
    
    @Override
    public void creationSsLigne(ArrayList<LigneDeCommande> ligne,Commande com){
        em.persist(com);
        for(LigneDeCommande l : ligne){
            
            l.setCommande(com);
            SousLigneDeCommande ssL = new SousLigneDeCommande("En cours de préparation",l.getProduit(),l);
            ssL.setItemsARetirer(l.getProduit().getItemARetires());
            
            em.persist(l);
            em.persist(ssL);
        }
       
    }
}
