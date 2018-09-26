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
        ItemARajoute itARaNappageChocolat = new ItemARajoute("Nappage Chocolat", 0F);
        ItemARajoute itARaNappageCaramel = new ItemARajoute("Nappage Caramel", 0F);
        ItemARajoute itARaNappageAbricot = new ItemARajoute("Nappage Abricot", 0F);

        // ********* Les Produits *********
        Produit proBigMac = new Produit("Big Mac", 4.3F, "Le seul, l'unique\n Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable. Pain spécial, steaks hachés, salade, oignon, cornichon, fromage fondu, sauce.", "Normal", 0, "");
        Produit proPoissonRanch = new Produit("Poisson Ranch", 3.5F, "Le nouveau McFirst™ Poisson Ranch. Pain spécial aux graines de sésame et de pavot, spécialité panée au poisson, cheddar fondu, oignons, salade, ketchup, sauce Ranch. poisson = préparation de poisson pané. Durée limitée.", "Normal", 0, "");
        Produit proBoeufRanch = new Produit("Boeuf Ranch Moutarde", 3.5F, "Pain spécial aux graines de sésame et de pavot, steaks hachés, cheddar fondu, oignons, salade, tomate, moutarde, sauce Ranch.", "Normal", 0, "");
        Produit proPouletRanch = new Produit("Poulet Ranch Ketchup", 3.5F, "Pain spécial aux graines de sésame et de pavot, spécialité panée au poulet, cheddar fondu, oignons, cornichons, salade, ketchup, sauce Ranch.", "Normal", 0, "");
        Produit proChickenMcNuggets4 = new Produit("Chicken McNuggets x4", 3.1F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x4", 0, "");
        Produit proChickenMcNuggets6 = new Produit("Chicken McNuggets x6", 4.2F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x6", 0, "");
        Produit proChickenMcNuggets9 = new Produit("Chicken McNuggets x9", 5.3F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x9", 0, "");
        Produit proChickenMcNuggets20 = new Produit("Chicken McNuggets x20", 9.9F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x20", 0, "");
        Produit proSummer = new Produit("Salade Summer Veggie", 6.3F, "Une délicieuse salade estivale et végétarienne avec ses galettes panées aux légumes 100% français, son duo de poivrons jaunes et rouges confits, son mélange de choux rouge et blanc origine Normandie, ses dés de fromage de brebis, ses tomates fraîches et son mélange de salades.\n\nSalade Summer­ Veggie­ = Salade estivale et végétarienne.", "Normal", 0, "");
        Produit proNewYorkCaesar = new Produit("Salade New York Caesar au Poulet Croustillant", 6.5F, "", "Normal", 0, "");
        Produit proManhattanPouletFrit = new Produit("Salade Manhattan au Poulet Mariné et Frit", 6.8F, "", "Normal", 0, "");
        Produit proManhattanVeggie = new Produit("Salade Manhattan Veggie ", 6.7F, "De délicieuses galettes panées aux légumes 100% français, des tomates cerises, des grains de raisins, des cranberries et un mélange de salades : romaine, batavia et radicchio. Veggie = Végétarien Cranberries = Canneberges. Suggestion de présentation. Durée limitée", "Normal", 0, "");
        Produit proManhattan = new Produit("Salade Manhattan", 6.3F, "Salade composée d'un mélange de romaine, de batavia et de raddichio, de 2 spécialités panées au poulet, de tomates-cerises et de morceaux de pommes et grains de raisins. Proposée avec sa sauce Manhattan. ", "Normal", 0, "");
        Produit proManhattanPouletCroustillant = new Produit("Salade Manhattan au Poulet Croustillant", 6.9F, "", "Normal", 0, "");
        Produit proSignature= new Produit("Signature", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");
//        Produit proPoissonRanch = new Produit("Poisson Ranch", 4.95F, "", "Normal", 0, "");

        // ************************** Associations *****************************
 
        
        
        
        //**************************** Persist *********************************
        em.persist(itARaNappageChocolat);
        em.persist(itARaNappageCaramel);
        em.persist(itARaNappageAbricot);

        em.persist(proBigMac);
        em.persist(proPoissonRanch);
        em.persist(proPouletRanch);
        em.persist(proBoeufRanch);
        em.persist(proChickenMcNuggets4);
        em.persist(proChickenMcNuggets6);
        em.persist(proChickenMcNuggets9);
        em.persist(proChickenMcNuggets20);
        em.persist(proSummer);
        em.persist(proNewYorkCaesar);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanVeggie);
        em.persist(proManhattan);
        em.persist(proManhattanPouletCroustillant);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        em.persist(proManhattanPouletFrit);
        

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
