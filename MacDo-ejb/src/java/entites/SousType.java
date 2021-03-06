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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
 
@Entity
@NamedQueries({
    @NamedQuery(name = "entities.SousType.selectAll", query = "SELECT s FROM SousType s"),
    
    @NamedQuery(name = "entities.SousType.selectSousTypeByType", query = "SELECT s FROM SousType s WHERE s.type.nom = :paramType")
})
public class SousType implements Serializable, Comparable<SousType> {

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

    @Override
    public int compareTo(SousType stp) {
        
        //Test: si les deux elements sont null, ils sont considérés comme egal
        if((this.nom == null)&&(stp.nom == null)){
            return 0;
        }
        
        //Test: si l'élément en cours est null
        else if(this.nom == null){
            return -1;
        }
        
        else if(stp.nom == null){
            return 1;
        }
        
        //Comparaison des deux produit et tri de ces derniers
        else {
            int monResultat = this.nom.compareTo(stp.nom);
            
            return monResultat;
        }
    }
}
