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

    public void ChoixItemARajouter(String id, Produit pro);

    public void ChoixItemARetirer(String id, Produit pro);

    public List<ItemARetirer> ItemARetirerAAfficher(Long proId);

}
