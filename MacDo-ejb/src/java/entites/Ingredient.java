
package entites;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    
//---------------------------------- Attributs ---------------------------------    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nom;
    
    //------ gestion des associations ------
    @ManyToOne
    private Statut statut;
    
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Produit produit;
    
//-------------------------------- Constructeur --------------------------------    

    public Ingredient() {
    }
    
    public Ingredient(String nom) {
        this.nom = nom;
    }

    public Ingredient(String nom, Statut statut) {
        this.nom = nom;
        this.statut = statut;
    }

//--------------------------------- Accesseurs ---------------------------------
    public Long getId() {
        return id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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
        
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Ingredient[ id=" + id + " ]";
    }
    
}
