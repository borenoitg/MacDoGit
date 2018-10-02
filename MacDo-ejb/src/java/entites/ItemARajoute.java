package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemARajoute implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nom;

    @Column(nullable = false)
    private Float prix;

    @Column(length = 150, nullable = true)
    private String imageUrl;

    // dépendances pour les associations
    
    @OneToMany(mappedBy = "ItemARajoutes")
    private Collection<SousLigneDeCommande> sousLigneDeCommandes;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Collection<Produit> produits;
    
    @ManyToOne
    private Statut statut;
    
    // constructeurs
    public ItemARajoute() {
        sousLigneDeCommandes = new ArrayList<>();
        produits = new ArrayList<>();
    }

    public ItemARajoute(String nom, Float prix) {
        this();
        this.nom = nom;
        this.prix = prix;
    }
    
    // getters et setters
    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ItemARajoute(Collection<SousLigneDeCommande> sousLigneDeCommandes) {
        this.sousLigneDeCommandes = sousLigneDeCommandes;
    }

   

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Collection<SousLigneDeCommande> getSousLigneDeCommandes() {
        return sousLigneDeCommandes;
    }

    public void setSousLigneDeCommandes(Collection<SousLigneDeCommande> sousLigneDeCommandes) {
        this.sousLigneDeCommandes = sousLigneDeCommandes;
    }

    // Autres Methodes
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ItemARajoute)) {
            return false;
        }
        ItemARajoute other = (ItemARajoute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemARajoute{" + "nom=" + nom + ", prix=" + prix + ", statut=" + statut + '}';
    }


}
