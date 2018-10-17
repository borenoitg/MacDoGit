
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    
//---------------------------------- Attributs ---------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCommande;
    
    @Column
    private boolean paiementBorne;
    
    //------ gestion des associations ------
    @ManyToOne
    private Statut statut;
    
    
    
@OneToMany(mappedBy = "commande")
private Collection<LigneDeCommande> ligneDeCommandes;

//-------------------------------- Constructeur --------------------------------
    public Commande() {
       ligneDeCommandes = new ArrayList<LigneDeCommande>();
    }

    public Commande(Date dateCommande) {
        this();
        this.dateCommande = dateCommande;
    }

    public Commande(Date dateCommande, boolean paiementBorne) {
        this();
        this.dateCommande = dateCommande;
        this.paiementBorne = paiementBorne;
    }

//--------------------------------- Accesseurs ---------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean isPaiementBorne() {
        return paiementBorne;
    }

    public void setPaiementBorne(boolean paiementBorne) {
        this.paiementBorne = paiementBorne;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Collection<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(Collection<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
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
        
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", dateCommande=" + dateCommande 
                + ", paiementBorne=" + paiementBorne + '}';
    }

    
    
}
