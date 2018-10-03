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
public class LigneDeCommande implements Serializable {

    private static final long serialVersionUID = 1L;

    // propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float tva;

    @Column(nullable = false)
    private int quantite;

    @Column(nullable = false)
    private Float prix;

    // dépendances pour les associations
    @ManyToOne
    private Menu menu;

    @ManyToOne
    private Produit produit;

    @OneToMany(mappedBy = "ligneCommande")
    private Collection<SousLigneDeCommande> sousLignesDeCommande;

    // Constructeurs
    public LigneDeCommande() {
        sousLignesDeCommande = new ArrayList<>();
    }

    public LigneDeCommande(Float tva, int quantite, Float prix) {
        this();
        this.tva = tva;
        this.quantite = quantite;
        this.prix = prix;
    }

    // getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTva() {
        return tva;
    }

    public void setTva(Float tva) {
        this.tva = tva;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Collection<SousLigneDeCommande> getSousLignesDeCommande() {
        return sousLignesDeCommande;
    }

    public void setSousLignesDeCommande(Collection<SousLigneDeCommande> sousLignesDeCommande) {
        this.sousLignesDeCommande = sousLignesDeCommande;
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
        if (!(object instanceof LigneDeCommande)) {
            return false;
        }
        LigneDeCommande other = (LigneDeCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LigneDeCommande{" + "tva=" + tva + ", quantite=" + quantite
                + ", prix=" + prix + ", sousLignesDeCommande="
                + sousLignesDeCommande + '}';
    }

}
