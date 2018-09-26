package metiers;

import entites.Allergene;
import entites.Infos;
import entites.Ingredient;
import static entites.Ingredient_.produit;
import entites.ItemARajoute;
import entites.ItemARetire;
import entites.LigneDeCommande;
import entites.Menu;
import entites.Produit;
import entites.Promotion;
import entites.SousType;
import entites.Tva;
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
        // ********* Les Produits *********
        Produit proLeTheRouge = new Produit("THÉ FRUITS ROUGES GRAND FORMAT", 2.70F);
        Produit proLeTheVertGrand = new Produit("THÉ VERT A LA MENTHE GRAND FORMAT", 2.70F);
        Produit proLeTheVert = new Produit("THÉ VERT A LA MENTHE", 2.20F);
        Produit proLeTheGrey = new Produit("THÉ EARL GREY", 2.20F);
        Produit proLeTheGreyGrand = new Produit("THÉ EARL GREY GRAND FORMAT", 2.70F);
        //******************
        Produit proGrandCafe = new Produit("GRAND CAFE", 2F);
        Produit proGrandCafeGrand = new Produit("GRAND CAFE GRAND FORMAT", 2.5F);
        //******************
        Produit proCappuccino = new Produit("CAPPUCCINO", 2.40F);
        Produit proCappuccinoGrand = new Produit("CAPPUCCINO GRAND FORMAT", 2.90F);
        //******************
        Produit proCappuccinoDaim = new Produit("CAPPUCCINO DAIM", 2.50F);
        Produit proCappuccinDaimoGrand = new Produit("CAPPUCCINO DAIM GRAND FORMAT", 3F);
        //******************
        Produit proDoubleLatte = new Produit("DOUBLE LATTE", 2.30F);
        Produit proproDoubleLatteGrand = new Produit("DOUBLE LATTE GRAND FORMAT", 2.80F);
        //******************
        Produit proLatteMacchiato = new Produit("LATTE MACCHIATO SAVEUR CHOCOLAT", 2.5F);
        Produit proExpresso = new Produit("EXPRESSO", 1.5F);
        Produit proNoisette = new Produit("NOISETTE", 1.70F);
        Produit proRISTRETTO = new Produit("RISTRETTO", 1.50F);
        Produit proChocolatChaud = new Produit("CHOCOLAT CHAUD", 2.20F);
        //******************
        Produit proGrandesCrousties = new Produit("GRANDES CROUSTIES", 2.90F);
        Produit proMoyenneCrousties = new Produit("MOYENNE CROUSTIES", 2.5F);
        Produit proMoyenneFrite = new Produit("MOYENNE FRITE", 2.90F);
        Produit proGrandeFrite = new Produit("GRANDE FRITE", 2.5F);
        Produit proPetiteFrite = new Produit("PETITE FRITE", 1.95F);
        //******************
        Produit proSauceBarbecue = new Produit("SAUCE CLASSIC BARBECUE", 0.20F);
        Produit proSauceChinoise = new Produit("SAUCE CHINOISE", 0.20F);
        Produit proSauceCurry = new Produit("SAUCE CURRY", 0.20F);
        Produit proVinaigretteAHuile = new Produit("VINAIGRETTE A L'HUILE DE NOISETTE", 0.20F);
        Produit proSaucePommeFrites = new Produit("SAUCE POMME FRITES");
        Produit proKetchup = new Produit("KETCHUP");
        Produit proBioABoire = new Produit("BIO A BOIRE FRUITS ROUGES");
        Produit proLePetitDuoRaisins = new Produit("LE PETIT DUO DE RAISINS");
//        Produit pro = new Produit("", );
//        Produit pro = new Produit("", );
//        Produit pro = new Produit("", );
//        Produit pro = new Produit("", );
        
        // ********* La TVA *********
//        Tva tvaEmporter = new Tva(0.196F);
//        Tva tvaSurPlace = new Tva(0.055F);
        
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
         // ********* Les ItemsARetirer *********
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
        
        // ********* La TVA *********
//        em.persist(tvaEmporter);
//        em.persist(tvaSurPlace);
        
        // ********* Les Produits *********
        em.persist(proLeTheRouge);
        em.persist(proLeTheVertGrand);
        em.persist(proLeTheVert);
        em.persist(proLeTheGrey);
        em.persist(proLeTheGreyGrand);
        em.persist(proGrandCafe);
        em.persist(proGrandCafeGrand);
        em.persist(proCappuccino);
        em.persist(proCappuccinoGrand);
        em.persist(proCappuccinoDaim);
        em.persist(proCappuccinDaimoGrand);
        em.persist(proDoubleLatte);
        em.persist(proproDoubleLatteGrand);
        em.persist(proLatteMacchiato);
        em.persist(proExpresso);
        em.persist(proNoisette);
        em.persist(proRISTRETTO);
        em.persist(proChocolatChaud);
        em.persist(proGrandesCrousties);
        em.persist(proMoyenneCrousties);
        em.persist(proMoyenneFrite);
        em.persist(proGrandeFrite);
        em.persist(proPetiteFrite);
        em.persist(proSauceBarbecue);
        em.persist(proSauceChinoise);
        em.persist(proSauceCurry);
        em.persist(proVinaigretteAHuile);
        em.persist(proSaucePommeFrites);
        em.persist(proKetchup);
        em.persist(proBioABoire);
        em.persist(proLePetitDuoRaisins);
    }
}
