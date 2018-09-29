package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Statut implements Serializable {

    private static final long serialVersionUID = 1L;

//---------------------------------- Attributs ---------------------------------
    @Id
    private Long id;

    @Column(length = 255, nullable = true)
    private String description;

//------ gestion des associations ------
    @OneToMany(mappedBy = "statut")
    private Collection<Menu> menus;

    @OneToMany(mappedBy = "statut")
    private Collection<ItemARetire> itemAretires;

    @OneToMany(mappedBy = "statut")
    private Collection<Commande> commandes;

    @OneToMany(mappedBy = "statut")
    private Collection<Produit> produits;

    @OneToMany(mappedBy = "statut")
    private Collection<Ingredient> ingredients;

    @OneToMany(mappedBy = "statut")
    private Collection<Abonne> abonnes;

    @OneToMany(mappedBy = "statut")
    private Collection<Promotion> promotions;

    @OneToMany(mappedBy = "statut")
    private Collection<ItemARajoute> itemARajoutes;

//-------------------------------- Constructeurs -------------------------------
    public Statut() {
        menus = new ArrayList<>();
        itemAretires = new ArrayList<>();
        commandes = new ArrayList<>();
        produits = new ArrayList<>();
        ingredients = new ArrayList<>();
        abonnes = new ArrayList<>();
        promotions = new ArrayList<>();
        itemARajoutes = new ArrayList<>();
    }

    public Statut(Long id, String description) {
        this();
        this.id = id;
        this.description = description;
    }

//--------------------------------- Accesseurs ---------------------------------
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<ItemARetire> getItemAretires() {
        return itemAretires;
    }

    public void setItemAretires(Collection<ItemARetire> itemAretires) {
        this.itemAretires = itemAretires;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Collection<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Collection<ItemARajoute> getItemARajoutes() {
        return itemARajoutes;
    }

    public void setItemARajoutes(Collection<ItemARajoute> itemARajoutes) {
        this.itemARajoutes = itemARajoutes;
    }

//------------------------------ Autres Methodes -------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Statut{" + "id=" + id + ", description=" + description
                + ", menus=" + menus + ", itemAretires=" + itemAretires
                + ", commandes=" + commandes + ", produits=" + produits
                + ", ingredients=" + ingredients + '}';
    }

}
