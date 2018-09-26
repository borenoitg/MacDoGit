package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne
    private SousLigneDeCommande sousLigneDeCommande;
    
    @ManyToMany 
    private Collection<Produit> produits;
    
    @ManyToOne
    private Statut statut;
    
    // constructeurs
    public ItemARajoute() {
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

    public SousLigneDeCommande getSousLigneDeCommande() {
        return sousLigneDeCommande;
    }

    public void setSousLigneDeCommande(SousLigneDeCommande sousLigneDeCommande) {
        this.sousLigneDeCommande = sousLigneDeCommande;
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
        return "ItemARajoute{" + "nom=" + nom + ", prix=" + prix + ", sousLigneDeCommande=" + sousLigneDeCommande + ", statut=" + statut + '}';
    }


}
