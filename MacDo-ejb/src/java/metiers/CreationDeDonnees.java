package metiers;

import entites.Abonne;
import entites.Allergene;
import entites.Commande;
import entites.Ingredient;
import entites.ItemARajouter;
import entites.ItemARetirer;
import entites.LigneDeCommande;
import entites.Menu;
import entites.Produit;
import entites.SousLigneDeCommande;
import entites.SousType;
import entites.Statut;
import entites.Tva;
import entites.Type;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import metiers.CreationDeDonneesLocal;

@Singleton
public class CreationDeDonnees implements CreationDeDonneesLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public void creationDonnees() {

// -----------------------------------------------------------------------------        
//                          CREATION DES DONNEES
// -----------------------------------------------------------------------------        
        //---------- MENUS ----------
        Menu menHappyMeal = new Menu("HappyMeal", "Menu", "./Images/", 5.50F);
        Menu menBigMacBest = new Menu("Big Mac", " Menu Best Of", "./Images/", 8.90F);
        Menu menBigMacMaxiBest = new Menu("Big Mac", "Menu Maxi Best Of", "./Images/", 8.00F);
        Menu menSalade = new Menu("Salade", "Menu", "./Images/", 6.50F);
        Menu menChickMacNugx6 = new Menu("Chicken McNuggets x6", "Menu Best Of", "./Images/", 7.50F);
        Menu menPtitDej = new Menu("P'tit Déj", "Menu", "./Images/", 7.30F);
        Menu menSignatureBest = new Menu("Signature 280", "Menu Best Of", "./Images/", 8.30F);

        //---------- PRODUITS ----------
        // Les burgers
        Produit proBigMac = new Produit("Big Mac", 4.30F, "Le seul, l'unique\n Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable. Pain spécial, steaks hachés, salade, oignon, cornichon, fromage fondu, sauce.", "", 0, "./Images/BigMac.jpg");
        Produit proPoissonRanch = new Produit("Poisson Ranch", 3.50F, "Le nouveau McFirst™ Poisson Ranch. Pain spécial aux graines de sésame et de pavot, spécialité panée au poisson, cheddar fondu, oignons, salade, ketchup, sauce Ranch. poisson = préparation de poisson pané. Durée limitée.", "", 0, "./Images/poissonRanch.png");
        Produit proBoeufRanch = new Produit("Boeuf Ranch Moutarde", 3.50F, "Pain spécial aux graines de sésame et de pavot, steaks hachés, cheddar fondu, oignons, salade, tomate, moutarde, sauce Ranch.", "", 0, "./Images/boeufRanch.png");
        Produit proPouletRanch = new Produit("Poulet Ranch Ketchup", 3.50F, "Pain spécial aux graines de sésame et de pavot, spécialité panée au poulet, cheddar fondu, oignons, cornichons, salade, ketchup, sauce Ranch.", "", 0, "./Images/pouletRanch.png");
        Produit proDoubleBlueCheese = new Produit("Double Blue Cheese and Bacon", 5.50F, "Le burger gourmet signé McDonald's™. Découvrez la recette : de la Fourme d'Ambert AOP, de la viande Charolaise, du long bacon fumé au bois de hêtre, des oignons fondants, le tout dans un pain spécial. Durée Limitée. Double Blue Cheese & Bacon = 2 steaks hachés & Fourme d'Ambert AOP", "", 0, "./Images/DoubleBlueCheeseBacon.png");
        Produit proBeefBbq = new Produit("Beef BQQ", 5.30F, "Découvrez une recette généreuse et des ingrédients de qualité : de la viande charolaise, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Beef BBQ Burger = Steak haché et sauce goût barbecue. ", "", 0, "./Images/BEEFBBQBURGER.png");
        Produit proChickenBbq = new Produit("Chicken BQQ", 5.40F, "Découvrez une recette généreuse et des ingrédients de qualité : un filet de poulet origine France, des oignons rouges, de la sauce barbecue, du cheddar, le tout dans un pain shiny. Chicken BBQ = filet de poulet origine France", "", 0, "./Images/CHICKENBBQ.png");
        Produit proRoyalDeLuxe = new Produit("Royal™ deluxe", 5.60F, "Le luxe de la sauce à la moutarde à l'ancienne. Craquez pour un savoureux steak haché avec du cheddar fondu, de la salade croquante et des oignons frais, le tout accompagné d'une délicieuse sauce à la moutarde à l'ancienne qui lui donne son goût si original. Pain spécial, steak haché, salade, oignon, fromage fondu, tomate, sauce.", "", 0, "./Images/royal-deluxe.png");
        Produit proMcFish = new Produit("McFish", 4.10F, "Le petit frère du Filet-O-Fish. Caché au fond du Happy Meal, le McFish gagne à être connu : un pain lisse autour d'un poisson pané délicieusement croustillant et un peu de ketchup. Idéal pour s'initier au poisson ! Pain spécial, préparation de poisson pané, ketchup.", "", 0, "./Images/McFISH.png");
        Produit proCroqueMcDo = new Produit("Croque McDo™", 2.10F, "A croquer ! Un croque monsieur tout rond, tout en simplicité : deux tranches d'emmental fondu, une tranche de jambon supérieur, dans un pain retourné et toasté. Il ne lui en faut pas plus pour être bon. Pain spécial, fromage fondu, jambon.", "", 0, "./Images/CROQUEMcDo.png");
        Produit proHamburger = new Produit("Hamburger", 1.50F, "Un indémodable, tout simplement. Un steak haché, une rondelle de cornichon, des oignons, de la moutarde douce et du ketchup, retrouvez tout l'esprit de McDonald's dans ce classique au goût inimitable. Pain spécial, steack haché, oignon, cornichon, moutarde, ketchup.", "", 0, "./Images/HAMBURGER.png");
        Produit proCheeseBurger = new Produit("CheeseBurger", 1.90F, "Le « Cheese » pour les intimes. Un steak haché, une tranche de cheddar fondu, une rondelle de cornichon, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique. Pain spécial, steack haché, fromage fondu, oignon, cornichon, moutarde, ketchup.", "", 0, "./Images/CHEESEBURGER.png");
        // Les salades
        Produit proSummer = new Produit("Salade Summer Veggie", 6.30F, "Une délicieuse salade estivale et végétarienne avec ses galettes panées aux légumes 100% français, son duo de poivrons jaunes et rouges confits, son mélange de choux rouge et blanc origine Normandie, ses dés de fromage de brebis, ses tomates fraîches et son mélange de salades.\n\nSalade Summer­ Veggie­ = Salade estivale et végétarienne.", "", 0, "./Images/SaladeManhattanVeggie.jpg");
        Produit proNewYorkCaesar = new Produit("Salade New York Caesar au Poulet Croustillant", 6.50F, "", "Normal", 0, "./Images/SaladeNewYork.jpg");
        Produit proManhattanPouletFrit = new Produit("Salade Manhattan au Poulet Mariné et Frit", 6.80F, "", "Normal", 0, "./Images/SaladeManhattanpouletFri.jpg");
        Produit proManhattanVeggie = new Produit("Salade Manhattan Veggie ", 6.70F, "De délicieuses galettes panées aux légumes 100% français, des tomates cerises, des grains de raisins, des cranberries et un mélange de salades : romaine, batavia et radicchio. Veggie = Végétarien Cranberries = Canneberges. Suggestion de présentation. Durée limitée", "", 0, "./Images/SaladeManhattanVeggie.jpg");
        Produit proManhattan = new Produit("Salade Manhattan", 6.30F, "Salade composée d'un mélange de romaine, de batavia et de raddichio, de 2 spécialités panées au poulet, de tomates-cerises et de morceaux de pommes et grains de raisins. Proposée avec sa sauce Manhattan. ", "", 0, "./Images/SaladeManhattan.png");
        Produit proManhattanPouletCroustillant = new Produit("Salade Manhattan au Poulet Croustillant", 6.90F, "", "Normal", 0, "./Images/SaladeManhattanPouletCroustillant.jpg");
        // Les p'tites faims
        Produit proMcWrap = new Produit("Mc Wrap™ Chèvre", 8F, "Deux chèvres croustillants et chauds, une sauce onctueuse, des oignons frits, des rondelles de tomates, de la salade, le tout enveloppé dans une galette de blé. Chèvre = spécialité panée à base de fromage de chèvre", "", 0, "./Images/McWRAPCHÈVRE.png");
        Produit proChickenMcNuggets4 = new Produit("Chicken McNuggets", 3.10F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x4", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets6 = new Produit("Chicken McNuggets", 4.20F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x6", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets9 = new Produit("Chicken McNuggets", 5.30F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x9", 0, "./Images/chicken-nuggets.jpg");
        Produit proChickenMcNuggets20 = new Produit("Chicken McNuggets", 9.90F, "À déguster seul ou accompagné. Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir ! Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™. Valeurs nutritionnelles présentées pour une portion de 4. Spécialités panées au poulet.", "x20", 0, "./Images/chicken-nuggets.jpg");
        // Les boissons froides
        Produit proCocaCola25 = new Produit("COCA-COLA® Original", 1.90F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Normal", 25, "./Images/Coca.png");
        Produit proCocaCola40 = new Produit("COCA-COLA® Original", 2.30F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Moyen", 40, "./Images/Coca.png");
        Produit proCocaCola50 = new Produit("COCA-COLA® Original", 2.80F, "COCA-COLA® Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille ! Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis ! Coca-Cola est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl. Original Taste = Goût Original", "Grand", 50, "./Images/Coca.png");
        Produit proCocaColaZero25 = new Produit("COCA-COLA ZERO® ", 1.90F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Normal", 25, "./Images/cocacolazero.jpg");
        Produit proCocaColaZero40 = new Produit("COCA-COLA ZERO® ", 2.30F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Moyen", 40, "./Images/cocacolazero.jpg");
        Produit proCocaColaZero50 = new Produit("COCA-COLA ZERO® ", 2.80F, "COCA-COLA ZÉRO® Venez découvrir Coca-Cola zero sucres chez McDonald's. Coca-Cola zero sucres, c'est le goût unique de Coca-Cola avec zero sucres. Notre recette, mélange unique d'ingrédients, d'eau pétillante, avec une touche caramel, recrée le goût de Coca-Cola, sans sucres. Appréciez-le avec plaisir ! Coca-Cola zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl Contient des édulcorants", "Grand", 50, "./Images/cocacolazero.jpg");
        Produit proCocaColaLight25 = new Produit("COCA-COLA LIGHT® ", 1.90F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Normal", 25, "./Images/Cocalight.png");
        Produit proCocaColaLight40 = new Produit("COCA-COLA LIGHT® ", 2.30F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Moyen", 40, "./Images/Cocalight.png");
        Produit proCocaColaLight50 = new Produit("COCA-COLA LIGHT® ", 2.80F, "COCA-COLA LIGHT® Comment concilier plaisir et légèreté ? C'est simple, il suffit de choisir Coca-Cola light taste. Coca-Cola light taste, c'est avant tout le plaisir d'une boisson rafraîchissante au goût intense et léger sans sucres et sans calorie. C'est l'allié de vos pauses plaisir. Coca-Cola light est une marque déposée de The Coca-Cola Company. Valeur nutritionnelles pour une boisson de 25cl Contient des édulcorants Light Taste = Goût Léger", "Grand", 50, "./Images/Cocalight.png");
        Produit proSpriteZero25 = new Produit("Sprite Zéro®", 1.90F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Normal", 25, "./Images/Spritezero.png");
        Produit proSpriteZero40 = new Produit("Sprite Zéro®", 2.30F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Moyen", 40, "./Images/Spritezero.png");
        Produit proSpriteZero50 = new Produit("Sprite Zéro®", 2.80F, "Plus qu'une boisson, un frisson. Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre ! Sprite, born to refresh ! Créé pour rafraichir ! Sprite zero est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25 cl", "Grand", 50, "./Images/Spritezero.png");
        Produit proEvian33 = new Produit("Evian®", 2.30F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "./Images/evian33.jpg");
        Produit proEvian50 = new Produit("Evian®", 2.70F, "Une petite soif ? Notre corps est constitué  à 60% d'eau. Il est donc essentiel de boire suffisamment d'eau tous les jours. evian®, véritable trésor de pureté, fruit de plus de 15 années de filtration au cœur des Alpes, est une eau faiblement minéralisée qui répond à vos besoins quotidiens. McDonald's s'associe à evian® pour vous proposer les bouteilles 50cl et 33cl afin d'accompagner vos menus de fraîcheur et de légèreté. evian® 50cl vous apporte un tiers de vos besoins quotidiens en eau et vous accompagne partout à la sortie du restaurant. Dans les menus Happy Meal, retrouvez également evian® 33cl, une petite bouteille parfaitement adaptée aux mains des enfants et un format idéal pour les petites soifs. valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "./Images/evian50.jpg");
        Produit proBadoit33 = new Produit("Badoit®", 2.30F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Normal", 33, "./Images/Badoit.jpg");
        Produit proBadoit50 = new Produit("Badoit®", 2.70F, "BADOIT® est une eau minérale naturelle gazeuse, appréciée pour sa saveur unique et sa multitude de fines bulles. Reconnue depuis 1778 pour ses vertus, elle jaillit à Saint Galmier, dans la Loire, après un long parcours souterrain qui l'enrichit naturellement de ses sels minéraux essentiels et de sa fine pétillance, renforcée par l'adjonction de gaz carbonique pour le plaisir du palais. Badoit souligne avec élégance et subtilité tous vos repas. Choisissez sa fine pétillance pour faire pétiller vos menus. Badoit est disponible chez McDo en formats 33cl et 50cl. Badoit, buvez de la joie ! valeur nutritionnelle pour une boisson moyenne", "Moyen", 50, "./Images/Badoit.jpg");
        Produit proLiptonIceTea25 = new Produit("Lipton Ice Tea®", 2.30F, "LIPTON ICE TEA® Envie d'une boisson rafraîchissante ? Laissez-vous tenter par la recette délicieusement fruitée de Lipton Ice Tea saveur Pêche et profitez de son association de thé glacé et d'arômes fruités ! Ce parfait équilibre des extraits de thé et du délicieux goût pêche en feront la boisson idéale pour accompagner votre menu et ravir vos papilles ! Comme toute la gamme Lipton Ice Tea, cette recette est sans colorant. Alors n'hésitez plus en venant chez McDonald's, et adoptez l'esprit Drink Positive* de Lipton Ice Tea à n'importe quel moment de la journée ! Retrouvez Lipton Ice Tea sur http://www.liptonicetea.com/fr-FR/products pour tout savoir sur cette boisson ! *Buvez Positif Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "./Images/LiptonIceTea.png");
        Produit proMinuteMaid20 = new Produit("Minute Maid® Orange", 1.90F, "MINUTE MAID® ORANGE A tout moment de la journée, Minute Maid vous apporte une délicieuse dose de vitalité avec son jus d'orange à base de concentré avec pulpe. Faites-vous plaisir et comblez votre envie de fruits grâce à Minute Maid Orange. Ce jus à base de concentré est 100% teneur en fruits, sans sucres ajoutés, sans colorant et sans conservateur (conformément à la réglementation, contient naturellement le sucre des fruits). Le saviez-vous ? Boire un verre de Minute Maid Orange vous apporte l'équivalent d'une des 5 portions de fruits et légumes recommandées par jour. Minute Maid Orange est un jus à base de concentré. Minute Maid est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 20cl. Jus d'orange à base de jus d'orange concentré", "Normal", 20, "./Images/minute_maid.png");
        Produit proFanta25 = new Produit("Fanta", 1.90F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Normal", 25, "./Images/fanta.jpg");
        Produit proFanta40 = new Produit("Fanta", 2.30F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Moyen", 40, "./Images/fanta.jpg");
        Produit proFanta50 = new Produit("Fanta", 2.80F, "FANTA® Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! Fanta Orange contient du jus d'orange et des arômes naturels. Pour toute information complémentaire sur ce produit, consultez la page www.fanta.fr Fanta est une marque déposée de The Coca-Cola Company. Valeurs nutritionnelles pour une boisson de 25cl", "Grand", 50, "./Images/fanta.jpg");
        // Les boissons chaudes
        Produit proTheVert = new Produit("THÉ VERT A LA MENTHE", 2.20F, "./Images/theMenthe.png");
        Produit proTheGrey = new Produit("THÉ EARL GREY", 2.20F, "./Images/theGrey.png");
        Produit proGrandCafe = new Produit("GRAND CAFE", 2F, "./Images/grandCafe.png");
        Produit proCappuccino = new Produit("CAPPUCCINO", 2.40F, "./Images/cappuccino.png");
        Produit proCappuccinoDaim = new Produit("CAPPUCCINO DAIM", 2.50F, "./Images/cappuccinoDaim.jpg");
        Produit proDoubleLatte = new Produit("DOUBLE LATTE", 2.30F, "./Images/doubleLatte.jpg");
        Produit proLatteMacchiato = new Produit("LATTE MACCHIATO SAVEUR CHOCOLAT", 2.50F, "./Images/LatteMacchiatoSaveurChocolat.png");
        Produit proExpresso = new Produit("EXPRESSO", 1.50F, "./Images/expresso.jpg");
        Produit proNoisette = new Produit("NOISETTE", 1.70F, "./Images/noisette.jpg");
        Produit proRistretto = new Produit("RISTRETTO", 1.50F, "./Images/ristrtto.jpg");
        Produit proChocolatChaud = new Produit("CHOCOLAT CHAUD", 2.20F, "./Images/chocolatChaud.jpg");

        Produit proTheRougeGrand = new Produit("THÉ FRUITS ROUGES GRAND FORMAT", 2.70F, "Grande", "./Images/theFruitRouge.png");
        Produit proTheVertGrand = new Produit("THÉ VERT A LA MENTHE GRAND FORMAT", 2.70F, "Grande", "./Images/theMenthe.png");
        Produit proTheGreyGrand = new Produit("THÉ EARL GREY GRAND FORMAT", 2.70F, "Grande", "./Images/theGrey.png");
        Produit proGrandCafeGrand = new Produit("GRAND CAFE GRAND FORMAT", 2.50F, "Grande", "./Images/grandCafeGrandFormat.jpg");
        Produit proCappuccinoGrand = new Produit("CAPPUCCINO GRAND FORMAT", 2.90F, "Grande", "./Images/cappuccinoGrand.png");
        Produit proCappuccinDaimGrand = new Produit("CAPPUCCINO DAIM GRAND FORMAT", 3F, "Grande", "./Images/cappuccinoDaimGrand.png");
        Produit proDoubleLatteGrand = new Produit("DOUBLE LATTE GRAND FORMAT", 2.80F, "Grande", "./Images/doubleLatteGrand.png");
        // Les accompagnements
        Produit proGrandesCrousties = new Produit("GRANDES CROUSTIES", 2.90F, "Grand", "./Images/grandesCrousties.png");
        Produit proMoyenneCrousties = new Produit("MOYENNE CROUSTIES", 2.50F, "Moyen", "./Images/Croustie.png");
        Produit proGrandeFrite = new Produit("GRANDE FRITE", 2.90F, "Grand", "./Images/grandesFrites.png");
        Produit proMoyenneFrite = new Produit("MOYENNE FRITE", 2.50F, "Moyen", "./Images/moyenneFrite.png");
        Produit proPetiteFrite = new Produit("PETITE FRITE", 1.95F, "Normal", "./Images/petiteFrite.png");
        Produit proPtiteSalade = new Produit("La P'tite Salade", 3F, "Moyen", "./Images/PtiteSalade.png");
        // Les sauces
        Produit proSauceBarbecue = new Produit("BARBECUE", 0.20F, "nuggets", "", 0, "./Images/sauceBbq.png");
        Produit proSauceChinoise = new Produit("CHINOISE", 0.20F, "nuggets", "", 0, "./Images/sauceChinoise.png");
        Produit proSauceCurry = new Produit("CURRY", 0.20F, "nuggets", "", 0, "./Images/sauceCurry.png");
        Produit proVinaigretteAHuile = new Produit("VINAIGRETTE A L'HUILE DE NOISETTE", 0.20F, "sauce salade", "", 0, "./Images/vinaigretteAHuileDeNoisette.png");
        Produit proSaucePommeFrites = new Produit("SAUCE POMME FRITES", 0.05F, "./Images/saucePommeFrites.png");
        Produit proKetchup = new Produit("KETCHUP", 0.05F, "./Images/Ketchup.png");
        // Les desserts
        Produit proSundaeNature = new Produit("SUNDAE NATURE", 2.70F, "./Images/sundayNature.png");
        Produit proSundaeChocolat = new Produit("SUNDAE NAPPAGE SAVEUR CHOCOLAT", 2.70F, "./Images/SundaeChocolat.png");
        Produit proSundaeCaramel = new Produit("SUNDAE NAPPAGE SAVEUR CARAMEL", 2.70F, "./Images/SundaeCaramel.png");
        Produit proSundaeAbricot = new Produit("SUNDAE NAPPAGE SAVEUR ABRICOT", 2.70F, "./Images/SundaeAbricot.png");
        Produit proMcFlurryKitKat = new Produit("McFLURRY KIKAT", 3.20F,"nappage","",0, "./Images/mcFlurryKitKat.png");
        Produit proMcFlurryDaim = new Produit("McFLURRY DAIM", 3.20F,"nappage","",0,  "./Images/mcFlurryDaim.png");
        Produit proMcFlurryOreo = new Produit("McFLURRY OREO", 3.20F,"nappage","",0,  "./Images/mcFlurryOreo.png");
        Produit proMcFlurrySpeculoos = new Produit("McFLURRY SPECULOOS", 3.20F,"nappage","",0,  "./Images/mcFlurrySpeculos.png");
        Produit proVeryParfaitCoulisAbricot = new Produit("VERY PARFAIT COULIS ABRICOT", 3.30F, "./Images/veryParfaitAbricot.jpg");
        Produit proVeryParfaitNature = new Produit("VERY PARFAIT NATURE", 3.30F, "./Images/veryParfaitNature.png");
        Produit proVeryParfaitNappageSaveurChocolat = new Produit("VERY PARFAIT NAPPAGE SAVEUR CHOCOLAT ", 3.30F, "./Images/veryParfaitChocolat.png");
        Produit proVeryParfaitNappageSaveurCaramel = new Produit("VERY PARFAIT NAPPAGE SAVEUR CARAMEL", 3.30F, "./Images/veryParfaitCaramel.png");
        Produit proFrappeSaveurChocolat = new Produit("FRAPPE SAVEUR CHOCOLAT", 2F, "./Images/frappeSaveurChocolat.png");
        Produit proFrappeSaveurMarshmallow = new Produit("FRAPPE SAVEUR MARSHMALLOW", 2F, "./Images/frappeMarshmallow.jpg");
        Produit proFrappeSaveurVanille = new Produit("FRAPPE SAVEUR VANILLE", 2F, "./Images/frappeVanille.png");
        Produit proFrappeSaveurMyrtille = new Produit("FRAPPE ", 2F, "./Images/frapeMyrtille.png");
        Produit proCornetNappageChocolat = new Produit("LE CORNET NAPPAGE SAVEUR CHOCOLAT", 2F, "./Images/leCornetNappageSaveurChocolat.png");

        Produit proBerlingoFruitPommePeche = new Produit("BERLINGO'FRUITS POMME PÊCHE", 1.60F, "./Images/berlingoPommePeche.jpg");
        Produit proBioABoire = new Produit("BIO A BOIRE FRUITS ROUGES", 1.80F, "./Images/bioFruitRouge.png");

        Produit proPetitDuoRaisins = new Produit("PETIT DUO DE RAISINS", 2F, "./Images/petitBioRaisin.png");
        Produit proLePetitMuffinPepiteChocolat = new Produit("P'TIT MUFFIN AUX PÉPITES DE CHOCOLAT", "./Images/muffinChocolat.png");
        Produit proDonnutNature = new Produit("DONUT NATURE", 1.50F, "./Images/donnutNature.png");
        Produit proDonutSaveurChocolat = new Produit("DONUT SAVEUR CHOCOLAT", 2F, "./Images/donnutChocolat.png");
        Produit proBrownieChocolatNoisettes = new Produit("BROWNIE CHOCOLAT NOISETTES", 2F, "./Images/brownieChocolatNoisette.png");

        Produit proLivre = new Produit("LIVRE", 2.50F, "./Images/livre.png");
        Produit proJouetGarcon = new Produit("JOUET GARCON", 2.5F, "./Images/jouet.png");
        Produit proJouetFille = new Produit("JOUET FILLE", 2.5F, "./Images/jouet.png");

        //---------- TYPES ----------
        Type typPrincipal = new Type("Principal", "./Images/");
        Type typAccompagnement = new Type("Accompagnement", "./Images/");
        Type typBoisson = new Type("Boisson", "./Images/NosBoisons.png");
        Type typDessert = new Type("Dessert", "./Images/NosDesserts.png");
        Type typSauce = new Type("Sauce", "./Images/NosFrites&Sauces.png");
        Type typCadeauEnfant = new Type("Cadeau Enfant", "./Images/");

        //---------- SOUS TYPES ----------
        SousType souBurger = new SousType("Burger", "./Images/NosBurger.png");
        SousType souSalade = new SousType("Salade", "./Images/NosSalades.png");
        SousType souFroide = new SousType("Froide", "./Images/");
        SousType souChaude = new SousType("Chaude", "./Images/");
        SousType souSauce = new SousType("Sauce", "./Images/NosFrites&Sauces.png");
        SousType souAboire = new SousType("A Boire", "./Images/NosDessert.png");
        SousType souGlace = new SousType("Glace", "./Images/");
        SousType souFruits = new SousType("Fruits", "./Images/");
        SousType souGateau = new SousType("Gateau", "./Images/");
        SousType souPommeDeTerre = new SousType("Pommes de Terre", "./Images/");
        SousType souGarcon = new SousType("Garçon", "./Images/");
        SousType souFille = new SousType("Fille", "./Images/");
        SousType souNouveaute = new SousType("Nouveaute", "./Images/");

        //---------- ITEMS A RAJOUTER ----------
        ItemARajouter itARaNappageChocolat = new ItemARajouter("Nappage Chocolat", 0.2F, "./Images/chocolat.jpg");
        ItemARajouter itARaNappageCaramel = new ItemARajouter("Nappage Caramel", 0.2F, "./Images/caramel.png");
        ItemARajouter itARaNappageAbricot = new ItemARajouter("Coulis Abricot", 0.2F, "./Images/coulisabricot.jpg");

        //---------- ITEMS A RETIRER ----------
        ItemARetirer itaeSteak = new ItemARetirer("Steak", "8", "./Images/steak.png");
        ItemARetirer itaeFrommage = new ItemARetirer("Fromage", "6", "./Images/cheddar.png");
        ItemARetirer itaeFrommageChevre = new ItemARetirer("Chèvre", "6", "./Images/chevre.png");
        ItemARetirer itaeFrommageBleu = new ItemARetirer("Bleu", "6", "./Images/fromagebleu.png");
        ItemARetirer itaeSalade = new ItemARetirer("Salade", "2", "./Images/Salade.jpg");
        ItemARetirer itaeOignon = new ItemARetirer("Oignon", "4", "./Images/oignon.jpg");
        ItemARetirer itaeCornichon = new ItemARetirer("Cornichon", "5", "./Images/cornichon.png");
        ItemARetirer itaeTomate = new ItemARetirer("Tomate", "3", "./Images/tomate.jpg");
        ItemARetirer itaePoisson = new ItemARetirer("Poisson", "8", "./Images/pane2.png");
        ItemARetirer itaePoulet = new ItemARetirer("Poulet", "8", "./Images/pane2.png");
        ItemARetirer itaeBacon = new ItemARetirer("Bacon", "7", "./Images/bacon.png");
        ItemARetirer itaeCacahuètes = new ItemARetirer("Cacahuètes", "0", "./Images/cacahuet.jpg");
        ItemARetirer itaeJambon = new ItemARetirer("Jambon", "8", "./Images/jambon.jpg");
        ItemARetirer itaeSauce = new ItemARetirer("Sauce", "9", "./Images/Ketchup.png");

        //---------- INGREDIENTS ----------
        Ingredient ingPain = new Ingredient("pain");

        //---------- ALLERGENES ----------
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

        //---------- STATUT ----------
        Statut staDisponible = new Statut(1L, "Disponible");
        Statut staEpuise = new Statut(2L, "Epuisé");
        Statut staQuantiteLimitee = new Statut(3L, "Quantité limitée");
        Statut staNouveau = new Statut(4L, "Nouveaute");
        Statut staReaprovisionnement = new Statut(5L, "En réapprovisionnement");
        Statut statAnnuler = new Statut(6L, "Annulé");
        Statut staValider = new Statut(7L, "Validé");
        Statut staEnPreparation = new Statut(8L, "En préparation");
        Statut staPayerAccepter = new Statut(10L, "Paiement accepté");
        Statut staPayerRefuser = new Statut(11L, "Paiement refusé");
        Statut staEnAttente = new Statut(12L, "En attente");
        Statut staAllergene = new Statut(13L, "Allergene");
        Statut staCompteAbonne = new Statut(14L, "Compte valide");
        Statut staIndisponible = new Statut(15L, "Indisponible");

        //---------- TVA ----------
        Tva tvaNormal = new Tva(0.1F);

        //---------- ABONNES ----------
        Abonne aboNourdine = new Abonne("nourdine@nourdine.com", "BOUSSAID", 35, "Nourdine", "nourdine@nourdine.com");
        Abonne aboThierry = new Abonne("thierry@thierry.com", "MARTINEZ", 5, "Thierry", "thierry@thierry.com");
        Abonne aboEdem = new Abonne("edem@edem.com", "ANNANI TOULASSI", 0, "Edem", "edem@edem.com");
        Abonne aboAlex = new Abonne("alex@alex.com", "CHARBIT", 80, "Alex", "alex@alex.com");
        Abonne aboMomo = new Abonne("momo@momo.com", "EL MASTOUR", 33, "Momo", "momo@momo.com");

// -----------------------------------------------------------------------------        
//                            LES ASSOCIATIONS
// ----------------------------------------------------------------------------- 
        // ItemARajouter vers produit
        itARaNappageAbricot.getProduits().add(proMcFlurryDaim);
        itARaNappageAbricot.getProduits().add(proMcFlurryKitKat);
        itARaNappageAbricot.getProduits().add(proMcFlurryOreo);
        itARaNappageAbricot.getProduits().add(proMcFlurrySpeculoos);

        itARaNappageCaramel.getProduits().add(proMcFlurryDaim);
        itARaNappageCaramel.getProduits().add(proMcFlurryKitKat);
        itARaNappageCaramel.getProduits().add(proMcFlurryOreo);
        itARaNappageCaramel.getProduits().add(proMcFlurrySpeculoos);

        itARaNappageChocolat.getProduits().add(proMcFlurryDaim);
        itARaNappageChocolat.getProduits().add(proMcFlurryKitKat);
        itARaNappageChocolat.getProduits().add(proMcFlurryOreo);
        itARaNappageChocolat.getProduits().add(proMcFlurrySpeculoos);
        // Produit vers ItemARajouter

        proMcFlurryDaim.setItemARajouter(itARaNappageAbricot);
//        proMcFlurryDaim.getItemARajoutes().add(itARaNappageCaramel);
//        proMcFlurryDaim.getItemARajoutes().add(itARaNappageChocolat);
//
        proMcFlurryKitKat.setItemARajouter(itARaNappageAbricot);
//        proMcFlurryKitKat.getItemARajoutes().add(itARaNappageCaramel);
//        proMcFlurryKitKat.getItemARajoutes().add(itARaNappageChocolat);
//
        proMcFlurryOreo.setItemARajouter(itARaNappageAbricot);
//        proMcFlurryOreo.getItemARajoutes().add(itARaNappageCaramel);
//        proMcFlurryOreo.getItemARajoutes().add(itARaNappageChocolat);
//
        proMcFlurrySpeculoos.setItemARajouter(itARaNappageAbricot);
//        proMcFlurrySpeculoos.getItemARajoutes().add(itARaNappageCaramel);
//        proMcFlurrySpeculoos.getItemARajoutes().add(itARaNappageChocolat);

        // Les ingrédients
        ingPain.setProduit(proBigMac);
        ingPain.setProduit(proPoissonRanch);
        ingPain.setProduit(proPouletRanch);
        ingPain.setProduit(proBoeufRanch);
        ingPain.setProduit(proDoubleBlueCheese);
        ingPain.setProduit(proBeefBbq);
        ingPain.setProduit(proChickenBbq);
        ingPain.setProduit(proRoyalDeLuxe);
        ingPain.setProduit(proMcWrap);
        ingPain.setProduit(proMcFish);
        ingPain.setProduit(proCroqueMcDo);
        ingPain.setProduit(proHamburger);
        ingPain.setProduit(proCheeseBurger);
        //**********
        proBigMac.getIngredients().add(ingPain);
        proPoissonRanch.getIngredients().add(ingPain);
        proPouletRanch.getIngredients().add(ingPain);
        proBoeufRanch.getIngredients().add(ingPain);
        proDoubleBlueCheese.getIngredients().add(ingPain);
        proBeefBbq.getIngredients().add(ingPain);
        proChickenBbq.getIngredients().add(ingPain);
        proRoyalDeLuxe.getIngredients().add(ingPain);
        proMcWrap.getIngredients().add(ingPain);
        proMcFish.getIngredients().add(ingPain);
        proCroqueMcDo.getIngredients().add(ingPain);
        proHamburger.getIngredients().add(ingPain);
        proCheeseBurger.getIngredients().add(ingPain);

        // Les allergènes
        allAnhydride.getProduits().add(proBigMac);
        allAnhydride.getProduits().add(proPouletRanch);
        allAnhydride.getProduits().add(proBoeufRanch);
        allAnhydride.getProduits().add(proSummer);
        allAnhydride.getProduits().add(proNewYorkCaesar);
        allAnhydride.getProduits().add(proManhattanVeggie);
        allAnhydride.getProduits().add(proHamburger);
        allAnhydride.getProduits().add(proCheeseBurger);

        allGluten.getProduits().add(proBigMac);
        allGluten.getProduits().add(proPoissonRanch);
        allGluten.getProduits().add(proPouletRanch);
        allGluten.getProduits().add(proBoeufRanch);
        allGluten.getProduits().add(proChickenMcNuggets4);
        allGluten.getProduits().add(proChickenMcNuggets6);
        allGluten.getProduits().add(proChickenMcNuggets9);
        allGluten.getProduits().add(proChickenMcNuggets20);
        allGluten.getProduits().add(proSummer);
        allGluten.getProduits().add(proNewYorkCaesar);
        allGluten.getProduits().add(proManhattanVeggie);
        allGluten.getProduits().add(proManhattan);
        allGluten.getProduits().add(proManhattanPouletCroustillant);
        allGluten.getProduits().add(proDoubleBlueCheese);
        allGluten.getProduits().add(proBeefBbq);
        allGluten.getProduits().add(proChickenBbq);
        allGluten.getProduits().add(proRoyalDeLuxe);
        allGluten.getProduits().add(proMcWrap);
        allGluten.getProduits().add(proMcFish);
        allGluten.getProduits().add(proCroqueMcDo);
        allGluten.getProduits().add(proHamburger);
        allGluten.getProduits().add(proCheeseBurger);

        allGraineDeSesame.getProduits().add(proBigMac);
        allGraineDeSesame.getProduits().add(proPoissonRanch);
        allGraineDeSesame.getProduits().add(proPouletRanch);
        allGraineDeSesame.getProduits().add(proBoeufRanch);
        allGraineDeSesame.getProduits().add(proSummer);
        allGraineDeSesame.getProduits().add(proNewYorkCaesar);
        allGraineDeSesame.getProduits().add(proManhattanVeggie);
        allGraineDeSesame.getProduits().add(proManhattanPouletCroustillant);
        allGraineDeSesame.getProduits().add(proDoubleBlueCheese);
        allGraineDeSesame.getProduits().add(proBeefBbq);
        allGraineDeSesame.getProduits().add(proChickenBbq);
        allGraineDeSesame.getProduits().add(proRoyalDeLuxe);
        allGraineDeSesame.getProduits().add(proMcFish);
        allGraineDeSesame.getProduits().add(proCroqueMcDo);
        allGraineDeSesame.getProduits().add(proHamburger);
        allGraineDeSesame.getProduits().add(proCheeseBurger);

        allArachide.getProduits().add(proManhattanPouletFrit);
        allArachide.getProduits().add(proManhattanPouletCroustillant);

        allCeleri.getProduits().add(proPouletRanch);
        allCeleri.getProduits().add(proChickenMcNuggets4);
        allCeleri.getProduits().add(proChickenMcNuggets6);
        allCeleri.getProduits().add(proChickenMcNuggets9);
        allCeleri.getProduits().add(proChickenMcNuggets20);
        allCeleri.getProduits().add(proSummer);
        allCeleri.getProduits().add(proManhattanVeggie);
        allCeleri.getProduits().add(proManhattan);
        allCeleri.getProduits().add(proManhattanPouletCroustillant);
        allCeleri.getProduits().add(proChickenBbq);
        allCeleri.getProduits().add(proMcWrap);
        allCeleri.getProduits().add(proMcFish);

        allCrustaces.getProduits().add(proMcFish);

        allFruitsACoques.getProduits().add(proNewYorkCaesar);
        allFruitsACoques.getProduits().add(proManhattanPouletFrit);
        allFruitsACoques.getProduits().add(proManhattanPouletCroustillant);

        allLait.getProduits().add(proBigMac);
        allLait.getProduits().add(proPoissonRanch);
        allLait.getProduits().add(proPouletRanch);
        allLait.getProduits().add(proBoeufRanch);
        allLait.getProduits().add(proChickenMcNuggets4);
        allLait.getProduits().add(proChickenMcNuggets6);
        allLait.getProduits().add(proChickenMcNuggets9);
        allLait.getProduits().add(proChickenMcNuggets20);
        allLait.getProduits().add(proSummer);
        allLait.getProduits().add(proNewYorkCaesar);
        allLait.getProduits().add(proManhattanPouletFrit);
        allLait.getProduits().add(proManhattanVeggie);
        allLait.getProduits().add(proManhattan);
        allLait.getProduits().add(proDoubleBlueCheese);
        allLait.getProduits().add(proBeefBbq);
        allLait.getProduits().add(proChickenBbq);
        allLait.getProduits().add(proRoyalDeLuxe);
        allLait.getProduits().add(proMcWrap);
        allLait.getProduits().add(proMcFish);
        allLait.getProduits().add(proCroqueMcDo);
        allLait.getProduits().add(proHamburger);
        allLait.getProduits().add(proCheeseBurger);

        allMoutarde.getProduits().add(proBigMac);
        allMoutarde.getProduits().add(proPouletRanch);
        allMoutarde.getProduits().add(proBoeufRanch);
        allMoutarde.getProduits().add(proChickenMcNuggets4);
        allMoutarde.getProduits().add(proChickenMcNuggets6);
        allMoutarde.getProduits().add(proChickenMcNuggets9);
        allMoutarde.getProduits().add(proChickenMcNuggets20);
        allMoutarde.getProduits().add(proSummer);
        allMoutarde.getProduits().add(proNewYorkCaesar);
        allMoutarde.getProduits().add(proManhattanPouletFrit);
        allMoutarde.getProduits().add(proManhattanVeggie);
        allMoutarde.getProduits().add(proManhattan);
        allMoutarde.getProduits().add(proManhattanPouletCroustillant);
        allMoutarde.getProduits().add(proChickenBbq);
        allMoutarde.getProduits().add(proRoyalDeLuxe);
        allMoutarde.getProduits().add(proMcWrap);
        allMoutarde.getProduits().add(proHamburger);
        allMoutarde.getProduits().add(proCheeseBurger);

        allOeufs.getProduits().add(proBigMac);
        allOeufs.getProduits().add(proPoissonRanch);
        allOeufs.getProduits().add(proPouletRanch);
        allOeufs.getProduits().add(proBoeufRanch);
        allOeufs.getProduits().add(proChickenMcNuggets4);
        allOeufs.getProduits().add(proChickenMcNuggets6);
        allOeufs.getProduits().add(proChickenMcNuggets9);
        allOeufs.getProduits().add(proChickenMcNuggets20);
        allOeufs.getProduits().add(proSummer);
        allOeufs.getProduits().add(proNewYorkCaesar);
        allOeufs.getProduits().add(proManhattanPouletFrit);
        allOeufs.getProduits().add(proManhattanVeggie);
        allOeufs.getProduits().add(proManhattan);
        allOeufs.getProduits().add(proManhattanPouletCroustillant);
        allOeufs.getProduits().add(proDoubleBlueCheese);
        allOeufs.getProduits().add(proBeefBbq);
        allOeufs.getProduits().add(proChickenBbq);
        allOeufs.getProduits().add(proRoyalDeLuxe);
        allOeufs.getProduits().add(proMcWrap);

        allPoissons.getProduits().add(proPoissonRanch);
        allPoissons.getProduits().add(proNewYorkCaesar);
        allPoissons.getProduits().add(proMcFish);

        allSoja.getProduits().add(proSummer);
        allSoja.getProduits().add(proNewYorkCaesar);
        allSoja.getProduits().add(proManhattanVeggie);
        allSoja.getProduits().add(proManhattan);
        allSoja.getProduits().add(proBeefBbq);
        allSoja.getProduits().add(proChickenBbq);
        allSoja.getProduits().add(proMcWrap);

        // Les produit vers items à retirer
        proBigMac.getItemARetires().add(itaeSauce);
        proBigMac.getItemARetires().add(itaeSalade);
        proBigMac.getItemARetires().add(itaeOignon);
        proBigMac.getItemARetires().add(itaeCornichon);
        proBigMac.getItemARetires().add(itaeFrommage);
        proBigMac.getItemARetires().add(itaeSteak);

        proPoissonRanch.getItemARetires().add(itaeSauce);
        proPoissonRanch.getItemARetires().add(itaeSalade);
        proPoissonRanch.getItemARetires().add(itaeTomate);
        proPoissonRanch.getItemARetires().add(itaeFrommage);
        proPoissonRanch.getItemARetires().add(itaePoisson);

        proPouletRanch.getItemARetires().add(itaeSauce);
        proPouletRanch.getItemARetires().add(itaeSalade);
        proPouletRanch.getItemARetires().add(itaeOignon);
        proPouletRanch.getItemARetires().add(itaeCornichon);
        proPouletRanch.getItemARetires().add(itaeFrommage);
        proPouletRanch.getItemARetires().add(itaePoulet);

        proBoeufRanch.getItemARetires().add(itaeSauce);
        proBoeufRanch.getItemARetires().add(itaeSalade);
        proBoeufRanch.getItemARetires().add(itaeOignon);
        proBoeufRanch.getItemARetires().add(itaeTomate);
        proBoeufRanch.getItemARetires().add(itaeFrommage);
        proBoeufRanch.getItemARetires().add(itaeSteak);

        proDoubleBlueCheese.getItemARetires().add(itaeSauce);
        proDoubleBlueCheese.getItemARetires().add(itaeOignon);
        proDoubleBlueCheese.getItemARetires().add(itaeBacon);
        proDoubleBlueCheese.getItemARetires().add(itaeFrommageBleu);
        proDoubleBlueCheese.getItemARetires().add(itaeSteak);

        proBeefBbq.getItemARetires().add(itaeSauce);
        proBeefBbq.getItemARetires().add(itaeOignon);
        proBeefBbq.getItemARetires().add(itaeBacon);
        proBeefBbq.getItemARetires().add(itaeFrommage);
        proBeefBbq.getItemARetires().add(itaeSteak);

        proChickenBbq.getItemARetires().add(itaeSauce);
        proChickenBbq.getItemARetires().add(itaeSalade);
        proChickenBbq.getItemARetires().add(itaeOignon);
        proChickenBbq.getItemARetires().add(itaeFrommage);
        proChickenBbq.getItemARetires().add(itaePoulet);

        proRoyalDeLuxe.getItemARetires().add(itaeSauce);
        proRoyalDeLuxe.getItemARetires().add(itaeSalade);
        proRoyalDeLuxe.getItemARetires().add(itaeOignon);
        proRoyalDeLuxe.getItemARetires().add(itaeTomate);
        proRoyalDeLuxe.getItemARetires().add(itaeFrommage);
        proRoyalDeLuxe.getItemARetires().add(itaeSteak);

        proMcWrap.getItemARetires().add(itaeSauce);
        proMcWrap.getItemARetires().add(itaeSalade);
        proMcWrap.getItemARetires().add(itaeOignon);
        proMcWrap.getItemARetires().add(itaeTomate);
        proMcWrap.getItemARetires().add(itaeFrommageChevre);

        proMcFish.getItemARetires().add(itaeSauce);
        proMcFish.getItemARetires().add(itaePoisson);

        proCroqueMcDo.getItemARetires().add(itaeSauce);
        proCroqueMcDo.getItemARetires().add(itaeFrommage);
        proCroqueMcDo.getItemARetires().add(itaeJambon);

        proHamburger.getItemARetires().add(itaeSauce);
        proHamburger.getItemARetires().add(itaeOignon);
        proHamburger.getItemARetires().add(itaeCornichon);
        proHamburger.getItemARetires().add(itaeSteak);

        proCheeseBurger.getItemARetires().add(itaeSauce);
        proCheeseBurger.getItemARetires().add(itaeOignon);
        proCheeseBurger.getItemARetires().add(itaeCornichon);
        proCheeseBurger.getItemARetires().add(itaeFrommage);
        proCheeseBurger.getItemARetires().add(itaeSteak);

        //**************** itemaretirer vers produit ********************
        itaeSteak.getProduits().add(proBigMac);
        itaeSteak.getProduits().add(proBoeufRanch);
        itaeSteak.getProduits().add(proDoubleBlueCheese);
        itaeSteak.getProduits().add(proBeefBbq);
        itaeSteak.getProduits().add(proRoyalDeLuxe);
        itaeSteak.getProduits().add(proHamburger);
        itaeSteak.getProduits().add(proCheeseBurger);

        itaeFrommage.getProduits().add(proBigMac);
        itaeFrommage.getProduits().add(proPoissonRanch);
        itaeFrommage.getProduits().add(proPouletRanch);
        itaeFrommage.getProduits().add(proBoeufRanch);
        itaeFrommage.getProduits().add(proDoubleBlueCheese);

        itaeFrommage.getProduits().add(proBeefBbq);
        itaeFrommage.getProduits().add(proChickenBbq);
        itaeFrommage.getProduits().add(proRoyalDeLuxe);
        itaeFrommage.getProduits().add(proCroqueMcDo);
        itaeFrommage.getProduits().add(proCheeseBurger);

        itaeFrommageBleu.getProduits().add(proDoubleBlueCheese);

        itaeFrommageChevre.getProduits().add(proMcWrap);

        itaeSalade.getProduits().add(proBigMac);
        itaeSalade.getProduits().add(proPoissonRanch);
        itaeSalade.getProduits().add(proPouletRanch);
        itaeSalade.getProduits().add(proBoeufRanch);
        itaeSalade.getProduits().add(proChickenBbq);
        itaeSalade.getProduits().add(proBeefBbq);
        itaeSalade.getProduits().add(proRoyalDeLuxe);
        itaeSalade.getProduits().add(proMcWrap);

        itaeOignon.getProduits().add(proBigMac);
        itaeOignon.getProduits().add(proPouletRanch);
        itaeOignon.getProduits().add(proBoeufRanch);
        itaeOignon.getProduits().add(proDoubleBlueCheese);
        itaeOignon.getProduits().add(proBeefBbq);
        itaeOignon.getProduits().add(proChickenBbq);
        itaeOignon.getProduits().add(proRoyalDeLuxe);
        itaeOignon.getProduits().add(proMcWrap);
        itaeOignon.getProduits().add(proHamburger);
        itaeOignon.getProduits().add(proCheeseBurger);

        itaeCornichon.getProduits().add(proBigMac);
        itaeCornichon.getProduits().add(proPouletRanch);
        itaeCornichon.getProduits().add(proHamburger);
        itaeCornichon.getProduits().add(proCheeseBurger);

        itaeTomate.getProduits().add(proPoissonRanch);
        itaeTomate.getProduits().add(proBoeufRanch);
        itaeTomate.getProduits().add(proRoyalDeLuxe);
        itaeTomate.getProduits().add(proMcWrap);

        itaePoisson.getProduits().add(proPoissonRanch);

        itaePoulet.getProduits().add(proPouletRanch);
        itaePoulet.getProduits().add(proChickenBbq);

        itaeBacon.getProduits().add(proDoubleBlueCheese);
        itaeBacon.getProduits().add(proBeefBbq);

        itaeJambon.getProduits().add(proCroqueMcDo);

        itaeSauce.getProduits().add(proBigMac);
        itaeSauce.getProduits().add(proPouletRanch);
        itaeSauce.getProduits().add(proBoeufRanch);
        itaeSauce.getProduits().add(proPoissonRanch);
        itaeSauce.getProduits().add(proDoubleBlueCheese);
        itaeSauce.getProduits().add(proBeefBbq);
        itaeSauce.getProduits().add(proChickenBbq);
        itaeSauce.getProduits().add(proRoyalDeLuxe);
        itaeSauce.getProduits().add(proMcWrap);
        itaeSauce.getProduits().add(proMcFish);
        itaeSauce.getProduits().add(proCroqueMcDo);
        itaeSauce.getProduits().add(proHamburger);
        itaeSauce.getProduits().add(proCheeseBurger);

        // Les sous types
        souBurger.setType(typPrincipal);
        souSalade.setType(typPrincipal);
        souFroide.setType(typBoisson);
        souChaude.setType(typBoisson);
        souSauce.setType(typSauce);
        souAboire.setType(typDessert);
        souGlace.setType(typDessert);
        souFruits.setType(typDessert);
        souGateau.setType(typDessert);
        souPommeDeTerre.setType(typAccompagnement);
        souGarcon.setType(typCadeauEnfant);
        souFille.setType(typCadeauEnfant);

        // Les types
        typPrincipal.getMenus().add(menBigMacBest);
        typPrincipal.getMenus().add(menBigMacMaxiBest);
        typPrincipal.getMenus().add(menChickMacNugx6);
        typPrincipal.getMenus().add(menHappyMeal);
        typPrincipal.getMenus().add(menPtitDej);
        typPrincipal.getMenus().add(menSalade);
        typPrincipal.getMenus().add(menSignatureBest);

        typBoisson.getMenus().add(menBigMacBest);
        typBoisson.getMenus().add(menBigMacMaxiBest);
        typBoisson.getMenus().add(menChickMacNugx6);
        typBoisson.getMenus().add(menHappyMeal);
        typBoisson.getMenus().add(menPtitDej);
        typBoisson.getMenus().add(menSalade);
        typBoisson.getMenus().add(menSignatureBest);

        typAccompagnement.getMenus().add(menBigMacBest);
        typAccompagnement.getMenus().add(menBigMacMaxiBest);
        typAccompagnement.getMenus().add(menChickMacNugx6);
        typAccompagnement.getMenus().add(menHappyMeal);
        typAccompagnement.getMenus().add(menPtitDej);
        typAccompagnement.getMenus().add(menSalade);
        typAccompagnement.getMenus().add(menSignatureBest);

        typSauce.getMenus().add(menChickMacNugx6);

        typCadeauEnfant.getMenus().add(menHappyMeal);

        // Les produits
        proBeefBbq.setSoustype(souBurger);
        proBigMac.setSoustype(souBurger);
        proBoeufRanch.setSoustype(souBurger);
        proCheeseBurger.setSoustype(souBurger);
        proChickenBbq.setSoustype(souBurger);
        proChickenMcNuggets20.setSoustype(souBurger);
        proChickenMcNuggets9.setSoustype(souBurger);
        proChickenMcNuggets6.setSoustype(souBurger);
        proChickenMcNuggets4.setSoustype(souBurger);
        proCroqueMcDo.setSoustype(souBurger);
        proDoubleBlueCheese.setSoustype(souBurger);
        proHamburger.setSoustype(souBurger);
        proMcFish.setSoustype(souBurger);
        proMcWrap.setSoustype(souBurger);
        proPoissonRanch.setSoustype(souBurger);
        proPouletRanch.setSoustype(souBurger);
        proRoyalDeLuxe.setSoustype(souBurger);

        proManhattan.setSoustype(souSalade);
        proManhattanPouletCroustillant.setSoustype(souSalade);
        proManhattanPouletFrit.setSoustype(souSalade);
        proManhattanVeggie.setSoustype(souSalade);
        proNewYorkCaesar.setSoustype(souSalade);
        proSummer.setSoustype(souSalade);
        proPtiteSalade.setSoustype(souSalade);
        proBadoit33.setSoustype(souFroide);
        proBadoit50.setSoustype(souFroide);
        proCocaCola25.setSoustype(souFroide);
        proCocaCola40.setSoustype(souFroide);
        proCocaCola50.setSoustype(souFroide);
        proCocaColaLight25.setSoustype(souFroide);
        proCocaColaLight40.setSoustype(souFroide);
        proCocaColaLight50.setSoustype(souFroide);
        proCocaColaZero25.setSoustype(souFroide);
        proCocaColaZero40.setSoustype(souFroide);
        proCocaColaZero50.setSoustype(souFroide);
        proEvian33.setSoustype(souFroide);
        proEvian50.setSoustype(souFroide);
        proFanta25.setSoustype(souFroide);
        proFanta40.setSoustype(souFroide);
        proFanta50.setSoustype(souFroide);
        proLiptonIceTea25.setSoustype(souFroide);
        proMinuteMaid20.setSoustype(souFroide);
        proSpriteZero25.setSoustype(souFroide);
        proSpriteZero40.setSoustype(souFroide);
        proSpriteZero50.setSoustype(souFroide);

        proCappuccinDaimGrand.setSoustype(souChaude);
        proCappuccino.setSoustype(souChaude);
        proCappuccinoDaim.setSoustype(souChaude);
        proCappuccinoGrand.setSoustype(souChaude);
        proChocolatChaud.setSoustype(souChaude);
        proDoubleLatte.setSoustype(souChaude);
        proRistretto.setSoustype(souChaude);
        proExpresso.setSoustype(souChaude);
        proGrandCafe.setSoustype(souChaude);
        proGrandCafeGrand.setSoustype(souChaude);
        proLatteMacchiato.setSoustype(souChaude);
        proNoisette.setSoustype(souChaude);
        proTheGrey.setSoustype(souChaude);
        proTheGreyGrand.setSoustype(souChaude);
        proTheRougeGrand.setSoustype(souChaude);
        proTheVert.setSoustype(souChaude);
        proTheVertGrand.setSoustype(souChaude);
        proDoubleLatteGrand.setSoustype(souChaude);

        proKetchup.setSoustype(souSauce);
        proSauceBarbecue.setSoustype(souSauce);
        proSauceChinoise.setSoustype(souSauce);
        proSauceCurry.setSoustype(souSauce);
        proSaucePommeFrites.setSoustype(souSauce);
        proVinaigretteAHuile.setSoustype(souSauce);

        proCornetNappageChocolat.setSoustype(souGlace);
        proFrappeSaveurChocolat.setSoustype(souGlace);
        proFrappeSaveurMarshmallow.setSoustype(souGlace);
        proFrappeSaveurMyrtille.setSoustype(souGlace);
        proFrappeSaveurVanille.setSoustype(souGlace);
        proSundaeAbricot.setSoustype(souGlace);
        proSundaeCaramel.setSoustype(souGlace);
        proSundaeChocolat.setSoustype(souGlace);
        proSundaeNature.setSoustype(souGlace);
        proMcFlurryDaim.setSoustype(souGlace);
        proMcFlurryKitKat.setSoustype(souGlace);
        proMcFlurryOreo.setSoustype(souGlace);
        proMcFlurrySpeculoos.setSoustype(souGlace);
        proVeryParfaitCoulisAbricot.setSoustype(souGlace);
        proVeryParfaitNappageSaveurCaramel.setSoustype(souGlace);
        proVeryParfaitNappageSaveurChocolat.setSoustype(souGlace);
        proVeryParfaitNature.setSoustype(souGlace);

        proPetitDuoRaisins.setSoustype(souFruits);
        proBioABoire.setSoustype(souAboire);
        proBerlingoFruitPommePeche.setSoustype(souAboire);

        proBrownieChocolatNoisettes.setSoustype(souGateau);
        proDonnutNature.setSoustype(souGateau);
        proDonutSaveurChocolat.setSoustype(souGateau);
        proLePetitMuffinPepiteChocolat.setSoustype(souGateau);
        proGrandeFrite.setSoustype(souPommeDeTerre);
        proMoyenneFrite.setSoustype(souPommeDeTerre);
        proPetiteFrite.setSoustype(souPommeDeTerre);
        proGrandesCrousties.setSoustype(souPommeDeTerre);
        proMoyenneCrousties.setSoustype(souPommeDeTerre);
        proJouetGarcon.setSoustype(souGarcon);
        proJouetFille.setSoustype(souFille);
        proLivre.setSoustype(souFille);
        proLivre.setSoustype(souGarcon);

        // Les menus
        menBigMacBest.getTypes().add(typPrincipal);
        menBigMacBest.getTypes().add(typAccompagnement);
        menBigMacBest.getTypes().add(typBoisson);

        menBigMacMaxiBest.getTypes().add(typPrincipal);
        menBigMacMaxiBest.getTypes().add(typAccompagnement);
        menBigMacMaxiBest.getTypes().add(typBoisson);

        menChickMacNugx6.getTypes().add(typSauce);
        menChickMacNugx6.getTypes().add(typPrincipal);
        menChickMacNugx6.getTypes().add(typAccompagnement);
        menChickMacNugx6.getTypes().add(typBoisson);
//        
        menHappyMeal.getTypes().add(typPrincipal);
        menHappyMeal.getTypes().add(typBoisson);
        menHappyMeal.getTypes().add(typAccompagnement);
        menHappyMeal.getTypes().add(typDessert);
        menHappyMeal.getTypes().add(typCadeauEnfant);

        menPtitDej.getTypes().add(typPrincipal);
        menPtitDej.getTypes().add(typAccompagnement);
        menPtitDej.getTypes().add(typBoisson);

        menSalade.getTypes().add(typPrincipal);
        menSalade.getTypes().add(typBoisson);
        menSalade.getTypes().add(typSauce);

        menSignatureBest.getTypes().add(typAccompagnement);
        menSignatureBest.getTypes().add(typBoisson);
        menSignatureBest.getTypes().add(typPrincipal);

        // Statut vers Produits
        proMoyenneCrousties.setStatut(staNouveau);
        proGrandesCrousties.setStatut(staNouveau);
        menSignatureBest.setStatut(staNouveau);

// -----------------------------------------------------------------------------        
//                              LES PERSIST
// ----------------------------------------------------------------------------- 
        // Les statuts
        em.persist(staAllergene);
        em.persist(staCompteAbonne);
        em.persist(staDisponible);
        em.persist(staEnAttente);
        em.persist(staEnPreparation);
        em.persist(staEpuise);
        em.persist(staIndisponible);
        em.persist(staIndisponible);
        em.persist(staNouveau);
        em.persist(staPayerAccepter);
        em.persist(staPayerRefuser);
        em.persist(staQuantiteLimitee);
        em.persist(staReaprovisionnement);
        em.persist(staValider);
        em.persist(statAnnuler);

        // Les Items à rajouter
        em.persist(itARaNappageChocolat);
        em.persist(itARaNappageCaramel);
        em.persist(itARaNappageAbricot);

        // Les items à retirer
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
        em.persist(itaeJambon);
        em.persist(itaeSauce);
        em.persist(itaeFrommageBleu);
        em.persist(itaeFrommageChevre);

        // Les produits
        em.persist(proVeryParfaitCoulisAbricot);
        em.persist(proVeryParfaitNappageSaveurCaramel);
        em.persist(proVeryParfaitNappageSaveurChocolat);
        em.persist(proPtiteSalade);
        em.persist(ingPain);
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
        em.persist(proCocaColaZero25);
        em.persist(proCocaColaZero40);
        em.persist(proCocaColaZero50);
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
        em.persist(proTheRougeGrand);
        em.persist(proTheVertGrand);
        em.persist(proTheVert);
        em.persist(proTheGrey);
        em.persist(proTheGreyGrand);
        em.persist(proGrandCafe);
        em.persist(proGrandCafeGrand);
        em.persist(proCappuccino);
        em.persist(proCappuccinoGrand);
        em.persist(proCappuccinoDaim);
        em.persist(proCappuccinDaimGrand);
        em.persist(proDoubleLatte);
        em.persist(proDoubleLatteGrand);
        em.persist(proLatteMacchiato);
        em.persist(proExpresso);
        em.persist(proNoisette);
        em.persist(proRistretto);
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
        em.persist(proLePetitMuffinPepiteChocolat);
        em.persist(proSundaeNature);
        em.persist(proSundaeChocolat);
        em.persist(proSundaeCaramel);
        em.persist(proSundaeAbricot);
        em.persist(proMcFlurryKitKat);
        em.persist(proMcFlurryDaim);
        em.persist(proDonutSaveurChocolat);
        em.persist(proBrownieChocolatNoisettes);
        em.persist(proMcFlurryOreo);
        em.persist(proMcFlurrySpeculoos);
        em.persist(proBerlingoFruitPommePeche);
//        em.persist(proVeryParfaitCoulisAbricot);
        em.persist(proVeryParfaitNature);
//        em.persist(proVeryParfaitNappageSaveurChocolat);
//        em.persist(proVeryParfaitNappageSaveurCaramel);
        em.persist(proFrappeSaveurChocolat);
        em.persist(proFrappeSaveurMarshmallow);
        em.persist(proFrappeSaveurVanille);
        em.persist(proFrappeSaveurMyrtille);
        em.persist(proLivre);
        em.persist(proJouetGarcon);
        em.persist(proJouetFille);

        // La TVA
        em.persist(tvaNormal);
        //em.persist(tvaSurPlace);

        // Les types
        em.persist(typPrincipal);
        em.persist(typAccompagnement);
        em.persist(typBoisson);
        em.persist(typDessert);
        em.persist(typSauce);
        em.persist(typCadeauEnfant);

        // Les abonnés
        em.persist(aboNourdine);
        em.persist(aboThierry);
        em.persist(aboEdem);
        em.persist(aboAlex);
        em.persist(aboMomo);

        // Les allergènes
        em.persist(allAnhydride);
        em.persist(allArachide);
        em.persist(allCeleri);
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

        // Les ingrédients
        em.persist(ingPain);

        // Les menus
        em.persist(menBigMacBest);
        em.persist(menBigMacMaxiBest);
        em.persist(menChickMacNugx6);
        em.persist(menHappyMeal);
        em.persist(menPtitDej);
        em.persist(menSalade);
        em.persist(menSignatureBest);

        // Les sous types
        em.persist(souNouveaute);
        em.persist(souBurger);
        em.persist(souAboire);
        em.persist(souChaude);
        em.persist(souFroide);
        em.persist(souFruits);
        em.persist(souGateau);
        em.persist(souGlace);
        em.persist(souPommeDeTerre);
        em.persist(souSalade);
        em.persist(souSauce);
        em.persist(souGarcon);
        em.persist(souFille);

// ----------------------------------- Edem ------------------------------------
        // ********* TVA vers Produits *********
        TypedQuery<Produit> querryProduit = em.createNamedQuery("entities.Produit.selectAll", Produit.class);
        List<Produit> listProduit = querryProduit.getResultList();
        for (Produit p : listProduit) {
            p.setTva(tvaNormal);
        }

        // ********* TVA vers Menu *********
        TypedQuery<Menu> querryMenu = em.createNamedQuery("entities.Menu.selectAll", Menu.class);
        List<Menu> listMenu = querryMenu.getResultList();
        for (Menu m : listMenu) {
            m.setTva(tvaNormal);
        }

    }
}
