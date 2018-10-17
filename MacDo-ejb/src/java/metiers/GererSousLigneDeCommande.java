
package metiers;

import entites.SousLigneDeCommande;
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
    String rq = "select s from SousLigneDeCommande s";
    TypedQuery<SousLigneDeCommande> rqSsligne = em.createQuery(rq,SousLigneDeCommande.class);
    List<SousLigneDeCommande> sousLigne = rqSsligne.getResultList();
    return sousLigne;
}
}
