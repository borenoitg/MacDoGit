package metiers;

import entites.Allergene;
import entites.Infos;
import entites.Ingredient;
import entites.ItemARajoute;
import entites.ItemARetire;
import entites.LigneDeCommande;
import entites.Menu;
import entites.Produit;
import entites.Promotion;
import entites.SousType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class CreationDeDonnees implements CreationDeDonneesLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public void creationDonnees() {
// ----------------------------------- Alexandre -------------------------------
        //Creation des objets
        Menu menuHappyMeal = new Menu("Menu HappyMeal", 5.50F);
        Menu menuBigMac = new Menu("Menu BigMac", 8.90f);
        Menu menuBigMacMaxi = new Menu("Menu BigMac Maxi Best Of", 8.00F);
        Menu menuSalade = new Menu("Menu Salade", 6.50F);
        Menu m05 = new Menu("Menu ChickenMcNuggets", 7.50F);
        Menu m06 = new Menu("Menu GrandChickenClassic", 7.30F);
        Menu m07 = new Menu("Menu GrandChickenClassic", 8.30F);
        Menu m08 = new Menu("Menu QuarterPounder", 8.00F);
        Menu m09 = new Menu("Menu QuarterPounder", 8.90F);

        Promotion p01 = new Promotion("2 Menus HappyMeal pour 6 Euros");
        Promotion p02 = new Promotion("2 Menus MaxiBestOf  pour 12 Euros");
        Promotion p03 = new Promotion("2 Menus HappyMeal pour 6 Euros");
        Promotion p04 = new Promotion("1 MacCafé pour 1 Euro pour tout menu acheté!");

        SousType st01 = new SousType("Coca Zero");
        SousType st02 = new SousType("Coca Cola");
        SousType st03 = new SousType("Sprite Zero");
        SousType st04 = new SousType("Evian");
        SousType st05 = new SousType("Badoit");
        SousType st06 = new SousType("Lipton Ice Tea");
        SousType st07 = new SousType("Minute Maid Orange");
        SousType st08 = new SousType("Fanta");
        SousType st09 = new SousType("Deluxe Potatoes");
        SousType st10 = new SousType("Frites");
        SousType st11 = new SousType("Crousties");
        SousType st12 = new SousType("Ketchup");
        SousType st13 = new SousType("Sauce Pomme-Frites");
        SousType st14 = new SousType("Sauce Creamy-Deluxe");
        SousType st15 = new SousType("Sauce Classic Moutarde");
        SousType st16 = new SousType("Sauce Curry");
        SousType st17 = new SousType("Sauce Chinoise");
        SousType st18 = new SousType("Sauce Classic Barbecue");
        SousType st19 = new SousType("Sauce Allégée");
        SousType st20 = new SousType("Sauce Vinaigrette Huile d'olive et Vinaigre Balsamique");
        SousType st21 = new SousType("Sauce Cesar");
        
        
        //Associations
        //Persist
        em.persist(menuHappyMeal);
        em.persist(menuBigMac);
        em.persist(menuBigMacMaxi);
// ----------------------------------- Momo ------------------------------------
        //Creation des objets
        //Associations
        //Persist
// -------------------------------- Thierry ------------------------------------
        // ************************ Creation des objets ************************
        // ********* Les ItemsARajoute *********
        ItemARajoute itemARajoute = new ItemARajoute("Cafe", 2F);
        // ********* Les Produits *********
        Produit produit = new Produit("Coca", 3F);
        // ********* Les LignesDeCommande *********
        LigneDeCommande ligneDeCommande = new LigneDeCommande(5.5F, 1, 6F);

        // ************************** Associations *****************************
//        itemARajoute.setSousLigneDeCommande(sousLigneDeCommande);
//        itemARajoute.setStatut(statut);
        itemARajoute.getProduits().add(produit);
        produit.getItemARajoutes().add(itemARajoute);

        //Persist
        em.persist(itemARajoute);
        em.persist(produit);
        em.persist(ligneDeCommande);

// ---------------------------------Nourdine------------------------------------
        //Creation des objets
        //Associations
        //Persist
// ----------------------------------- Edem ------------------------------------
        // ************************ Creation des objets ************************
        // ********* Les ItemsARetirer *********
        
        // ********* Les Allergenes *********
        
        // ********* Les ItemsARetirer *********
        ItemARetire itaeSteak = new ItemARetire("Steak", "En 2016, la viande bovine dans nos restaurants est d'origine française pour 54,51%*. Ainsi, nous avons utilisé plus de 25 078 tonnes de viande bovine française. Le volume restant provient d'Irlande et des Pays-Bas selon le même cahier des charges et les mêmes contrôles qu'en France. Nos fournisseurs s'approvisionnent uniquement auprès de fournisseurs référencés selon des critères très exigeants, et utilisent principalement des muscles issus de l'avant des bovins comme par exemple, l'épaule, le collier, le plat de côte");
        ItemARetire itaeFrommage = new ItemARetire("Frommage");
        ItemARetire itaeSalade = new ItemARetire("Salade", null);
        ItemARetire itaeOignon = new ItemARetire("Oignon", null);
        ItemARetire itaeCornichon = new ItemARetire("Cornichon", null);
        ItemARetire itaeTomate = new ItemARetire("Tomate", null);
        ItemARetire itaePoisson = new ItemARetire("Poisson", null);
        ItemARetire itaePoulet = new ItemARetire("Poulet", null);
        ItemARetire itaeBacon = new ItemARetire("Bacon", null);
        ItemARetire itaeCacahuètes = new ItemARetire("Cacahuètes", null);
        
        // ************************** Associations *****************************
        // ****************************** Persist ******************************
        em.persist(itaeSteak);
        em.persist(itaeFrommage);
        em.persist(itaeSalade);
        em.persist(itaeOignon);
        em.persist(itaeCornichon);
        em.persist(itaeTomate);
        em.persist(itaePoisson);
        em.persist(itaePoulet);
        em.persist(itaeCornichon);
        em.persist(itaeBacon);
        em.persist(itaeCacahuètes);
    }
}
