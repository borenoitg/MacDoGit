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
import javax.persistence.OneToMany;

@Entity
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------PROP¨RIETES DE PROMOTION----------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nom;

    @Column(length = 150)
    private String description;

    @Column(length = 150)
    private String imageUrl;

    //---------------GESTION DES ASSOCIATIONS----------------------------------
    @ManyToMany(mappedBy = "promotions")
    private Collection<Type> types;
    
    @ManyToMany(mappedBy = "promotions")
    private Collection<Abonne> abonnes;
    
    @OneToMany(mappedBy = "promotion")
    private Collection<Produit> produits;
    
    @ManyToOne
    private Statut statut;

    //--------------------CONSTRUCTORS------------------------------------------
    public Promotion() {
        types = new ArrayList();
        abonnes = new ArrayList();
        produits = new ArrayList();
    }

    public Promotion(String nom) {
        this();
        this.nom = nom;
    }
    
    public Promotion(String nom, String description, String imageUrl) {
        this();
        this.nom = nom;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    //-------------------------ACCESSEURS---------------------------------------
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Type> getTypes() {
        return types;
    }

    public void setTypes(Collection<Type> types) {
        this.types = types;
    }

    public Collection<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Collection<Abonne> abonnes) {
        this.abonnes = abonnes;
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

    //--------------------------- Autres Methodes ------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", nom=" + nom + ", description="
                + description + ", imageUrl=" + imageUrl + '}';
    }

}
