package metiers;

import entites.ItemARajouter;
import entites.ItemARetirer;
import entites.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GererItemLocal {

    public List<ItemARajouter> LesItemsARajouter();

    public List<ItemARetirer> LesItemsARetirer();

    public List<ItemARetirer> ItemARetirerAAfficher(Long proId);

    public List<Produit> SaucesNugget();

    public Produit ProduitSelection(Long proId);

    public ItemARetirer SelectIItemARetirer(Long id);

    public List<Produit> SaucesSalade();

    public ItemARajouter ItemARajouterSelection(Long id);

}
