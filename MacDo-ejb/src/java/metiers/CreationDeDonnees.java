package metiers;

import entites.Abonne;
import entites.Allergene;
import entites.ItemARajoute;
import entites.ItemARetire;
import entites.Menu;
import entites.Produit;
import entites.Promotion;
import entites.Statut;
import entites.Tva;
import entites.Type;
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
        Promotion p04 = new Promotion("1 MacCafé pour 1 Euro pour tout menu acheté !");

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
        ItemARajoute itARaNappageChocolat = new ItemARajoute("Nappage Chocolat", 0.2F);
        ItemARajoute itARaNappageCaramel = new ItemARajoute("Nappage Caramel", 0.2F);
        ItemARajoute itARaNappageAbricot = new ItemARajoute("Nappage Abricot", 0.2F);

        // ********* Les Produits *********
        Produit proBigMac = new Produit("Big Mac", 4.3F, "Le seul, l'unique\n Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable. Pain spécial, steaks hachés, salade, oignon, cornichon, fromage fondu, sauce.", "Normal", 0, "./Images/BigMac.jpg");
        Produit proPoissonRanch = new Produit("Poisson Ranch", 3.5F, "Le nouveau McFirst™ Poisson Ranch. Pain spécial aux graines de sésame et de pavot, spécialité panée au poisson, cheddar fondu, oignons, salade, ketchup, sauce Ranch. poisson = préparation de poisson pané. Durée limitée.", "Normal", 0, "./Images/poissonRanch.png");
        Produit proBoeufRanch = new Produit("Boeuf Ranch Moutarde", 3.5F, "Pain spécial aux graines de sésame et de pavot, steaks hachés, cheddar fondu, oignons, salade, tomate, moutarde, sauce Ranch.", "Normal", 0, "./Images/bouefRanch.png");
        Produit proPouletRanch = new Produit("Poulet Ranch Ketchup", 3.5F, "Pain spécial aux graines de sésame et de pavot, spécialité panée au poulet, cheddar fondu, oignons, cornichons, salade, ketchup, sauce Ranch.", "Normal", 0, "./Images/pouletRanch.png");
        Produit proChickenMcNuggets4 = new Produit("Chicken McNuggets x4", 3.1F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x4", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets6 = new Produit("Chicken McNuggets x6", 4.2F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x6", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets9 = new Produit("Chicken McNuggets x9", 5.3F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x9", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets20 = new Produit("Chicken McNuggets x20", 9.9F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x20", 0, "./Images/chicken-nuggets.jpg");
        Produit proSummer = new Produit("Salade Summer Veggie", 6.3F, "Une délicieuse salade estivale et végétarienne avec ses galettes panées aux légumes 100% français, son duo de poivrons jaunes et rouges confits, son mélange de choux rouge et blanc origine Normandie, ses dés de fromage de brebis, ses tomates fraîches et son mélange de salades.\n\nSalade Summer­ Veggie­ = Salade estivale et végétarienne.", "Normal", 0, "./Images/SaladeManhattanVeggie.jpg");
        Produit proNewYorkCaesar = new Produit("Salade New York Caesar au Poulet Croustillant", 6.5F, "", "Normal", 0, "./Images/SaladeNewYork.jpg");
        Produit proManhattanPouletFrit = new Produit("Salade Manhattan au Poulet Mariné et Frit", 6.8F, "", "Normal", 0, "./Images/SaladeManhattanpouletFri.jpg");
        Produit proManhattanVeggie = new Produit("Salade Manhattan Veggie ", 6.7F, "De délicieuses galettes panées aux légumes 100% français, des tomates cerises, des grains de raisins, des cranberries et un mélange de salades : romaine, batavia et radicchio. Veggie = Végétarien Cranberries = Canneberges. Suggestion de présentation. Durée limitée", "Normal", 0, "./Images/SaladeManhattanVeggie.jpg");
        Produit proManhattan = new Produit("Salade Manhattan", 6.3F, "Salade composée d'un mélange de romaine, de batavia et de raddichio, de 2 spécialités panées au poulet, de tomates-cerises et de morceaux de pommes et grains de raisins. Proposée avec sa sauce Manhattan. ", "Normal", 0, "./Images/SaladeManhattan.png");
        Produit proManhattanPouletCroustillant = new Produit("Salade Manhattan au Poulet Croustillant", 6.9F, "", "Normal", 0, "./Images/SaladeManhattanPouletCroustillant.jpg");
        Produit proSignature280OriginalBeef = new Produit("Signature 280 Original Beef BBQ Burger", 0F, "Laissez-vous tenter par le savoureux 280™ Original. Un pain ciabatta cuit sur pierre, un steak haché 100% pur bœuf *, de l'emmental et du cheddar fondus, des oignons frais, deux rondelles de tomates, du ketchup et une sauce légerement citronnee. Durée limitée.  comme tout steak hache.", "Normal", 0, "./Images/280SignatureBeef.png");
        Produit proDoubleBlueCheese = new Produit("Double Blue Cheese & Bacon", 5.5F, "Le burger gourmet signé McDonald's™. Découvrez la recette : de la Fourme d'Ambert AOP, de la viande Charolaise, du long bacon fumé au bois de hêtre, des oignons fondants, le tout dans un pain spécial. Durée Limitée. Double Blue Cheese & Bacon = 2 steaks hachés & Fourme d'Ambert AOP", "Normal", 0, "./Images/DoubleBlueCheeseBacon.png");
        Produit proBeefBbq = new Produit("Beef BQQ", 5.3F, "Découvrez une recette généreuse et des ingrédients de qualité : de la viande charolaise, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Beef BBQ Burger = Steak haché et sauce goût barbecue. ", "Normal", 0, "./Images/BEEFBBQBURGER.png");
        Produit proChickenBbq = new Produit("Chicken BQQ", 5.4F, "Découvrez une recette généreuse et des ingrédients de qualité : un filet de poulet origine France, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Chicken BBQ = filet de poulet origine France", "Normal", 0, "./Images/CHICKENBBQ.png");
        Produit proRoyalDeLuxe = new Produit("Royal™ deluxe", 5.6F, "Le luxe de la sauce à la moutarde à l'ancienne. Craquez pour un savoureux steak haché avec du cheddar fondu, de la salade croquante et des oignons frais, le tout accompagné d'une délicieuse sauce à la moutarde à l'ancienne qui lui donne son goût si original. Pain spécial, steak haché, salade, oignon, fromage fondu, tomate, sauce.", "Normal", 0, "./Images/royal-deluxe.png");
        Produit proMcWrap = new Produit("Mc Wrap™ Chèvre", 8F, "Deux chèvres croustillants et chauds, une sauce onctueuse, des oignons frits, des rondelles de tomates, de la salade, le tout enveloppé dans une galette de blé. Chèvre = spécialité panée à base de fromage de chèvre", "Normal", 0, "./Images/McWRAPCHÈVRE.png");
        Produit proMcFish = new Produit("McFish", 4.1F, "Le petit frère du Filet-O-Fish. Caché au fond du Happy Meal, le McFish gagne à être connu : un pain lisse autour d'un poisson pané délicieusement croustillant et un peu de ketchup. Idéal pour s'initier au poisson ! Pain spécial, préparation de poisson pané, ketchup.", "Normal", 0, "./Images/McFISH.png");
        Produit proCroqueMcDo = new Produit("Croque McDo™", 2.1F, "A croquer ! Un croque monsieur tout rond, tout en simplicité : deux tranches d'emmental fondu, une tranche de jambon supérieur, dans un pain retourné et toasté. Il ne lui en faut pas plus pour être bon. Pain spécial, fromage fondu, jambon.", "Normal", 0, "./Images/CROQUEMcDo.png");
        Produit proHamburger = new Produit("Hamburger", 1.5F, "Un indémodable, tout simplement. Un steak haché, une rondelle de cornichon, des oignons, de la moutarde douce et du ketchup, retrouvez tout l'esprit de McDonald's dans ce classique au goût inimitable. Pain spécial, steack haché, oignon, cornichon, moutarde, ketchup.", "Normal", 0, "./Images/HAMBURGER.png");
        Produit proCheeseBurger = new Produit("CheeseBurger", 1.9F, "Le « Cheese » pour les intimes. Un steak haché, une tranche de cheddar fondu, une rondelle de cornichon, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique. Pain spécial, steack haché, fromage fondu, oignon, cornichon, moutarde, ketchup.", "Normal", 0, "./Images/CHEESEBURGER.png");
        Produit proCocaCola25 = new Produit("COCA-COLA® Original", 1.9F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Normal", 25, "./Images/Coca.png");
        Produit proCocaCola40 = new Produit("COCA-COLA® Original", 2.3F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Moyen", 40, "./Images/Coca.png");
        Produit proCocaCola50 = new Produit("COCA-COLA® Original", 2.8F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Grand", 50, "./Images/Coca.png");
        Produit proCocaColaZéro25 = new Produit("COCA-COLA ZÉRO® ", 1.9F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Normal", 25, "./Images/cocacolazero.jpg");
        Produit proCocaColaZéro40 = new Produit("COCA-COLA ZÉRO® ", 2.3F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Moyen", 40, "./Images/cocacolazero.jpg");
        Produit proCocaColaZéro50 = new Produit("COCA-COLA ZÉRO® ", 2.8F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Grand", 50, "./Images/cocacolazero.jpg");
        Produit proCocaColaLight25 = new Produit("COCA-COLA LIGHT® ", 1.9F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Normal", 25, "./Images/Cocalight.png");
        Produit proCocaColaLight40 = new Produit("COCA-COLA LIGHT® ", 2.3F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Moyen", 40, "./Images/Cocalight.png");
        Produit proCocaColaLight50 = new Produit("COCA-COLA LIGHT® ", 2.8F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Grand", 50, "./Images/Cocalight.png");
        Produit proSpriteZero25 = new Produit("Sprite Zéro®", 1.9F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Normal", 25, "./Images/Spritezero.png");
        Produit proSpriteZero40 = new Produit("Sprite Zéro®", 2.3F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Moyen", 40, "./Images/Spritezero.png");
        Produit proSpriteZero50 = new Produit("Sprite Zéro®", 2.8F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Grand", 50, "./Images/Spritezero.png");
        Produit proEvian33 = new Produit("Evian®", 2.3F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "./Images/evian33.jpg");
        Produit proEvian50 = new Produit("Evian®", 2.7F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "./Images/evian50.jpg");
        Produit proBadoit33 = new Produit("Badoit®", 2.3F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "./Images/Badoit.jpg");
        Produit proBadoit50 = new Produit("Badoit®", 2.7F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "./Images/Badoit.jpg");
        Produit proLiptonIceTea25 = new Produit("Lipton Ice Tea®", 2.3F, "LIPTON ICE TEA® Envie d'une boisson rafraîchissante ? Laissez-vous tenter par la recette délicieusement fruitée de Lipton Ice Tea saveur Pêche et profitez de son association de thé glacé et d'arômes fruités ! Ce parfait équilibre des extraits de thé et du délicieux goût pêche en feront la boisson idéale pour accompagner votre menu et ravir vos papilles ! Comme toute la gamme Lipton Ice Tea, cette recette est sans colorant. Alors n'hésitez plus en venant chez McDonald's, et adoptez l'esprit Drink Positive* de Lipton Ice Tea à n'importe quel moment de la journée ! Retrouvez Lipton Ice Tea sur http://www.liptonicetea.com/fr-FR/products pour tout savoir sur cette boisson ! *Buvez Positif Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "./Images/LiptonIceTea.png");
        Produit proMinuteMaid20 = new Produit("Minute Maid® Orange", 1.9F, "MINUTE MAID® ORANGE A tout moment de la journée, Minute Maid vous apporte une délicieuse dose de vitalité avec son jus d'orange à base de concentré avec pulpe. Faites-vous plaisir et comblez votre envie de fruits grâce à Minute Maid Orange. Ce jus à base de concentré est 100% teneur en fruits, sans sucres ajoutés, sans colorant et sans conservateur (conformément à la réglementation, contient naturellement le sucre des fruits). Le saviez-vous ? Boire un verre de Minute Maid Orange vous apporte l'équivalent d'une des 5 portions de fruits et légumes recommandées par jour. Minute Maid Orange est un jus à base de concentré. Minute Maid est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 20cl. Jus d'orange à base de jus d'orange concentré", "Normal", 20, "./Images/minute_maid.png");
        Produit proFanta25 = new Produit("Fanta", 1.9F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "./Images/fanta.jpg");
        Produit proFanta40 = new Produit("Fanta", 2.3F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Moyen", 40, "./Images/fanta.jpg");
        Produit proFanta50 = new Produit("Fanta", 2.8F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Grand", 50, "./Images/fanta.jpg");

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
        
        // Les types
        Type typPrincipal = new Type ("principal");
        Type typAccompagnement = new Type ("Accompagnement");
        Type typBoisson = new Type ("Boisson");
        Type typDessert = new Type ("Dessert");
        Type typSauce = new Type ("Sauce");
        
        // Les abonnés
//        Abonne aboNourdine = new Abonne("BOUSSAID", 35, "Nourdine", "nourdine@nourdine.com");
//        Abonne aboThierry = new Abonne("MARTINEZ", 5, "Thierry", "thierry@thierry.com");
//        Abonne aboEdem = new Abonne("ANNANI TOULASSI", 0, "Edem", "edem@edem.com");
//        Abonne aboAlex = new Abonne("CHARBIT", 80, "Alex", "alex@alex.com");
//        Abonne aboMomo = new Abonne("EL MASTOUR", 33, "Momo", "momo@momo.com");
        
        // Les allergènes
        Allergene allAnhydride = new Allergene("Anhydride sulfureux et sulfites");
        Allergene allArachide = new Allergene("Arachides");
        Allergene allCeleri = new Allergene("Céleri");
        Allergene allCrustaces = new Allergene("Crustacés");
        Allergene allFruitsACoques = new Allergene("Fruits à coques");
        Allergene allGluten = new Allergene("Gluten (blé)");
        Allergene allGraineDeSesame = new Allergene("Graine de sésame");
        Allergene allLait = new Allergene("Lait");
        Allergene allLupin = new Allergene("Lupin");
        Allergene allMollusques = new Allergene("Mollusques");
        Allergene allMoutarde = new Allergene("Moutarde");
        Allergene allOeufs = new Allergene("Oeufs");
        Allergene allPoissons = new Allergene("Poissons");
        Allergene allSoja = new Allergene("Soja");
        
       
        //Associations
        
//        aboMomo.setStatut(new Statut());
        
        //Persist
        em.persist(typPrincipal);
        em.persist(typAccompagnement);
        em.persist(typBoisson);
        em.persist(typDessert);
        em.persist(typSauce);
//        em.persist(aboNourdine);
//        em.persist(aboThierry);
//        em.persist(aboEdem);
//        em.persist(aboAlex);
//        em.persist(aboMomo);
        em.persist(allAnhydride);
        em.persist(allArachide);
        em.persist(allCrustaces);
        em.persist(allFruitsACoques);
        em.persist(allGluten);
        em.persist(allGraineDeSesame);
        em.persist(allLait);
        em.persist(allLupin);
        em.persist(allMollusques);
        em.persist(allMoutarde);
        em.persist(allOeufs);
        em.persist(allPoissons);
        em.persist(allSoja);
        
        
        
// ----------------------------------- Edem ------------------------------------
        // ************************ Creation des objets ************************
        // ********* Les Produits *********
        Produit proLeTheRouge = new Produit("THÉ FRUITS ROUGES GRAND FORMAT", 2.70F);
        Produit proLeTheVertGrand = new Produit("THÉ VERT A LA MENTHE GRAND FORMAT", 2.70F);
        proLeTheVertGrand.setTaille("Grande");
        Produit proLeTheVert = new Produit("THÉ VERT A LA MENTHE", 2.20F);
        Produit proLeTheGrey = new Produit("THÉ EARL GREY", 2.20F);
        Produit proLeTheGreyGrand = new Produit("THÉ EARL GREY GRAND FORMAT", 2.70F);
        //******************
        Produit proGrandCafe = new Produit("GRAND CAFE", 2F);
        Produit proGrandCafeGrand = new Produit("GRAND CAFE GRAND FORMAT", 2.5F);
        proGrandCafeGrand.setTaille("Grand");
        //******************
        Produit proCappuccino = new Produit("CAPPUCCINO", 2.40F);
        Produit proCappuccinoGrand = new Produit("CAPPUCCINO GRAND FORMAT", 2.90F);
        proCappuccinoGrand.setTaille("Grand");
        //******************
        Produit proCappuccinoDaim = new Produit("CAPPUCCINO DAIM", 2.50F);
        Produit proCappuccinDaimoGrand = new Produit("CAPPUCCINO DAIM GRAND FORMAT", 3F);
        proCappuccinDaimoGrand.setTaille("Grand");
        //******************
        Produit proDoubleLatte = new Produit("DOUBLE LATTE", 2.30F);
        Produit proproDoubleLatteGrand = new Produit("DOUBLE LATTE GRAND FORMAT", 2.80F);
        proproDoubleLatteGrand.setTaille("Grand");
        //******************
        Produit proLatteMacchiato = new Produit("LATTE MACCHIATO SAVEUR CHOCOLAT", 2.5F);
        Produit proExpresso = new Produit("EXPRESSO", 1.5F);
        Produit proNoisette = new Produit("NOISETTE", 1.70F);
        Produit proRISTRETTO = new Produit("RISTRETTO", 1.50F);
        Produit proChocolatChaud = new Produit("CHOCOLAT CHAUD", 2.20F);
        //******************
        Produit proGrandesCrousties = new Produit("GRANDES CROUSTIES", 2.90F);
        proGrandesCrousties.setTaille("Grande");
        Produit proMoyenneCrousties = new Produit("MOYENNE CROUSTIES", 2.5F);
        proMoyenneCrousties.setTaille("Moyenne");
        Produit proMoyenneFrite = new Produit("MOYENNE FRITE", 2.90F);
        proMoyenneFrite.setTaille("Moyenne");
        Produit proGrandeFrite = new Produit("GRANDE FRITE", 2.5F);
        proGrandeFrite.setTaille("Grande");
        Produit proPetiteFrite = new Produit("PETITE FRITE", 1.95F);
        proPetiteFrite.setTaille("Petite");
        //******************
        Produit proSauceBarbecue = new Produit("SAUCE CLASSIC BARBECUE", 0.20F);
        Produit proSauceChinoise = new Produit("SAUCE CHINOISE", 0.20F);
        Produit proSauceCurry = new Produit("SAUCE CURRY", 0.20F);
        Produit proVinaigretteAHuile = new Produit("VINAIGRETTE A L'HUILE DE NOISETTE", 0.20F);
        Produit proSaucePommeFrites = new Produit("SAUCE POMME FRITES");
        Produit proKetchup = new Produit("KETCHUP");
        //******************
        Produit proBioABoire = new Produit("BIO A BOIRE FRUITS ROUGES", 1.80F);
        Produit proPetitDuoRaisins = new Produit("PETIT DUO DE RAISINS", 2F);
        Produit proCornetNappageChocolat = new Produit("CORNET NAPPAGE SAVEUR CHOCOLAT", 2F);
        Produit proLeCookieFourreChoconuts = new Produit("COOKIE FOURRÉ CHOCONUTS");
        Produit proLePetitMuffinPepiteChocolat = new Produit("P'TIT MUFFIN AUX PÉPITES DE CHOCOLAT");
        Produit proSundaeNature = new Produit("SUNDAE NATURE", 2.70F);
        Produit proSundaeChocolat = new Produit("SUNDAE NAPPAGE SAVEUR CHOCOLAT", 2.70F);
        Produit proSundaeCaramel = new Produit("SUNDAE NAPPAGE SAVEUR CARAMEL", 2.70F);
        Produit proLeSundaeAbricot = new Produit("SUNDAE NAPPAGE SAVEUR ABRICOT", 2.70F);
        Produit proMcFlurryKitKat = new Produit("McFLURRY KIKAT", 3.20F);
        Produit proMcFlurryDaim = new Produit("McFLURRY DAIM", 3.20F);
        Produit proMcFlurryOreo = new Produit("McFLURRY OREO", 3.20F);
        Produit proMcFlurrySpeculoos = new Produit("McFLURRY SPECULOOS", 3.20F);
        Produit proVeryParfaitNoixDeCajou = new Produit("VERY PARFAIT NOIX DE CAJOU CARAMÉLISÉES", 3.30F);
        Produit proVeryParfaitCoulisAbricot = new Produit("VERY PARFAIT COULIS ABRICOT", 3.30F);
        Produit proVeryParfaitNature = new Produit("VERY PARFAIT NATURE", 3.30F);
        Produit proVeryParfaitNappageSaveurChocolat = new Produit("VERY PARFAIT NAPPAGE SAVEUR CHOCOLAT ", 3.30F);
        Produit proVeryParfaitNappageSaveurCaramel = new Produit("VERY PARFAIT NAPPAGE SAVEUR CARAMEL", 3.30F);
        Produit proFrappeSaveurChocolat = new Produit("FRAPPE SAVEUR CHOCOLAT", 2F);
        Produit proFrappeSaveurMarshmallow = new Produit("FRAPPE SAVEUR MARSHMALLOW", 2F);
        Produit proFrappeSaveurVanille = new Produit("FRAPPE SAVEUR VANILLE", 2F);
        Produit proFrappeSaveurMyrtille = new Produit("FRAPPE ", 2F);
        Produit proDonnutNature = new Produit("DONUT NATURE", 1.5F);
        Produit proDonutSaveurChocolat = new Produit("DONUT SAVEUR CHOCOLAT", 2F);
        Produit proBrownieChocolatNoisettes = new Produit("BROWNIE CHOCOLAT NOISETTES", 2F);
        Produit proCookieChocolatLaitNoisettes = new Produit("COOKIE CHOCOLAT AU LAIT ET NOISETTES", 2F);
        Produit proPetiteMelon = new Produit("P'TITE MELON", 1.50F);
        Produit proBerlingoFruitPommePeche = new Produit("BERLINGO'FRUITS POMME PÊCHE", 1.60F);
        //******************
        Produit proLivre = new Produit("LIVRE", 0.72F);
        Produit proJouet = new Produit("JOUET", 1F);
        Produit proBallon = new Produit("BALLON", 2F);
        
        // ********* La TVA *********
        Tva tvaEmporter = new Tva(0.1F);
        Tva tvaSurPlace = new Tva(0.2F);
        
        // ********* Les ItemsARetirer *********
        ItemARetire itaeSteak = new ItemARetire("Steak", "En 2016, la viande bovine dans nos restaurants est d'origine française pour 54,51%*. Ainsi, nous avons utilisé plus de 25 078 tonnes de viande bovine française. Le volume restant provient d'Irlande et des Pays-Bas selon le même cahier des charges et les mêmes contrôles qu'en France. Nos fournisseurs s'approvisionnent uniquement auprès de fournisseurs référencés selon des critères très exigeants, et utilisent principalement des muscles issus de l'avant des bovins comme par exemple, l'épaule, le collier, le plat de côte");
        ItemARetire itaeFrommage = new ItemARetire("Frommage");
        ItemARetire itaeSalade = new ItemARetire("Salade");
        ItemARetire itaeOignon = new ItemARetire("Oignon");
        ItemARetire itaeCornichon = new ItemARetire("Cornichon");
        ItemARetire itaeTomate = new ItemARetire("Tomate");
        ItemARetire itaePoisson = new ItemARetire("Poisson");
        ItemARetire itaePoulet = new ItemARetire("Poulet");
        ItemARetire itaeBacon = new ItemARetire("Bacon", null);
        ItemARetire itaeCacahuètes = new ItemARetire("Cacahuètes");

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
        em.persist(proPetitDuoRaisins);
        em.persist(proCornetNappageChocolat);
        em.persist(proDonnutNature);
        em.persist(proLeCookieFourreChoconuts);
        em.persist(proLePetitMuffinPepiteChocolat);
        em.persist(proSundaeNature);
        em.persist(proSundaeChocolat);
        em.persist(proSundaeCaramel);
        em.persist(proLeSundaeAbricot);
        em.persist(proMcFlurryKitKat);
        em.persist(proMcFlurryDaim);
        em.persist(proDonutSaveurChocolat);
        em.persist(proBrownieChocolatNoisettes);
        em.persist(proMcFlurryOreo);
        em.persist(proCookieChocolatLaitNoisettes);
        em.persist(proPetiteMelon);
        em.persist(proMcFlurrySpeculoos);
        em.persist(proBerlingoFruitPommePeche);
        em.persist(proLivre);
        em.persist(proJouet);
        em.persist(proBallon);
        em.persist(proVeryParfaitNoixDeCajou);
        em.persist(proVeryParfaitCoulisAbricot);
        em.persist(proVeryParfaitNature);
        em.persist(proVeryParfaitNappageSaveurChocolat);
        em.persist(proVeryParfaitNappageSaveurCaramel);
        em.persist(proFrappeSaveurChocolat);
        em.persist(proFrappeSaveurMarshmallow);
        em.persist(proFrappeSaveurVanille);
        em.persist(proFrappeSaveurMyrtille);
    }
}
