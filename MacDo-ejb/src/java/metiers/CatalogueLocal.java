package metiers;

import entites.Menu;
import entites.Produit;
import entites.SousType;
import entites.Statut;
import entites.Type;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatalogueLocal {

    public List<Produit> listeProduit();

    public List<Produit> listeDessert();

    public List<Produit> listeBurger();

    public List<Produit> listeProduitNouveaute();

    public List<Produit> listeProduitBySousType(String sousType);

    public List<SousType> listSousType();

    public List<Type> listType();

    public List<Statut> listStatut();

    public List<Menu> listMenu();

    public List<SousType> listSousTypeByType(String type);

    public List<Produit> listeProduitBySousType(String typeUn, String typeDeux);
    
}
