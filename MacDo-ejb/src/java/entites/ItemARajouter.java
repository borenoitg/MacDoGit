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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.ItemARajouter.selectAll", query = "SELECT i FROM ItemARajouter i")
})
public class ItemARajouter implements Serializable {

    private static final long serialVersionUID = 1L;

    // propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nom;

    @Column(nullable = true)
    private Float prix;

    @Column(length = 150, nullable = true)
    private String imageUrl;

    // dépendances pour les associations
    @OneToMany(mappedBy = "ItemsARajouter")
    private Collection<SousLigneDeCommande> sousLigneDeCommandes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Produit> produits;

    @ManyToOne
    private Statut statut;

    // constructeurs
    public ItemARajouter() {
        sousLigneDeCommandes = new ArrayList<>();
        produits = new ArrayList<>();
    }

    public ItemARajouter(String nom) {
        this.nom = nom;
    }

    
    public ItemARajouter(String nom, Float prix) {
        this();
        this.nom = nom;
        this.prix = prix;
    }

    public ItemARajouter(String nom, String imageUrl) {
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public ItemARajouter(String nom, Float prix, String imageUrl) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
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

    public ItemARajouter(Collection<SousLigneDeCommande> sousLigneDeCommandes) {
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
        if (!(object instanceof ItemARajouter)) {
            return false;
        }
        ItemARajouter other = (ItemARajouter) object;
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
