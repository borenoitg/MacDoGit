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
        Produit proSignature280OriginalBeef = new Produit("Signature 280 Original Beef BBQ Burger", 0F, "Laissez-vous tenter par le savoureux 280™ Original. Un pain ciabatta cuit sur pierre, un steak haché 100% pur bœuf *, de l'emmental et du cheddar fondus, des oignons frais, deux rondelles de tomates, du ketchup et une sauce légerement citronnee. Durée limitée.  comme tout steak hache.", "Normal", 0, "");
        Produit proDoubleBlueCheese = new Produit("Double Blue Cheese & Bacon", 5.5F, "Le burger gourmet signé McDonald's™. Découvrez la recette : de la Fourme d'Ambert AOP, de la viande Charolaise, du long bacon fumé au bois de hêtre, des oignons fondants, le tout dans un pain spécial. Durée Limitée. Double Blue Cheese & Bacon = 2 steaks hachés & Fourme d'Ambert AOP", "Normal", 0, "");
        Produit proBeefBbq = new Produit("Beef BQQ", 5.3F, "Découvrez une recette généreuse et des ingrédients de qualité : de la viande charolaise, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Beef BBQ Burger = Steak haché et sauce goût barbecue. ", "Normal", 0, "");
        Produit proChickenBbq = new Produit("Chicken BQQ", 5.4F, "Découvrez une recette généreuse et des ingrédients de qualité : un filet de poulet origine France, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Chicken BBQ = filet de poulet origine France", "Normal", 0, "");
        Produit proRoyalDeLuxe = new Produit("Royal™ deluxe", 5.6F, "Le luxe de la sauce à la moutarde à l'ancienne. Craquez pour un savoureux steak haché avec du cheddar fondu, de la salade croquante et des oignons frais, le tout accompagné d'une délicieuse sauce à la moutarde à l'ancienne qui lui donne son goût si original. Pain spécial, steak haché, salade, oignon, fromage fondu, tomate, sauce.", "Normal", 0, "");
        Produit proMcWrap = new Produit("Mc Wrap™ Chèvre", 8F, "Deux chèvres croustillants et chauds, une sauce onctueuse, des oignons frits, des rondelles de tomates, de la salade, le tout enveloppé dans une galette de blé. Chèvre = spécialité panée à base de fromage de chèvre", "Normal", 0, "");
        Produit proMcFish = new Produit("McFish", 4.1F, "Le petit frère du Filet-O-Fish. Caché au fond du Happy Meal, le McFish gagne à être connu : un pain lisse autour d'un poisson pané délicieusement croustillant et un peu de ketchup. Idéal pour s'initier au poisson ! Pain spécial, préparation de poisson pané, ketchup.", "Normal", 0, "");
        Produit proCroqueMcDo = new Produit("Croque McDo™", 2.1F, "A croquer ! Un croque monsieur tout rond, tout en simplicité : deux tranches d'emmental fondu, une tranche de jambon supérieur, dans un pain retourné et toasté. Il ne lui en faut pas plus pour être bon. Pain spécial, fromage fondu, jambon.", "Normal", 0, "");
        Produit proHamburger = new Produit("Hamburger", 1.5F, "Un indémodable, tout simplement. Un steak haché, une rondelle de cornichon, des oignons, de la moutarde douce et du ketchup, retrouvez tout l'esprit de McDonald's dans ce classique au goût inimitable. Pain spécial, steack haché, oignon, cornichon, moutarde, ketchup.", "Normal", 0, "");
        Produit proCheeseBurger = new Produit("CheeseBurger", 1.9F, "Le « Cheese » pour les intimes. Un steak haché, une tranche de cheddar fondu, une rondelle de cornichon, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique. Pain spécial, steack haché, fromage fondu, oignon, cornichon, moutarde, ketchup.", "Normal", 0, "");
        Produit proCocaCola25 = new Produit("COCA-COLA® Original", 1.9F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Normal", 25, "");
        Produit proCocaCola40 = new Produit("COCA-COLA® Original", 2.3F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Moyen", 40, "");
        Produit proCocaCola50 = new Produit("COCA-COLA® Original", 2.8F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Grand", 50, "");
        Produit proCocaColaZéro25 = new Produit("COCA-COLA ZÉRO® ", 1.9F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Normal", 25, "");
        Produit proCocaColaZéro40 = new Produit("COCA-COLA ZÉRO® ", 2.3F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Moyen", 40, "");
        Produit proCocaColaZéro50 = new Produit("COCA-COLA ZÉRO® ", 2.8F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Grand", 50, "");
        Produit proCocaColaLight25 = new Produit("COCA-COLA LIGHT® ", 1.9F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Normal", 25, "");
        Produit proCocaColaLight40 = new Produit("COCA-COLA LIGHT® ", 2.3F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Moyen", 40, "");
        Produit proCocaColaLight50 = new Produit("COCA-COLA LIGHT® ", 2.8F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Grand", 50, "");
        Produit proSpriteZero25 = new Produit("Sprite Zéro®", 1.9F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Normal", 25, "");
        Produit proSpriteZero40 = new Produit("Sprite Zéro®", 2.3F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Moyen", 40, "");
        Produit proSpriteZero50 = new Produit("Sprite Zéro®", 2.8F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Grand", 50, "");
        Produit proEvian33 = new Produit("Evian®", 2.3F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "");
        Produit proEvian50 = new Produit("Evian®", 2.7F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "");
        Produit proBadoit33 = new Produit("Badoit®", 2.3F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "");
        Produit proBadoit50 = new Produit("Badoit®", 2.7F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "");
        Produit proLiptonIceTea25 = new Produit("Lipton Ice Tea®", 2.3F, "LIPTON ICE TEA® Envie d'une boisson rafraîchissante ? Laissez-vous tenter par la recette délicieusement fruitée de Lipton Ice Tea saveur Pêche et profitez de son association de thé glacé et d'arômes fruités ! Ce parfait équilibre des extraits de thé et du délicieux goût pêche en feront la boisson idéale pour accompagner votre menu et ravir vos papilles ! Comme toute la gamme Lipton Ice Tea, cette recette est sans colorant. Alors n'hésitez plus en venant chez McDonald's, et adoptez l'esprit Drink Positive* de Lipton Ice Tea à n'importe quel moment de la journée ! Retrouvez Lipton Ice Tea sur http://www.liptonicetea.com/fr-FR/products pour tout savoir sur cette boisson ! *Buvez Positif Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "");
        Produit proMinuteMaid20 = new Produit("Minute Maid® Orange", 1.9F, "MINUTE MAID® ORANGE A tout moment de la journée, Minute Maid vous apporte une délicieuse dose de vitalité avec son jus d'orange à base de concentré avec pulpe. Faites-vous plaisir et comblez votre envie de fruits grâce à Minute Maid Orange. Ce jus à base de concentré est 100% teneur en fruits, sans sucres ajoutés, sans colorant et sans conservateur (conformément à la réglementation, contient naturellement le sucre des fruits). Le saviez-vous ? Boire un verre de Minute Maid Orange vous apporte l'équivalent d'une des 5 portions de fruits et légumes recommandées par jour. Minute Maid Orange est un jus à base de concentré. Minute Maid est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 20cl. Jus d'orange à base de jus d'orange concentré", "Normal", 20, "");
        Produit proFanta25 = new Produit("Fanta", 1.9F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "");
        Produit proFanta40 = new Produit("Fanta", 2.3F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Moyen", 40, "");
        Produit proFanta50 = new Produit("Fanta", 2.8F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Grand", 50, "");

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
        em.persist(proSignature280OriginalBeef);
        em.persist(proDoubleBlueCheese);
        em.persist(proBeefBbq);
        em.persist(proChickenBbq);
        em.persist(proRoyalDeLuxe);
        em.persist(proMcWrap);
        em.persist(proMcFish);
        em.persist(proCroqueMcDo);
        em.persist(proHamburger);
        em.persist(proCheeseBurger);
        em.persist(proCocaCola25);
        em.persist(proCocaCola40);
        em.persist(proCocaCola50);
        em.persist(proCocaColaZéro25);
        em.persist(proCocaColaZéro40);
        em.persist(proCocaColaZéro50);
        em.persist(proCocaColaLight25);
        em.persist(proCocaColaLight40);
        em.persist(proCocaColaLight50);
        em.persist(proSpriteZero25);
        em.persist(proSpriteZero40);
        em.persist(proSpriteZero50);
        em.persist(proEvian33);
        em.persist(proEvian50);
        em.persist(proBadoit33);
        em.persist(proBadoit50);
        em.persist(proLiptonIceTea25);
        em.persist(proMinuteMaid20);
        em.persist(proFanta25);
        em.persist(proFanta40);
        em.persist(proFanta50);

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
        //******************
        Produit proBioABoire = new Produit("BIO A BOIRE FRUITS ROUGES");
        Produit proLePetitDuoRaisins = new Produit("LE PETIT DUO DE RAISINS");
        Produit proCornetNappageChocolat = new Produit("LE CORNET NAPPAGE SAVEUR CHOCOLAT");
        Produit proLeCookieFourreChoconuts = new Produit("LE COOKIE FOURRÉ CHOCONUTS");
        Produit proLePetitMuffinPepiteChocolat = new Produit("lE P'TIT MUFFIN AUX PÉPITES DE CHOCOLAT");
        Produit proLeSundae = new Produit("LE SUNDAE");
        Produit proLeSundaeChocolat = new Produit("LE SUNDAE CHOCOLAT");
        Produit proLeSundaeCaramel = new Produit("LE SUNDAE  CARAMEL");
        Produit proLeSundaeAbricot = new Produit("LE SUNDAE ABRICOT");
        Produit proLeMcFlurryKitKat = new Produit("Le McFLURRY KIKAT");
        Produit proLeMcFlurryDaim = new Produit("Le McFLURRY DAIM");
        Produit proLeMcFlurryOreo = new Produit("Le McFLURRY OREO");
        Produit proLeMcFlurrySpeculoos = new Produit("Le McFLURRY SPECULOOS");
        Produit proLeVeryParfait = new Produit("LE VERY PARFAIT");
        //Produit proLeVeryParfait = new Produit("LE VERY PARFAIT");
//        Produit proFrappe = new Produit("FRAPPE ");
//        Produit proFrappe = new Produit("FRAPPE ");
//        Produit proFrappe = new Produit("FRAPPE ");
//        Produit proFrappe = new Produit("FRAPPE ");
        Produit proDonnutNature = new Produit("LE DONUT NATURE");
        Produit proLeDonutSaveurChocolat = new Produit("LE DONUT SAVEUR CHOCOLAT");
        Produit proLeBrownieChocolatNoisettes = new Produit("LE BROWNIE CHOCOLAT NOISETTES");
        Produit proLeCookieChocolatLaitNoisettes = new Produit("LE COOKIE CHOCOLAT AU LAIT ET NOISETTES");
        Produit proLaPetiteMelon = new Produit("LA P'TITE MELON");
        Produit proLeBerlingoFruitPommePeche = new Produit("LE BERLINGO'FRUITS POMME PÊCHE");
        
        // ********* La TVA *********
        Tva tvaEmporter = new Tva(0.1F);
        Tva tvaSurPlace = new Tva(0.2F);
        
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
        em.persist(tvaEmporter);
        em.persist(tvaSurPlace);
        
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
        em.persist(proCornetNappageChocolat);
        em.persist(proDonnutNature);
        em.persist(proLeCookieFourreChoconuts);
        em.persist(proLePetitMuffinPepiteChocolat);
        em.persist(proLeSundae);
        em.persist(proLeSundaeChocolat);
        em.persist(proLeSundaeCaramel);
        em.persist(proLeSundaeAbricot);
        em.persist(proLeMcFlurryKitKat);
        em.persist(proLeMcFlurryDaim);
        em.persist(proLeDonutSaveurChocolat);
        em.persist(proLeBrownieChocolatNoisettes);
        em.persist(proLeMcFlurryOreo);
        em.persist(proLeCookieChocolatLaitNoisettes);
        em.persist(proLaPetiteMelon);
        em.persist(proLeMcFlurrySpeculoos);
        em.persist(proLeVeryParfait);
        em.persist(proLeBerlingoFruitPommePeche);
    }
}
