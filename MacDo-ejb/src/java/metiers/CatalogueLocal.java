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

    public List<Produit> listeProduitBySousType(String sousType);

    public List<SousType> listSousType();

    public List<Type> listType();

    public List<Statut> listStatut();

    public List<Menu> listMenu();

    public List<SousType> listSousTypeByType(String type);

    public List<Produit> listeProduitBySousType(String typeUn, String typeDeux);

    public List<Produit> listeProduitNouveaute(String statut);

    public List<Menu> gestionSideBarMenu();

    public List<SousType> gestionSideBarSousType(String nom);

    public List<Produit> gestionSideBar(String nom, String statut);

    public void persist(Object object);

    public Produit descriptionProduit(Long productId);
    
}
