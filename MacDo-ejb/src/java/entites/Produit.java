package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nom;

    private Float prix;

    @Column(length = 1000, nullable = true)
    private String description;

    @Column(length = 100)
    private String taille;

    private int volume;

    @Column(length = 150, nullable = true)
    private String imageUrl;

    // dépendances pour les associations
    @ManyToOne
    private Promotion promotion;

    @ManyToMany(mappedBy = "produits")
    private Collection<Tva> tvas;

    @OneToMany(mappedBy = "produit")
    private Collection<Ingredient> ingredients;

    @ManyToMany(mappedBy = "produits")
    private Collection<Allergene> allergenes;

    @ManyToOne
    private Statut statut;

    @ManyToMany(mappedBy = "produits")
    private Collection<Infos> infos;

    @ManyToOne
    private SousType soustype;

    @OneToMany(mappedBy = "produit")              // pas obligatoire ...
    private Collection<LigneDeCommande> lignesDeCommande;

    @ManyToOne
    private SousLigneDeCommande sousLigneDeCommande;

    @ManyToMany(mappedBy = "produits")
    private Collection<ItemARajoute> itemARajoutes;

    @ManyToMany(mappedBy = "produits")
    private Collection<ItemARetire> itemARetires;

    @ManyToMany(mappedBy = "produits")
    private Collection<Abonne> abonnes;

    // Constructeurs

    public Produit() {
        ingredients = new ArrayList();
        allergenes = new ArrayList();
        infos = new ArrayList();
        lignesDeCommande = new ArrayList();
        itemARajoutes = new ArrayList();
        itemARetires = new ArrayList();
        abonnes = new ArrayList();
        tvas = new ArrayList();
    }

    public Produit(String nom) {
        this();
        this.nom = nom;
    }

    public Produit(String nom, Float prix) {
        this();
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, Float prix, String description) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    public Produit(String nom, Float prix, String description
            , String taille, int volume, String imageUrl) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.taille = taille;
        this.volume = volume;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(Collection<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Collection<Infos> getInfos() {
        return infos;
    }

    public void setInfos(Collection<Infos> infos) {
        this.infos = infos;
    }

    public SousType getSoustype() {
        return soustype;
    }

    public void setSoustype(SousType soustype) {
        this.soustype = soustype;
    }

    public Collection<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

    public void setLignesDeCommandes(Collection<LigneDeCommande> lignesDeCommande) {
        this.lignesDeCommande = lignesDeCommande;
    }

    public SousLigneDeCommande getSousLigneDeCommande() {
        return sousLigneDeCommande;
    }

    public void setSousLigneDeCommande(SousLigneDeCommande sousLigneDeCommande) {
        this.sousLigneDeCommande = sousLigneDeCommande;
    }

    public Collection<ItemARajoute> getItemARajoutes() {
        return itemARajoutes;
    }

    public void setItemRajoutes(Collection<ItemARajoute> itemARajoutes) {
        this.itemARajoutes = itemARajoutes;
    }

    public Collection<ItemARetire> getItemARetires() {
        return itemARetires;
    }

    public void setItemRetires(Collection<ItemARetire> itemARetires) {
        this.itemARetires = itemARetires;
    }

    public Collection<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Collection<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    public Collection<Tva> getTvas() {
        return tvas;
    }

    public void setTvas(Collection<Tva> tvas) {
        this.tvas = tvas;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id 
                != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

        
        
    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" 
                + prix + ", description=" + description + ", taille=" 
                + taille + ", volume=" + volume + ", imageUrl=" + imageUrl 
                + ", promo=" + promotion + ", tva=" + tvas + ", ingredients=" 
                + ingredients + ", allergenes=" + allergenes + ", statut=" 
                + statut + ", infos=" + infos + ", soustype=" + soustype + '}';
    }
}
