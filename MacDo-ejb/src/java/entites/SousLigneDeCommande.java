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
    @ManyToOne
    private Commande commande;

    @OneToMany(mappedBy = "sousLigneDeCommande")
    private Collection<ItemARajoute> ItemARajoutes;

    @OneToMany(mappedBy = "sousLigneDeCommande")
    private Collection<ItemARetire> ItemARetires;

    @OneToMany(mappedBy = "sousLigneDeCommande")
    private Collection<Produit> produits;

    @ManyToOne
    private LigneDeCommande ligneCommande;

//-------------------------------- Constructeurs -------------------------------    
    public SousLigneDeCommande() {
        ItemARajoutes = new ArrayList<>();
        ItemARetires = new ArrayList<>();
        produits = new ArrayList<>();
    }

    public SousLigneDeCommande(Commande commande
            , Collection<ItemARajoute> ItemARajoutes
            , Collection<ItemARetire> ItemARetires
            , Collection<Produit> produits, LigneDeCommande ligneCommande) {
        this();
        this.commande = commande;
        this.ItemARajoutes = ItemARajoutes;
        this.ItemARetires = ItemARetires;
        this.produits = produits;
        this.ligneCommande = ligneCommande;
    }

//--------------------------------- Accesseurs ---------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Collection<ItemARajoute> getItemARajoutes() {
        return ItemARajoutes;
    }

    public void setItemARajoutes(Collection<ItemARajoute> ItemARajoutes) {
        this.ItemARajoutes = ItemARajoutes;
    }

    public Collection<ItemARetire> getItemARetires() {
        return ItemARetires;
    }

    public void setItemARetires(Collection<ItemARetire> ItemARetires) {
        this.ItemARetires = ItemARetires;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public LigneDeCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneDeCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
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
                + ", commande=" + commande 
                + ", ItemARajoutes=" + ItemARajoutes + ", ItemARetires=" 
                + ItemARetires + ", produits=" + produits + ", ligneCommande=" 
                + ligneCommande + '}';
    }

}
