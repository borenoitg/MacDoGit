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
    @NamedQuery(name = "entities.Produit.selectProduitBySousType", query = "SELECT p FROM Produit p WHERE p.soustype.nom= :paramType")
    ,
    @NamedQuery(name = "entities.Produit.selectProduitBySousTypeFriteSauce", query = "SELECT p FROM Produit p WHERE p.soustype.nom= :paramTypeUn OR p.soustype.nom= :paramTypeDeux")
    ,
    @NamedQuery(name = "entities.Produit.selectNouveauProduit", query = "SELECT p FROM Produit p WHERE p.statut.description = :paramStatut")
    ,
    @NamedQuery(name = "entities.Produit.selectAll", query = "SELECT p FROM Produit p")
    ,
    @NamedQuery(name = "entities.Produit.selectDessert", query = "SELECT p FROM Produit p where p.soustype.type.nom ='Dessert' order by p.soustype.nom asc ")
    ,
    @NamedQuery(name = "entities.Produit.selectBurger", query = "SELECT p FROM Produit p where p.soustype.nom ='Burger' order by p.soustype.nom asc ")
    ,
    @NamedQuery(name = "entities.Produit.selectSauceNugget", query = "SELECT p FROM Produit p where p.soustype.nom ='Sauce' AND p.description = 'nuggets' ")
    ,
    @NamedQuery(name = "entities.Produit.selectProduit", query = "SELECT p FROM Produit p where p.id= :proId")
    ,
    @NamedQuery(name = "entities.Produit.selectSauceSalade", query = "SELECT p FROM Produit p where p.description = 'sauce salade'")
    ,
    @NamedQuery(name = "entities.Produit.selectBoissons", query = "SELECT p FROM Produit p where p.soustype.nom ='Chaude'")
})
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

    @ManyToOne
    private Tva tva;

    @OneToMany(mappedBy = "produit")
    private Collection<Ingredient> ingredients;

    @ManyToMany(mappedBy = "produits")
    private Collection<Allergene> allergenes;

    @ManyToOne
    private Statut statut;

    @ManyToMany(mappedBy = "produits")
    private Collection<Infos> infos;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SousType soustype;

    @OneToMany(mappedBy = "produit")
    private Collection<LigneDeCommande> lignesDeCommande;

    @OneToMany(mappedBy = "produit")
    private Collection<SousLigneDeCommande> sousLigneDeCommandes;

    @ManyToMany(mappedBy = "produits")
    private Collection<ItemARajouter> itemsARajouter;

    @ManyToMany(mappedBy = "produits")
    private Collection<ItemARetirer> itemsARetirer;

    @ManyToMany(mappedBy = "produits")
    private Collection<Abonne> abonnes;

    // Constructeurs
    public Produit() {
        ingredients = new ArrayList();
        allergenes = new ArrayList();
        infos = new ArrayList();
        lignesDeCommande = new ArrayList();
        sousLigneDeCommandes = new ArrayList();
        itemsARajouter = new ArrayList();
        itemsARetirer = new ArrayList();
        abonnes = new ArrayList();
    }

    public Produit(String nom, Float prix, String taille, String imageUrl) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
        this.imageUrl = imageUrl;
    }

    public Produit(String nom) {
        this();
        this.nom = nom;
    }

    public Produit(String nom, String imageUrl) {
        this();
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public Produit(String nom, Float prix) {
        this();
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, Float prix, String imageUrl) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
    }

    public Produit(String nom, Float prix, String description,
            String taille, int volume, String imageUrl) {
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

    public void setLignesDeCommande(Collection<LigneDeCommande> lignesDeCommande) {
        this.lignesDeCommande = lignesDeCommande;
    }

    public void setItemARajoutes(Collection<ItemARajouter> itemARajoutes) {
        this.itemsARajouter = itemARajoutes;
    }

    public void setItemARetires(Collection<ItemARetirer> itemARetires) {
        this.itemsARetirer = itemARetires;
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

    public Collection<ItemARajouter> getItemsARajouter() {
        return itemsARajouter;
    }

    public void setItemsARajouter(Collection<ItemARajouter> itemsARajouter) {
        this.itemsARajouter = itemsARajouter;
    }

    public Collection<ItemARetirer> getItemsARetirer() {
        return itemsARetirer;
    }

    public void setItemsARetirer(Collection<ItemARetirer> itemsARetirer) {
        this.itemsARetirer = itemsARetirer;
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

    public Collection<SousLigneDeCommande> getSousLigneDeCommandes() {
        return sousLigneDeCommandes;
    }

    public void setSousLigneDeCommandes(Collection<SousLigneDeCommande> sousLigneDeCommandes) {
        this.sousLigneDeCommandes = sousLigneDeCommandes;
    }

    public Collection<ItemARajouter> getItemARajoutes() {
        return itemsARajouter;
    }

    public void setItemRajoutes(Collection<ItemARajouter> itemARajoutes) {
        this.itemsARajouter = itemARajoutes;
    }

    public Collection<ItemARetirer> getItemARetires() {
        return itemsARetirer;
    }

    public void setItemRetires(Collection<ItemARetirer> itemARetires) {
        this.itemsARetirer = itemARetires;
    }

    public Collection<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Collection<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
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
                + ", promo=" + promotion + ", tva=" + tva + ", ingredients="
                + ingredients + ", allergenes=" + allergenes + ", statut="
                + statut + ", infos=" + infos + ", soustype=" + soustype + '}';
    }

}
