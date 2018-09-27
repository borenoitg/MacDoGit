package metiers;

import entites.Produit;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatalogueLocal {

    public List<Produit> listeProduit();
    
}
