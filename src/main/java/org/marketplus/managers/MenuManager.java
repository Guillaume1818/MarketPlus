package org.marketplus.managers;

import org.marketplus.objects.Article;
import org.marketplus.objects.Employe;
import org.marketplus.objects.Vente;
import org.marketplus.rayons.Rayon;
import org.marketplus.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager {

    private RayonManager rayonManager;
    private StatManager statManager;

    public MenuManager(RayonManager rayonManager, StatManager statManager) {
        this.rayonManager = rayonManager;
        this.statManager = statManager;
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int input = InputUtils.intInput("Bienvenue sur MarketPlus !",
                "0: Consulter tous les articles",
                "1: Consulter un article",
                "2: Consulter les articles d'un rayon",
                "3: Ajouter un article",
                "4: Supprimer un article",
                "5: Vente d'article");
        displayMenuByInput(input);
    }

    public void allArticlesMenu() {
        System.out.println("Liste de tous les articles:\n");
        for(Rayon r : rayonManager.getAllRayons()) {
            for(Article a : r.getArticles()) {
                displayArticle(a);
            }
        }
        mainMenu();
    }

    public void consultArticleMenu() {
        String in = InputUtils.strInput("Consultation article", "Nom article:");
        for(Rayon r : rayonManager.getAllRayons()) {
            for(Article a : r.getArticles()) {
                if(a.getName().equals(in) || String.valueOf(a.getEan()).equals(in)) {
                    displayArticle(a);
                }
            }
        }
        mainMenu();
    }

    public void consultArticleRayonMenu() {
        String rayon = InputUtils.strInput("Consultation Article par rayon", "Rayon:");
        Rayon r = null;
        for(Rayon rlist : rayonManager.getAllRayons()) {
            if(rlist.getName().equalsIgnoreCase(rayon)) {
                r = rlist;
            }
        }
        if(r != null) {
            for(Article a : r.getArticles()) {
                displayArticle(a);
            }
        }
        mainMenu();
    }

    public void ajoutArticleMenu() {
        System.out.println("Ajout article");
        List<String> inList = new ArrayList<String>();
        System.out.println("ID: ");
        System.out.println("Nom: ");
        System.out.println("Prix: ");
        System.out.println("Stock: ");
        System.out.println("EAN: ");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<5; i++) {
            inList.add(sc.nextLine());
        }
        Article a = new Article(Integer.parseInt(inList.get(0)),
                inList.get(1),
                Double.parseDouble(inList.get(2)),
                Integer.parseInt(inList.get(3)),
                Integer.parseInt(inList.get(4)));
        System.out.println("Rayon:");
        String txt = sc.nextLine();
        Rayon r = rayonManager.getRayonByName(txt);
        if(r != null) {
            r.addArticle(a);
        }
        System.out.println("Article ajouté !");
        mainMenu();
    }

    public void supprimerArticleMenu() {
        int ean = InputUtils.intInput("Suppression Article", "EAN: ");
        Article a = rayonManager.getArticleByEAN(ean);
        if(a == null) {
            System.out.println("Article inconnu");
        } else {
            rayonManager.supprimerArticle(a);
            System.out.println("L'article a bien été supprimé");
        }
        mainMenu();
    }

    public void venteArtiche() {
        int ean = InputUtils.intInput("Vente article", "EAN:");
        int nbr = InputUtils.intInput("Nombre");
        int idEmploye = InputUtils.intInput("Identifiant employé:");
        Article a = rayonManager.getArticleByEAN(ean);
        if(a == null) {
            System.out.println("Article inconnu");
        } else {
            Vente vente = a.vente(nbr);
            if(vente != null) {
                System.out.println("L'article a bien été vendu en " + nbr + " quantité");
                statManager.addVente(vente, idEmploye);
            } else {
                System.out.println("Une erreur est survenue dans la vente de l'article");
            }
        }
        mainMenu();
    }


    //UTILS
    public void displayArticle(Article a) {
        System.out.println(a.getId() + " - " + a.getName() + " - " + a.getPrice() + " - " + a.getStock() + " - " + a.getEan());
    }

    public void displayMenuByInput(int input) {
        if(input == 0) {
            allArticlesMenu();
        } else if(input == 1) {
            consultArticleMenu();
        } else if(input == 2) {
            consultArticleRayonMenu();
        } else if(input == 3) {
            ajoutArticleMenu();
        } else if(input == 4) {
            supprimerArticleMenu();
        } else if(input == 5) {
            venteArtiche();
        }
    }

}
