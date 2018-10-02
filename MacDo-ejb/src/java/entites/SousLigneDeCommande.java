package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SousLigneDeCommande implements Serializable {

    private static final long serialVersionUID = 1L;

//---------------------------------- Attributs ---------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //------ gestion des associations ------
    

    @ManyToOne()
    private ItemARajoute ItemARajoutes;

    @OneToMany(mappedBy = "sousLigneDeCommande")
    private Collection<ItemARetire> ItemARetires;

    @ManyToOne()
    private Produit produit;

    @ManyToOne
    private LigneDeCommande ligneCommande;

    
//-------------------------------- Constructeurs -------------------------------    
    public SousLigneDeCommande() {
        
        ItemARetires = new ArrayList<>();
        
    }

    public SousLigneDeCommande(Commande commande
            , Collection<ItemARajoute> ItemARajoutes
            , Collection<ItemARetire> ItemARetires
            , Collection<Produit> produits, LigneDeCommande ligneCommande) {
        this();
        this.ItemARetires = ItemARetires;
        
        this.ligneCommande = ligneCommande;
    }

    public SousLigneDeCommande(ItemARajoute ItemARajoutes, LigneDeCommande ligneCommande) {
        this();
        this.ItemARajoutes = ItemARajoutes;
        this.ligneCommande = ligneCommande;
    }

    public SousLigneDeCommande(ItemARajoute ItemARajoutes, Produit produits, LigneDeCommande ligneCommande) {
        this();
        this.ItemARajoutes = ItemARajoutes;
        this.produit = produits;
        this.ligneCommande = ligneCommande;
    }

//--------------------------------- Accesseurs ---------------------------------
    public Long getId() {
        return id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemARajoute getItemARajoutes() {
        return ItemARajoutes;
    }

    public void setItemARajoutes(ItemARajoute ItemARajoutes) {
        this.ItemARajoutes = ItemARajoutes;
    }


  

    public Collection<ItemARetire> getItemARetires() {
        return ItemARetires;
    }

    public void setItemARetires(Collection<ItemARetire> ItemARetires) {
        this.ItemARetires = ItemARetires;
    }

  

    public LigneDeCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneDeCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public Produit getProduits() {
        return produit;
    }

    public void setProduits(Produit produits) {
        this.produit = produits;
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
        if (!(object instanceof SousLigneDeCommande)) {
            return false;
        }
        SousLigneDeCommande other = (SousLigneDeCommande) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SousLigneDeCommande{" + "id=" + id 
               
                + ", ItemARajoutes=" + ItemARajoutes + ", ItemARetires=" 
                + ItemARetires + ", produits=" + produit + ", ligneCommande=" 
                + ligneCommande + '}';
    }

}
