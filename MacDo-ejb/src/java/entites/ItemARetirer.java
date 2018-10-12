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

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.ItemARetirer.selectAll", query = "SELECT i FROM ItemARetirer i ORDER BY i.description ASC")
    ,
    @NamedQuery(name = "entities.ItemARetirer.selectItemARetirer", query = "SELECT i FROM ItemARetirer i where i.id = :proId")})
public class ItemARetirer implements Serializable {

    private static final long serialVersionUID = 1L;

//---------------------------------- Attributs ---------------------------------    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 1000)
    private String description;

    @Column(length = 150, nullable = true)
    private String imageUrl;

    //------ gestion des associations ------
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SousLigneDeCommande sousLigneDeCommande;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Statut statut;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Produit> produits;

//-------------------------------- Constructeur --------------------------------
    public ItemARetirer() {
        produits = new ArrayList<>();
    }

    public ItemARetirer(String nom) {
        this();
        this.nom = nom;
    }

    public ItemARetirer(String nom, String imageUrl) {
        this();
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public ItemARetirer(String nom, String description, String imageUrl) {
        this();
        this.nom = nom;
        this.description = description;
        this.imageUrl = imageUrl;
    }

//--------------------------------- Accesseurs ---------------------------------
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
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
        if (!(object instanceof ItemARetirer)) {
            return false;
        }
        ItemARetirer other = (ItemARetirer) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ItemARetire[ id=" + id + " ]";
    }
}
