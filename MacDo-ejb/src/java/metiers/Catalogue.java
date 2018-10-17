package metiers;

import entites.Menu;
import entites.Produit;
import entites.SousType;
import entites.Statut;
import entites.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class Catalogue implements CatalogueLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public List<Produit> listeProduit() {

        TypedQuery<Produit> qr01 = em.createNamedQuery("entities.Produit.selectAll", Produit.class);
        List<Produit> produits = qr01.getResultList();
        return produits;
    }

    @Override
    public List<Produit> listeDessert() {

        TypedQuery<Produit> qr01 = em.createNamedQuery("entities.Produit.selectDessert", Produit.class);
        List<Produit> produits = qr01.getResultList();
        return produits;
    }
    
  
    @Override
    public List<Produit> listeBurger() {

        TypedQuery<Produit> qr01 = em.createNamedQuery("entities.Produit.selectBurger", Produit.class);
        List<Produit> produits = qr01.getResultList();
        return produits;
    }
    
    /**
     * Permet de récupérer tous les statuts dans la BDD
     * @return une liste de tous les statuts
     */
    @Override
    public List<Statut> listStatut(){
        
        TypedQuery<Statut> query = em.createNamedQuery("entities.Statut.selectAll", Statut.class);
        List<Statut> statuts = query.getResultList();
        return statuts;
    }
    
    /**
     * Permet de récupérer tous les Types de la BDD
     * @return la liste des Types
     */
    @Override
    public List<Type> listType() {

        TypedQuery<Type> qr01 = em.createNamedQuery("entities.Type.selectAll", Type.class);
        List<Type> types = qr01.getResultList();
        return types;
    }
    
    /**
     * Permet de récupérer tous les sousTypes de la BDD
     * @return la liste des sousTypes
     */
    @Override
    public List<SousType> listSousType() {

        TypedQuery<SousType> qr01 = em.createNamedQuery("entities.SousType.selectAll", SousType.class);
        List<SousType> sousTypes = qr01.getResultList();
        return sousTypes;
    }

    /**
     * Permet de récupérer tous les menus de la bdd
     * @return Une liste de menu
     */
    @Override
    public List<Menu> listMenu(){
        
        TypedQuery<Menu> query = em.createNamedQuery("entities.Menu.selectAllMenus", Menu.class);
        List<Menu> menus = query.getResultList();
        return menus;
    }
    
    /**
     * Methode permettant de recupérer les produits d'un sousType donné
     * @param sousType
     * @return list de produit
     */
    @Override
    public List<Produit> listeProduitBySousType(String sousType){
        
        TypedQuery<Produit> queryProduitByType = em.createNamedQuery("entities.Produit.selectProduitBySousType", Produit.class);
        queryProduitByType.setParameter("paramType", sousType);
        List<Produit> produitsByType = queryProduitByType.getResultList();
        return produitsByType;
    }
    
    /**
     * Methode permettant de recupérer les produits de deux sousType donnés
     * @param sousTypeUn
     * @param sousTypeDeux
     * @return list de produit
     */
    @Override
    public List<Produit> listeProduitBySousType(String sousTypeUn, String sousTypeDeux){
        
        TypedQuery<Produit> query = em.createNamedQuery("entities.Produit.selectProduitBySousTypeFriteSauce", Produit.class);
        query.setParameter("paramTypeUn", sousTypeUn);
        query.setParameter("paramTypeDeux", sousTypeDeux);
        List<Produit> produitsByType = query.getResultList();
        
        return produitsByType;
    }
    
    /**
     * Methode permettant de recupérer les nouveaux produits
     * @param statut
     * @return list de produit
     */
    @Override
    public List<Produit> listeProduitNouveaute(String statut){
        
        TypedQuery<Produit> queryNouveauxProduits = em.createNamedQuery("entities.Produit.selectNouveauProduit", Produit.class);
        queryNouveauxProduits.setParameter("paramStatut", statut);
        List<Produit> NouveauxProduits = queryNouveauxProduits.getResultList();
        
        return NouveauxProduits;
    }
    
    /**
     * Permet de récupérer des soustypes d'un type donné 
     * @param type
     * @return une liste de sousType
     */
    @Override
    public List<SousType> listSousTypeByType(String type){
        
        TypedQuery<SousType> query = em.createNamedQuery("entities.SousType.selectSousTypeByType", SousType.class);
        query.setParameter("paramType", type);
        List<SousType> sousTypeByTypes = query.getResultList();
        return sousTypeByTypes;
    }
    
    /**
     * Permet de récupérer toutes les menus de la BDD
     * @return une liste de menu
     */
    @Override
    public List<Menu> gestionSideBarMenu(){
        List<Menu> menus = null;
        menus = this.listMenu();
        Collections.sort(menus);
        
        return menus;
    }
   
    /**
     * Permet de récupérer les sousType par type
     * @param nom 
     * @return une liste de sousType
     */
    @Override
    public List<SousType> gestionSideBarSousType(String nom){
        
        List<SousType> sousTypeByTypes = null;
        sousTypeByTypes = this.listSousTypeByType(nom);
        Collections.sort(sousTypeByTypes);
        
        return sousTypeByTypes;
    }
    
    /**
     * Permet de récupérer les produits, par sousType(s)
     * @param nom
     * @param detail
     * @return une liste de produits
     */
    @Override
    public List<Produit> gestionSideBar(String nom, String detail){
        List<Produit> produits = null;
        
        //Recupération et envoie des nouveautés
        if (nom.equalsIgnoreCase("Nouveaute")) {
            produits = this.listeProduitNouveaute(nom);
        }
        
        //Récupération et envoie des produits par sousType
        if ((nom.equalsIgnoreCase("Burger")) 
                || (nom.equalsIgnoreCase("Salade")) || (detail != null)) {
            
            if(detail != null){
                produits = this.listeProduitBySousType(detail);
            }
            else{
                produits = this.listeProduitBySousType(nom);
            }
        }
        
        //Récupération et envoie des sauces et frites
        else if (nom.equalsIgnoreCase("FriteSauce")) {
            
            String sousTypeUn = "Pommes de Terre";
            String sousTypeDeux = "Sauce";
            produits = this.listeProduitBySousType(sousTypeUn, sousTypeDeux);
        }
        
        //Tri de la list de produits
        Collections.sort(produits);
        
        return produits;
    }
    
    /**
     *
     * @param object
     */
    @Override
    public void persist(Object object) {
        em.persist(object);
    }
}
