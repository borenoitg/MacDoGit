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
    private ItemARajouter ItemsARajouter;

    @OneToMany(mappedBy = "sousLigneDeCommande")
    private Collection<ItemARetirer> ItemsARetirer;

    @ManyToOne()
    private Produit produit;

    @ManyToOne
    private LigneDeCommande ligneCommande;

    
//-------------------------------- Constructeurs -------------------------------    
    public SousLigneDeCommande() {
        
        ItemsARetirer = new ArrayList<>();
        
    }

    public SousLigneDeCommande(Commande commande
            , Collection<ItemARajouter> ItemARajoutes
            , Collection<ItemARetirer> ItemsARetirer
            , Collection<Produit> produits, LigneDeCommande ligneCommande) {
        this();
        this.ItemsARetirer = ItemsARetirer;
        
        this.ligneCommande = ligneCommande;
    }

    public SousLigneDeCommande(ItemARajouter ItemARajoutes, LigneDeCommande ligneCommande) {
        this();
        this.ItemsARajouter = ItemARajoutes;
        this.ligneCommande = ligneCommande;
    }

    public SousLigneDeCommande(ItemARajouter ItemARajoutes, Produit produits, LigneDeCommande ligneCommande) {
        this();
        this.ItemsARajouter = ItemARajoutes;
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

    public ItemARajouter getItemsARajouter() {
        return ItemsARajouter;
    }

    public void setItemsARajouter(ItemARajouter ItemsARajouter) {
        this.ItemsARajouter = ItemsARajouter;
    }


  

    public Collection<ItemARetirer> getItemsARetirer() {
        return ItemsARetirer;
    }

    public void setItemsARetirer(Collection<ItemARetirer> ItemsARetirer) {
        this.ItemsARetirer = ItemsARetirer;
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
               
                + ", ItemARajoutes=" + ItemsARajouter + ", ItemsARetirer=" 
                + ItemsARetirer + ", produits=" + produit + ", ligneCommande=" 
                + ligneCommande + '}';
    }

}
