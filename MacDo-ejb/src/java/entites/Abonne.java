
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Abonne implements Serializable {
    private static final long serialVersionUID = 1L;
    
//---------------------------------- Attributs ---------------------------------    
    @Id
    @Column(length = 100)
    private String id;
    
    @Column(length = 150,nullable = false)
    private String nom;
    
    private int points;
    
    @Column(length = 150,nullable = false)
    private String prenom;
    
    @Column(nullable = false,unique = true)
    private String email;
    
    //------ gestion des associations ------
    
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Statut statut;
    
    @ManyToMany
    private Collection<Menu> menus;
    
    @ManyToMany
    private Collection<Type> types;
    
    @ManyToMany
    private Collection<Produit> produits;

    @ManyToMany
    private Collection<Promotion> promotions;
    
//-------------------------------- Constructeurs -------------------------------
    public Abonne() {
        menus = new ArrayList<>(); 
        types = new ArrayList<>();
        produits = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    public Abonne(String id, String nom, int points, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.points = points;
        this.prenom = prenom;
        this.email = email;
    }
    
   
    public Abonne(String id, String nom, String prenom, String email) {
        this();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Abonne(String nom, int points, String prenom, String email) {
        this.nom = nom;
        this.points = points;
        this.prenom = prenom;
        this.email = email;
    }

//--------------------------------- Accesseurs ---------------------------------    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<Type> getTypes() {
        return types;
    }

    public void setTypes(Collection<Type> types) {
        this.types = types;
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

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
        if (!(object instanceof Abonne)) {
            return false;
        }
        Abonne other = (Abonne) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Abonne{" + "id=" + id + ", nom=" + nom 
                + ", prenom=" + prenom + ", email=" + email + '}';
    }
}
