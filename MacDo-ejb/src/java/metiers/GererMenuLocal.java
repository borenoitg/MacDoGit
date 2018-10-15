package metiers;

import entites.Menu;
import entites.Produit;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GererMenuLocal {

    public List<Produit> LesBoissons();

    public List<Menu> LesMenus();

    public List<Produit> LesAccompagnements(String taille);
    
}
