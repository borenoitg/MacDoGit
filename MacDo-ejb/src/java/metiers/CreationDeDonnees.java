package metiers;

import entites.Abonne;
import entites.Allergene;
import entites.Commande;
import entites.Ingredient;
import entites.ItemARajoute;
import entites.ItemARetire;
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

@Singleton
public class CreationDeDonnees implements CreationDeDonneesLocal {

    @PersistenceContext(unitName = "MacDo-ejbPU")
    private EntityManager em;

    @Override
    public void creationDonnees() {

        // ************************ CREATION DES OBJETS ************************
// -------------------------------- Thierry ------------------------------------
        //*********************** Ingredient *********************** 
        Ingredient pain = new Ingredient("pain");

        // ********* Les ItemsARajoute *********
        ItemARajoute itARaNappageChocolat = new ItemARajoute("Nappage Chocolat", 0.2F);
        ItemARajoute itARaNappageCaramel = new ItemARajoute("Nappage Caramel", 0.2F);
        ItemARajoute itARaNappageAbricot = new ItemARajoute("Nappage Abricot", 0.2F);
        ItemARajoute i = new ItemARajoute();

        // ********* Les Produits *********
        Produit proBigMac = new Produit("Big Mac", 4.3F, "Le seul, l'unique\n Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable. Pain spécial, steaks hachés, salade, oignon, cornichon, fromage fondu, sauce.", "Normal", 0, "./Images/BigMac.jpg");
        Produit proPoissonRanch = new Produit("Poisson Ranch", 3.5F, "Le nouveau McFirst™ Poisson Ranch. Pain spécial aux graines de sésame et de pavot, spécialité panée au poisson, cheddar fondu, oignons, salade, ketchup, sauce Ranch. poisson = préparation de poisson pané. Durée limitée.", "Normal", 0, "./Images/poissonRanch.png");
        Produit proBoeufRanch = new Produit("Boeuf Ranch Moutarde", 3.5F, "Pain spécial aux graines de sésame et de pavot, steaks hachés, cheddar fondu, oignons, salade, tomate, moutarde, sauce Ranch.", "Normal", 0, "./Images/boeufRanch.png");
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

// ----------------------------------- Edem ------------------------------------
        // ********* La TVA *********
        Tva tvaNormal = new Tva(0.1F);
        //Tva tvaSurPlace = new Tva(0.2F);

        // ********* Les ItemsARetirer *********
        ItemARetire itaeSteak = new ItemARetire("Steak", "./Images/");
        ItemARetire itaeFrommage = new ItemARetire("Frommage", "./Images/");
        ItemARetire itaeSalade = new ItemARetire("Salade", "./Images/");
        ItemARetire itaeOignon = new ItemARetire("Oignon", "./Images/");
        ItemARetire itaeCornichon = new ItemARetire("Cornichon", "./Images/");
        ItemARetire itaeTomate = new ItemARetire("Tomate", "./Images/");
        ItemARetire itaePoisson = new ItemARetire("Poisson", "./Images/");
        ItemARetire itaePoulet = new ItemARetire("Poulet", "./Images/");
        ItemARetire itaeBacon = new ItemARetire("Bacon", "./Images/");
        ItemARetire itaeCacahuètes = new ItemARetire("Cacahuètes", "./Images/");
        ItemARetire itaeJambon = new ItemARetire("Jambon", "./Images/");

        // ********* Les Produits *********
        Produit proTheRouge = new Produit("THÉ FRUITS ROUGES GRAND FORMAT", 2.70F, "./Images/theFruitRouge.png");
        Produit proTheVertGrand = new Produit("THÉ VERT A LA MENTHE GRAND FORMAT", 2.70F, "./Images/theMenthe.png");
        proTheVertGrand.setTaille("Grande");
        Produit proTheVert = new Produit("THÉ VERT A LA MENTHE", 2.20F, "./Images/theMenthe.png");
        Produit proTheGrey = new Produit("THÉ EARL GREY", 2.20F, "./Images/theGrey.png");
        Produit proTheGreyGrand = new Produit("THÉ EARL GREY GRAND FORMAT", 2.70F, "./Images/theGrey.png");
        //******************
        Produit proGrandCafe = new Produit("GRAND CAFE", 2F, "./Images/grandCafe.png");
        Produit proGrandCafeGrand = new Produit("GRAND CAFE GRAND FORMAT", 2.5F, "./Images/grandCafeGrandFormat.jpg");
        proGrandCafeGrand.setTaille("Grande");
        //******************
        Produit proCappuccino = new Produit("CAPPUCCINO", 2.40F, "./Images/cappuccino.png");
        Produit proCappuccinoGrand = new Produit("CAPPUCCINO GRAND FORMAT", 2.90F, "./Images/cappuccinoGrand.png");
        proCappuccinoGrand.setTaille("Grande");
        //******************
        Produit proCappuccinoDaim = new Produit("CAPPUCCINO DAIM", 2.50F, "./Images/cappuccinoDaim.jpg");
        Produit proCappuccinDaimoGrand = new Produit("CAPPUCCINO DAIM GRAND FORMAT", 3F, "./Images/cappuccinoDaimGrand.png");
        proCappuccinDaimoGrand.setTaille("Grande");
        //******************
        Produit proDoubleLatte = new Produit("DOUBLE LATTE", 2.30F, "./Images/doubleLatte.jpg");
        Produit proproDoubleLatteGrand = new Produit("DOUBLE LATTE GRAND FORMAT", 2.80F, "./Images/doubleLatteGrand.png");
        proproDoubleLatteGrand.setTaille("Grande");
        //******************
        Produit proLatteMacchiato = new Produit("LATTE MACCHIATO SAVEUR CHOCOLAT", 2.5F, "./Images/LatteMacchiatoSaveurChocolat.png");
        Produit proExpresso = new Produit("EXPRESSO", 1.5F, "./Images/expresso.jpg");
        Produit proNoisette = new Produit("NOISETTE", 1.70F, "./Images/noisette.jpg");
        Produit proRISTRETTO = new Produit("RISTRETTO", 1.50F, "./Images/ristrtto.jpg");
        Produit proChocolatChaud = new Produit("CHOCOLAT CHAUD", 2.20F, "./Images/chocolatChaud.jpg");
        //******************
        Produit proGrandesCrousties = new Produit("GRANDES CROUSTIES", 2.90F, "./Images/grandesCrousties.png");
        proGrandesCrousties.setTaille("Grande");
        Produit proMoyenneCrousties = new Produit("MOYENNE CROUSTIES", 2.5F, "./Images/Croustie.png");
        proMoyenneCrousties.setTaille("Moyenne");
        Produit proMoyenneFrite = new Produit("MOYENNE FRITE", 2.90F, "./Images/moyenneFrite.png");
        proMoyenneFrite.setTaille("Moyenne");
        Produit proGrandeFrite = new Produit("GRANDE FRITE", 2.5F, "./Images/grandesFrites.png");
        proGrandeFrite.setTaille("Grande");
        Produit proPetiteFrite = new Produit("PETITE FRITE", 1.95F, "./Images/petiteFrite.png");
        proPetiteFrite.setTaille("Petite");
        //******************
        Produit proSauceBarbecue = new Produit("SAUCE CLASSIC BARBECUE", 0.20F, "./Images/sauceBbq.png");
        Produit proSauceChinoise = new Produit("SAUCE CHINOISE", 0.20F, "./Images/sauceChinoise.png");
        Produit proSauceCurry = new Produit("SAUCE CURRY", 0.20F, "./Images/sauceCurry.png");
        Produit proVinaigretteAHuile = new Produit("VINAIGRETTE A L'HUILE DE NOISETTE", 0.20F, "./Images/vinaigretteAHuileDeNoisette.png");
        Produit proSaucePommeFrites = new Produit("SAUCE POMME FRITES", "./Images/saucePommeFrites.png");
        Produit proKetchup = new Produit("KETCHUP", "./Images/Ketchup.png");
        //******************
        Produit proBioABoire = new Produit("BIO A BOIRE FRUITS ROUGES", 1.80F, "./Images/bioFruitRouge.png");
        Produit proPetitDuoRaisins = new Produit("PETIT DUO DE RAISINS", 2F, "./Images/petitBioRaisin.png");
        Produit proCornetNappageChocolat = new Produit("LE CORNET NAPPAGE SAVEUR CHOCOLAT", 2F, "./Images/leCornetNappageSaveurChocolat.png");
        Produit proLePetitMuffinPepiteChocolat = new Produit("P'TIT MUFFIN AUX PÉPITES DE CHOCOLAT", "./Images/muffinChocolat.png");
        Produit proSundaeNature = new Produit("SUNDAE NATURE", 2.70F, "./Images/sundayNature.png");
        Produit proSundaeChocolat = new Produit("SUNDAE NAPPAGE SAVEUR CHOCOLAT", 2.70F, "./Images/SundaeChocolat.png");
        Produit proSundaeCaramel = new Produit("SUNDAE NAPPAGE SAVEUR CARAMEL", 2.70F, "./Images/SundaeCaramel.png");
        Produit proLeSundaeAbricot = new Produit("SUNDAE NAPPAGE SAVEUR ABRICOT", 2.70F, "./Images/SundaeAbricot.png");
        Produit proMcFlurryKitKat = new Produit("McFLURRY KIKAT", 3.20F, "./Images/mcFlurryKitKat.png");
        Produit proMcFlurryDaim = new Produit("McFLURRY DAIM", 3.20F, "./Images/mcFlurryDaim.png");
        Produit proMcFlurryOreo = new Produit("McFLURRY OREO", 3.20F, "./Images/mcFlurryOreo.png");
        Produit proMcFlurrySpeculoos = new Produit("McFLURRY SPECULOOS", 3.20F, "./Images/mcFlurrySpeculos.png");
        Produit proVeryParfaitCoulisAbricot = new Produit("VERY PARFAIT COULIS ABRICOT", 3.30F, "./Images/veryParfaitAbricot.jpg");
        Produit proVeryParfaitNature = new Produit("VERY PARFAIT NATURE", 3.30F, "./Images/veryParfaitNature.png");
        Produit proVeryParfaitNappageSaveurChocolat = new Produit("VERY PARFAIT NAPPAGE SAVEUR CHOCOLAT ", 3.30F, "./Images/veryParfaitChocolat.png");
        Produit proVeryParfaitNappageSaveurCaramel = new Produit("VERY PARFAIT NAPPAGE SAVEUR CARAMEL", 3.30F, "./Images/veryParfaitCaramel.png");
        Produit proFrappeSaveurChocolat = new Produit("FRAPPE SAVEUR CHOCOLAT", 2F, "./Images/frappeSaveurChocolat.png");
        Produit proFrappeSaveurMarshmallow = new Produit("FRAPPE SAVEUR MARSHMALLOW", 2F, "./Images/frappeMarshmallow.jpg");
        Produit proFrappeSaveurVanille = new Produit("FRAPPE SAVEUR VANILLE", 2F, "./Images/frappeVanille.png");
        Produit proFrappeSaveurMyrtille = new Produit("FRAPPE ", 2F, "./Images/frapeMyrtille.png");
        Produit proDonnutNature = new Produit("DONUT NATURE", 1.5F, "./Images/donnutNature.png");
        Produit proDonutSaveurChocolat = new Produit("DONUT SAVEUR CHOCOLAT", 2F, "./Images/donnutChocolat.png");
        Produit proBrownieChocolatNoisettes = new Produit("BROWNIE CHOCOLAT NOISETTES", 2F, "./Images/brownieChocolatNoisette.png");
        Produit proBerlingoFruitPommePeche = new Produit("BERLINGO'FRUITS POMME PÊCHE", 1.60F, "./Images/berlingoPommePeche.jpg");
        //******************
        Produit proLivre = new Produit("LIVRE", 0.72F, "./Images/livre.png");
        Produit proJouetGarcon = new Produit("JOUET GARCON", 2.5F, "./Images/jouet.png");
        Produit proJouetFille = new Produit("JOUET FILLE", 2.5F, "./Images/jouet.png");

// ---------------------------------Nourdine------------------------------------
        // ********* Les types *********
        Type typPrincipal = new Type("principal");
        Type typAccompagnement = new Type("Accompagnement");
        Type typBoisson = new Type("Boisson");
        Type typDessert = new Type("Dessert");
        Type typSauce = new Type("Sauce");
        Type typCadeauEnfant = new Type("Cadeau Enfant");

        //********* Les abonnés *********
        Abonne aboNourdine = new Abonne("nourdine@nourdine.com", "BOUSSAID", 35, "Nourdine", "nourdine@nourdine.com");
        Abonne aboThierry = new Abonne("thierry@thierry.com", "MARTINEZ", 5, "Thierry", "thierry@thierry.com");
        Abonne aboEdem = new Abonne("edem@edem.com", "ANNANI TOULASSI", 0, "Edem", "edem@edem.com");
        Abonne aboAlex = new Abonne("alex@alex.com", "CHARBIT", 80, "Alex", "alex@alex.com");
        Abonne aboMomo = new Abonne("momo@momo.com", "EL MASTOUR", 33, "Momo", "momo@momo.com");

        // ********* Les allergènes *********
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

// ----------------------------------- Alexandre -------------------------------
        //Creation des objets
        Menu menHappyMeal = new Menu("Menu HappyMeal", 5.50F);
        Menu menBigMac = new Menu("Menu BigMac", 8.90f);
        Menu menBigMacMaxi = new Menu("Menu BigMac Maxi Best Of", 8.00F);
        Menu menSalade = new Menu("Menu Salade", 6.50F);
        Menu menChickMacNug = new Menu("Menu ChickenMcNuggets", 7.50F);
        Menu menPtitDej = new Menu("Menu P'tit f", 7.30F);
        Menu menSignature = new Menu("Menu GrandChickenClassic", 8.30F);
// ----------------------------------- Momo ------------------------------------
 //Creation des objets
        
        //satut
        Statut staDisponible = new Statut(1L,"disponible");
        
        Statut staEpuise = new Statut(2L,"epuisé");
        Statut staQuaniteLimte = new Statut(3L,"quantité limité");
        Statut staNouveau = new Statut(4L,"nouveau");
        Statut staReaprovisionnement = new Statut(5L,"en réapprovisionnement");
        Statut statAnnuler = new Statut(6L,"Annuler");
        Statut staValider = new Statut(7L,"Valider");
        Statut staEnPreparation = new Statut(8L,"en préparation");
        Statut staPayerAccepter = new Statut(10L,"paiment accepté");
        Statut staPayerRefuser = new Statut(11L,"paiment refusé");
        Statut staEnAttente = new Statut(12L,"En attente");
        Statut staAllergene = new Statut(13L,"Allergene");
        Statut staCompteAbonne = new Statut(14L,"Compte valide");
        Statut staIndisponible = new Statut(15L,"indisponible");
        
        //ligne de commande
        LigneDeCommande ligMenuHappyMeal = new LigneDeCommande(20f,1,5.5f);
        LigneDeCommande ligBigMac = new LigneDeCommande(20f,1,4.3f);
        
        LigneDeCommande ligBigMac1 = new LigneDeCommande(20f,1,4.3f);
//        LigneDeCommande ligMenuBigMacMaxi = new LigneDeCommande(20f,2,8f);
//        LigneDeCommande ligMenuSalade = new LigneDeCommande(20f,1,6.5f);
//        LigneDeCommande ligMenuPetitDej = new LigneDeCommande(20f,1,7.3f);
//        LigneDeCommande ligMenuSignature = new LigneDeCommande(20f,3,8.3f); 
//        LigneDeCommande ligProChickenMcNuggets6 = new LigneDeCommande(20f,3,4.2f);
        
       
        
        //sousligne de commande
        SousLigneDeCommande souLigne1 = new SousLigneDeCommande();
        SousLigneDeCommande souLigne2 = new SousLigneDeCommande();
        SousLigneDeCommande souLigne3 = new SousLigneDeCommande();
        
        
        
        
        //commande
        Date d = new GregorianCalendar(2018,2,15).getTime();
        Commande co1 = new Commande(d,true);
        
        Commande co2 = new Commande(d,true);
        
        
        
        
        
         
        
        
        //Associations
        ligMenuHappyMeal.setMenu(menHappyMeal);
        ligBigMac.setProduit(proBigMac);
        ligBigMac1.setProduit(proBigMac);
        
        souLigne1.setLigneCommande(ligMenuHappyMeal);
        souLigne1.setCommande(co1);
        proMcFish.setSousLigneDeCommande(souLigne1);
        proCocaCola25.setSousLigneDeCommande(souLigne1);
        proPetiteFrite.setSousLigneDeCommande(souLigne1);
        proSundaeCaramel.setSousLigneDeCommande(souLigne1);
        
        
        itaeSalade.setSousLigneDeCommande(souLigne1);
        itARaNappageAbricot.setSousLigneDeCommande(souLigne1);
        
        
//        proBigMac.setSousLigneDeCommande(souLigne1);
        co1.setStatut(staEnPreparation);
//        System.out.println(" souligne1 "+souLigne1.getProduits().size());
        
        
        souLigne2.setLigneCommande(ligBigMac);
        souLigne2.setCommande(co1);
        proBigMac.setSousLigneDeCommande(souLigne2);
//      
       
  
        
        
        //Persist
        //statut
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
        em.persist(staQuaniteLimte);
        em.persist(staReaprovisionnement);
        em.persist(staValider);
        em.persist(statAnnuler);
        
     
        em.persist(ligMenuHappyMeal);
//        ;
        em.persist(ligBigMac);
//     
       em.persist(souLigne1);
       em.persist(souLigne2);
       em.persist(co1);
//        System.out.println(" souligne1 "+souLigne1.getProduits().size());

//

//        Promotion p01 = new Promotion("2 Menus HappyMeal pour 6 Euros");
//        Promotion p02 = new Promotion("2 Menus MaxiBestOf  pour 12 Euros");
//        Promotion p03 = new Promotion("2 Menus HappyMeal pour 6 Euros");
//        Promotion p04 = new Promotion("1 MacCafé pour 1 Euro pour tout menu acheté !");
        SousType souBurger = new SousType("Burger");
        SousType souSalade = new SousType("Salade");
        SousType souFroide = new SousType("Froide");
        SousType souChaude = new SousType("Chaude");
        SousType souSauce = new SousType("Sauce");
        SousType souAboire = new SousType("A Boire");
        SousType souGlace = new SousType("Glace");
        SousType souFruits = new SousType("Fruits");
        SousType souGateau = new SousType("Gateau");
        SousType souPommeDeTerre = new SousType("Pommes de Terre");
        
        /***************************************************************************************************************************/
        /***************************************************************************************************************************/
        /***************************************************************************************************************************/
        

        // ******************** ASSOCIATION DES DONNEES ************************
// ----------------------------------- Edem ------------------------------------
        // ********* McFleury vers Items à rajouter *********
        itARaNappageAbricot.getProduits().add(proMcFlurryDaim);
        itARaNappageAbricot.getProduits().add(proMcFlurryKitKat);
        itARaNappageAbricot.getProduits().add(proMcFlurryOreo);
        itARaNappageAbricot.getProduits().add(proMcFlurrySpeculoos);
        //******************
        itARaNappageCaramel.getProduits().add(proMcFlurryDaim);
        itARaNappageCaramel.getProduits().add(proMcFlurryKitKat);
        itARaNappageCaramel.getProduits().add(proMcFlurryOreo);
        itARaNappageCaramel.getProduits().add(proMcFlurrySpeculoos);
        //******************
        itARaNappageChocolat.getProduits().add(proMcFlurryDaim);
        itARaNappageChocolat.getProduits().add(proMcFlurryKitKat);
        itARaNappageChocolat.getProduits().add(proMcFlurryOreo);
        itARaNappageChocolat.getProduits().add(proMcFlurrySpeculoos);

// ---------------------------------Nourdine------------------------------------

// ----------------------------------- Momo ------------------------------------
// -------------------------------- Thierry ------------------------------------
        proBigMac.getAllergenes().add(allAnhydride);
        proBigMac.getAllergenes().add(allGluten);
        proBigMac.getAllergenes().add(allGraineDeSesame);
        proBigMac.getAllergenes().add(allLait);
        proBigMac.getAllergenes().add(allMoutarde);
        proBigMac.getAllergenes().add(allOeufs);

        proBigMac.getIngredients().add(pain);

        proBigMac.getItemARetires().add(itaeSteak);
        proBigMac.getItemARetires().add(itaeSalade);
        proBigMac.getItemARetires().add(itaeFrommage);
        proBigMac.getItemARetires().add(itaeOignon);
        proBigMac.getItemARetires().add(itaeCornichon);

        proPoissonRanch.getAllergenes().add(allGluten);
        proPoissonRanch.getAllergenes().add(allGraineDeSesame);
        proPoissonRanch.getAllergenes().add(allLait);
        proPoissonRanch.getAllergenes().add(allOeufs);
        proPoissonRanch.getAllergenes().add(allPoissons);

        proPoissonRanch.getIngredients().add(pain);

        proPoissonRanch.getItemARetires().add(itaeFrommage);
        proPoissonRanch.getItemARetires().add(itaeSalade);
        proPoissonRanch.getItemARetires().add(itaeTomate);
        proPoissonRanch.getItemARetires().add(itaePoisson);

        proPouletRanch.getAllergenes().add(allGluten);
        proPouletRanch.getAllergenes().add(allCeleri);
        proPouletRanch.getAllergenes().add(allAnhydride);
        proPouletRanch.getAllergenes().add(allGraineDeSesame);
        proPouletRanch.getAllergenes().add(allLait);
        proPouletRanch.getAllergenes().add(allMoutarde);
        proPouletRanch.getAllergenes().add(allOeufs);

        proPouletRanch.getIngredients().add(pain);

        proPouletRanch.getItemARetires().add(itaeFrommage);
        proPouletRanch.getItemARetires().add(itaeSalade);
        proPouletRanch.getItemARetires().add(itaeOignon);
        proPouletRanch.getItemARetires().add(itaeCornichon);
        proPouletRanch.getItemARetires().add(itaePoulet);

        proBoeufRanch.getAllergenes().add(allGluten);
        proBoeufRanch.getAllergenes().add(allAnhydride);
        proBoeufRanch.getAllergenes().add(allGraineDeSesame);
        proBoeufRanch.getAllergenes().add(allLait);
        proBoeufRanch.getAllergenes().add(allMoutarde);
        proBoeufRanch.getAllergenes().add(allOeufs);

        proBoeufRanch.getIngredients().add(pain);

        proBoeufRanch.getItemARetires().add(itaeSteak);
        proBoeufRanch.getItemARetires().add(itaeSalade);
        proBoeufRanch.getItemARetires().add(itaeFrommage);
        proBoeufRanch.getItemARetires().add(itaeOignon);
        proBoeufRanch.getItemARetires().add(itaeTomate);

        proChickenMcNuggets4.getAllergenes().add(allGluten);
        proChickenMcNuggets4.getAllergenes().add(allCeleri);
        proChickenMcNuggets4.getAllergenes().add(allLait);
        proChickenMcNuggets4.getAllergenes().add(allMoutarde);
        proChickenMcNuggets4.getAllergenes().add(allOeufs);

        proChickenMcNuggets6.getAllergenes().add(allGluten);
        proChickenMcNuggets6.getAllergenes().add(allCeleri);
        proChickenMcNuggets6.getAllergenes().add(allLait);
        proChickenMcNuggets6.getAllergenes().add(allMoutarde);
        proChickenMcNuggets6.getAllergenes().add(allOeufs);

        proChickenMcNuggets9.getAllergenes().add(allGluten);
        proChickenMcNuggets9.getAllergenes().add(allCeleri);
        proChickenMcNuggets9.getAllergenes().add(allLait);
        proChickenMcNuggets9.getAllergenes().add(allMoutarde);
        proChickenMcNuggets9.getAllergenes().add(allOeufs);

        proChickenMcNuggets20.getAllergenes().add(allGluten);
        proChickenMcNuggets20.getAllergenes().add(allCeleri);
        proChickenMcNuggets20.getAllergenes().add(allLait);
        proChickenMcNuggets20.getAllergenes().add(allMoutarde);
        proChickenMcNuggets20.getAllergenes().add(allOeufs);

        proSummer.getAllergenes().add(allAnhydride);
        proSummer.getAllergenes().add(allCeleri);
        proSummer.getAllergenes().add(allGluten);
        proSummer.getAllergenes().add(allGraineDeSesame);
        proSummer.getAllergenes().add(allLait);
        proSummer.getAllergenes().add(allMoutarde);
        proSummer.getAllergenes().add(allOeufs);
        proSummer.getAllergenes().add(allSoja);

        proNewYorkCaesar.getAllergenes().add(allAnhydride);
        proNewYorkCaesar.getAllergenes().add(allFruitsACoques);
        proNewYorkCaesar.getAllergenes().add(allGluten);
        proNewYorkCaesar.getAllergenes().add(allGraineDeSesame);
        proNewYorkCaesar.getAllergenes().add(allLait);
        proNewYorkCaesar.getAllergenes().add(allMoutarde);
        proNewYorkCaesar.getAllergenes().add(allOeufs);
        proNewYorkCaesar.getAllergenes().add(allPoissons);
        proNewYorkCaesar.getAllergenes().add(allSoja);

        proManhattanPouletFrit.getAllergenes().add(allArachide);
        proManhattanPouletFrit.getAllergenes().add(allFruitsACoques);
        proManhattanPouletFrit.getAllergenes().add(allLait);
        proManhattanPouletFrit.getAllergenes().add(allMoutarde);
        proManhattanPouletFrit.getAllergenes().add(allOeufs);

        proManhattanVeggie.getAllergenes().add(allAnhydride);
        proManhattanVeggie.getAllergenes().add(allCeleri);
        proManhattanVeggie.getAllergenes().add(allGluten);
        proManhattanVeggie.getAllergenes().add(allGraineDeSesame);
        proManhattanVeggie.getAllergenes().add(allLait);
        proManhattanVeggie.getAllergenes().add(allMoutarde);
        proManhattanVeggie.getAllergenes().add(allOeufs);
        proManhattanVeggie.getAllergenes().add(allSoja);

        proManhattan.getAllergenes().add(allCeleri);
        proManhattan.getAllergenes().add(allGluten);
        proManhattan.getAllergenes().add(allLait);
        proManhattan.getAllergenes().add(allMoutarde);
        proManhattan.getAllergenes().add(allOeufs);
        proManhattan.getAllergenes().add(allSoja);

        proManhattanPouletCroustillant.getAllergenes().add(allArachide);
        proManhattanPouletCroustillant.getAllergenes().add(allCeleri);
        proManhattanPouletCroustillant.getAllergenes().add(allFruitsACoques);
        proManhattanPouletCroustillant.getAllergenes().add(allGluten);
        proManhattanPouletCroustillant.getAllergenes().add(allGraineDeSesame);
        proManhattanPouletCroustillant.getAllergenes().add(allMoutarde);
        proManhattanPouletCroustillant.getAllergenes().add(allOeufs);

        proSignature280OriginalBeef.getAllergenes().add(allGluten);
        proSignature280OriginalBeef.getAllergenes().add(allAnhydride);
        proSignature280OriginalBeef.getAllergenes().add(allGraineDeSesame);
        proSignature280OriginalBeef.getAllergenes().add(allLait);
        proSignature280OriginalBeef.getAllergenes().add(allMoutarde);
        proSignature280OriginalBeef.getAllergenes().add(allOeufs);

        proSignature280OriginalBeef.getIngredients().add(pain);

        proSignature280OriginalBeef.getItemARetires().add(itaeSteak);
        proSignature280OriginalBeef.getItemARetires().add(itaeFrommage);
        proSignature280OriginalBeef.getItemARetires().add(itaeSalade);
        proSignature280OriginalBeef.getItemARetires().add(itaeOignon);
        proSignature280OriginalBeef.getItemARetires().add(itaeCornichon);

        proDoubleBlueCheese.getAllergenes().add(allGluten);
        proDoubleBlueCheese.getAllergenes().add(allGraineDeSesame);
        proDoubleBlueCheese.getAllergenes().add(allLait);
        proDoubleBlueCheese.getAllergenes().add(allOeufs);

        proDoubleBlueCheese.getIngredients().add(pain);

        proDoubleBlueCheese.getItemARetires().add(itaeSteak);
        proDoubleBlueCheese.getItemARetires().add(itaeFrommage);
        proDoubleBlueCheese.getItemARetires().add(itaeOignon);
        proDoubleBlueCheese.getItemARetires().add(itaeBacon);

        proBeefBbq.getAllergenes().add(allGluten);
        proBeefBbq.getAllergenes().add(allGraineDeSesame);
        proBeefBbq.getAllergenes().add(allLait);
        proBeefBbq.getAllergenes().add(allOeufs);
        proBeefBbq.getAllergenes().add(allSoja);

        proBeefBbq.getIngredients().add(pain);

        proBeefBbq.getItemARetires().add(itaeSteak);
        proBeefBbq.getItemARetires().add(itaeFrommage);
        proBeefBbq.getItemARetires().add(itaeOignon);
        proBeefBbq.getItemARetires().add(itaeBacon);

        proChickenBbq.getAllergenes().add(allCeleri);
        proChickenBbq.getAllergenes().add(allGluten);
        proChickenBbq.getAllergenes().add(allGraineDeSesame);
        proChickenBbq.getAllergenes().add(allLait);
        proChickenBbq.getAllergenes().add(allMoutarde);
        proChickenBbq.getAllergenes().add(allOeufs);
        proChickenBbq.getAllergenes().add(allSoja);

        proChickenBbq.getIngredients().add(pain);

        proChickenBbq.getItemARetires().add(itaePoulet);
        proChickenBbq.getItemARetires().add(itaeFrommage);
        proChickenBbq.getItemARetires().add(itaeSalade);
        proChickenBbq.getItemARetires().add(itaeOignon);

        proRoyalDeLuxe.getAllergenes().add(allGluten);
        proRoyalDeLuxe.getAllergenes().add(allGraineDeSesame);
        proRoyalDeLuxe.getAllergenes().add(allLait);
        proRoyalDeLuxe.getAllergenes().add(allMoutarde);
        proRoyalDeLuxe.getAllergenes().add(allOeufs);

        proRoyalDeLuxe.getIngredients().add(pain);

        proRoyalDeLuxe.getItemARetires().add(itaeSteak);
        proRoyalDeLuxe.getItemARetires().add(itaeFrommage);
        proRoyalDeLuxe.getItemARetires().add(itaeSalade);
        proRoyalDeLuxe.getItemARetires().add(itaeOignon);
        proRoyalDeLuxe.getItemARetires().add(itaeTomate);

        proMcWrap.getAllergenes().add(allCeleri);
        proMcWrap.getAllergenes().add(allGluten);
        proMcWrap.getAllergenes().add(allLait);
        proMcWrap.getAllergenes().add(allMoutarde);
        proMcWrap.getAllergenes().add(allOeufs);
        proMcWrap.getAllergenes().add(allSoja);

        proMcWrap.getItemARetires().add(itaeFrommage);
        proMcWrap.getItemARetires().add(itaeSalade);
        proMcWrap.getItemARetires().add(itaeOignon);
        proMcWrap.getItemARetires().add(itaeTomate);

        proMcFish.getAllergenes().add(allCeleri);
        proMcFish.getAllergenes().add(allCrustaces);
        proMcFish.getAllergenes().add(allGluten);
        proMcFish.getAllergenes().add(allGraineDeSesame);
        proMcFish.getAllergenes().add(allLait);
        proMcFish.getAllergenes().add(allPoissons);
        proMcFish.getAllergenes().add(allSoja);

        proMcFish.getIngredients().add(pain);

        proMcFish.getItemARetires().add(itaePoisson);

        proCroqueMcDo.getAllergenes().add(allGluten);
        proCroqueMcDo.getAllergenes().add(allGraineDeSesame);
        proCroqueMcDo.getAllergenes().add(allLait);

        proCroqueMcDo.getIngredients().add(pain);

        proCroqueMcDo.getItemARetires().add(itaeFrommage);
        proCroqueMcDo.getItemARetires().add(itaeJambon);

        proHamburger.getAllergenes().add(allAnhydride);
        proHamburger.getAllergenes().add(allGluten);
        proHamburger.getAllergenes().add(allGraineDeSesame);
        proHamburger.getAllergenes().add(allLait);
        proHamburger.getAllergenes().add(allMoutarde);

        proHamburger.getIngredients().add(pain);

        proHamburger.getItemARetires().add(itaeSteak);
        proHamburger.getItemARetires().add(itaeOignon);
        proHamburger.getItemARetires().add(itaeCornichon);

        proCheeseBurger.getAllergenes().add(allAnhydride);
        proCheeseBurger.getAllergenes().add(allGluten);
        proCheeseBurger.getAllergenes().add(allGraineDeSesame);
        proCheeseBurger.getAllergenes().add(allLait);
        proCheeseBurger.getAllergenes().add(allMoutarde);

        proCheeseBurger.getIngredients().add(pain);

        proCheeseBurger.getItemARetires().add(itaeSteak);
        proCheeseBurger.getItemARetires().add(itaeOignon);
        proCheeseBurger.getItemARetires().add(itaeCornichon);
        proCheeseBurger.getItemARetires().add(itaeFrommage);
// ----------------------------------- Alexandre -------------------------------
        //Associations
        menBigMac.getTypes().add(typPrincipal);
        menBigMac.getTypes().add(typAccompagnement);
        menBigMac.getTypes().add(typBoisson);

        menBigMacMaxi.getTypes().add(typPrincipal);
        menBigMacMaxi.getTypes().add(typAccompagnement);
        menBigMacMaxi.getTypes().add(typBoisson);

        menChickMacNug.getTypes().add(typPrincipal);
        menBigMacMaxi.getTypes().add(typAccompagnement);
        menBigMacMaxi.getTypes().add(typBoisson);

        menChickMacNug.getTypes().add(typSauce);
        menChickMacNug.getTypes().add(typPrincipal);
        menChickMacNug.getTypes().add(typAccompagnement);
        menChickMacNug.getTypes().add(typBoisson);

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

        menSignature.getTypes().add(typAccompagnement);
        menSignature.getTypes().add(typBoisson);
        menSignature.getTypes().add(typPrincipal);
        
        
        /***************************************************************************************/
        /***************************************************************************************/
        //**************************** PERSIST *********************************
        
// -------------------------------- Thierry ------------------------------------
        em.persist(itARaNappageChocolat);
        em.persist(itARaNappageCaramel);
        em.persist(itARaNappageAbricot);
        // ********* Les Produits *********
        em.persist(pain);
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
        
        

// ----------------------------------- Edem ------------------------------------
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
        em.persist(itaeJambon);

        // ********* La TVA *********
        em.persist(tvaNormal);
        //em.persist(tvaSurPlace);

        // ********* Les Produits *********
        em.persist(proTheRouge);
        em.persist(proTheVertGrand);
        em.persist(proTheVert);
        em.persist(proTheGrey);
        em.persist(proTheGreyGrand);
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
        //******************
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
        //******************
        em.persist(proBioABoire);
        em.persist(proPetitDuoRaisins);
        em.persist(proCornetNappageChocolat);
        em.persist(proDonnutNature);
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
        em.persist(proMcFlurrySpeculoos);
        em.persist(proBerlingoFruitPommePeche);
        em.persist(proVeryParfaitCoulisAbricot);
        em.persist(proVeryParfaitNature);
        em.persist(proVeryParfaitNappageSaveurChocolat);
        em.persist(proVeryParfaitNappageSaveurCaramel);
        em.persist(proFrappeSaveurChocolat);
        em.persist(proFrappeSaveurMarshmallow);
        em.persist(proFrappeSaveurVanille);
        em.persist(proFrappeSaveurMyrtille);
        //******************
        em.persist(proLivre);
        em.persist(proJouetGarcon);
        em.persist(proJouetFille);

// ---------------------------------Nourdine------------------------------------
        em.persist(typPrincipal);
        em.persist(typAccompagnement);
        em.persist(typBoisson);
        em.persist(typDessert);
        em.persist(typSauce);
        em.persist(typCadeauEnfant);

        //******************
        em.persist(aboNourdine);
        em.persist(aboThierry);
        em.persist(aboEdem);
        em.persist(aboAlex);
        em.persist(aboMomo);
        //******************
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
        //******************
        em.persist(pain);

// ----------------------------------- Momo ------------------------------------
// ----------------------------------- Alexandre Persist-------------------------------
        // Menu
        em.persist(menBigMac);
        em.persist(menBigMacMaxi);
        em.persist(menChickMacNug);
        em.persist(menHappyMeal);
        em.persist(menPtitDej);
        em.persist(menSalade);
        em.persist(menSignature);

        //sousTypes
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
        
        // ******************** ASSOCIATION DES DONNEES ************************
// ----------------------------------- Edem ------------------------------------
        // ********* TVA vers Produits *********
        TypedQuery<Produit> querryProduit = em.createNamedQuery("entities.Produit.selectAll", Produit.class);
        List<Produit> listProduit = querryProduit.getResultList();
        System.out.println("Size listProduit >>>>> " + listProduit.size());
        for (Produit p : listProduit) {
            p.setTva(tvaNormal);
            //System.out.println("Taille collection tvaProduits >>>>>>>> "+ tvaNormal.getProduits().size());
        }

        // ********* TVA vers Menu *********
        TypedQuery<Menu> querryMenu = em.createNamedQuery("entities.Menu.selectAll", Menu.class);
        List<Menu> listMenu = querryMenu.getResultList();
        System.out.println("Size listMenu >>>>> " + listMenu.size());
        for (Menu m : listMenu) {
            m.setTva(tvaNormal);
            //System.out.println("Taille collection tvaMenus >>>>>>>> "+ tvaNormal.getMenus.size());
        }
    }
    
}
