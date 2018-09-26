package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SousType implements Serializable {

    private static final long serialVersionUID = 1L;

//----------------------PROPRIETES DE SOUS-TYPE---------------------------------    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String nom;

    @Column(length = 150)
    private String imageUrl;

//--------------------------GESTION DES ASSOCIATIONS----------------------------  
    @OneToMany(mappedBy = "soustype")
    private Collection<Produit> produits;

    @ManyToOne
    private Type type;

//-----------------CONSTRUCTORS-------------------------------------------------
    public SousType() {
        produits = new ArrayList<>();
    }

    public SousType(String nom) {
        this.nom = nom;
    }

    public SousType(String nom, String imageUrl) {
        this();
        this.nom = nom;
        this.imageUrl = imageUrl;
    }
    
//----------------------ACCESSEURS----------------------------------------------    
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        if (!(object instanceof SousType)) {
            return false;
        }
        SousType other = (SousType) object;
        if ((this.id == null && other.id != null) || (this.id != null 
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SousType{" + "id=" + id + ", nom=" + nom 
                + ", imageUrl=" + imageUrl + '}';
    }

}
