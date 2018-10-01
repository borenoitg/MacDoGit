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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Menu.selectAll", query = "SELECT m FROM Menu m")
})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //-------------------------------PROPRIETES DE MENU-------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(length = 20)
    private String taille;

    @Column(length = 150)
    private String imageUrl;

    @Column(length = 50, nullable = false)
    private Float prix;
    
    //---------------------------GESTION DES ASSOCIATIONS-----------------------
    @ManyToMany(mappedBy = "menus")
    private Collection<Type> types;
   
    @ManyToMany(mappedBy = "menus")
    private Collection<Abonne> abonnes;
   
    @OneToMany(mappedBy = "menu")
    private Collection<LigneDeCommande> lignesDeCommande;
   
    @ManyToOne
    private Tva tva;
    
    @ManyToOne  
    private Statut statut;
    
    //--------------------------- Constructeurs --------------------------------
    public Menu() {
        types = new ArrayList();
        abonnes = new ArrayList();
        lignesDeCommande = new ArrayList();
    }

    public Menu(String nom, Float prix) {
        this();
        this.nom = nom;
        this.prix = prix;
    }

    public Menu(String nom, String taille, String imageUrl, Float prix) {
        this();
        this.nom = nom;
        this.taille = taille;
        this.imageUrl = imageUrl;
        this.prix = prix;
    }

    //--------------------------- Accesseurs --------------------------------
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

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
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

    public Collection<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

    public void setLignesDeCommande(Collection<LigneDeCommande> lignesDeCommande) {
        this.lignesDeCommande = lignesDeCommande;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }
    
    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    //--------------------------- Autres Méthode -------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", nom=" + nom + ", taille=" + taille
                + ", imageUrl=" + imageUrl + ", prix=" + prix + '}';
    }

}
