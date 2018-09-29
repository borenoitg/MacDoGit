
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
import javax.persistence.OneToMany;



@Entity
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //--------------PROPRIETES DE TYPE------------------------------------------
    @Column(length = 150, nullable = false)
    private String nom;

    @Column(length = 150)
    private String imageUrl;
    
    //----------------------GESTION DES ASSOCIATIONS----------------------------
    
    @ManyToMany(mappedBy = "types")
    private Collection <Abonne> abonnes;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection <Menu> menus;
    
    @OneToMany(mappedBy = "type")
    private Collection <SousType> sousTypes;
        
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Promotion> promotions;
    
    //-------------------CONSTRUCTEURS------------------------------------------
    public Type() {
        abonnes = new ArrayList<>();
        sousTypes = new ArrayList<>();
        menus = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    public Type(String nom, String imageUrl) {
        this();
        this.nom = nom;
        this.imageUrl = imageUrl;
    }
    
    public Type(String nom) {
        this();
        this.nom = nom;
    }
//----------------------------ACCESSEURS----------------------------------------

    
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Collection<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<SousType> getSousTypes() {
        return sousTypes;
    }

    public void setSousTypes(Collection<SousType> sousTypes) {
        this.sousTypes = sousTypes;
    }

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }
    
//----------------------------------- Autres Methodes --------------------------    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", nom=" + nom + ", imageUrl=" + imageUrl + '}';
    }
   
}
