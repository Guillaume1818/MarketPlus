package org.marketplus.managers;

import org.marketplus.objects.Article;
import org.marketplus.rayons.Rayon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager {

    private RayonManager rayonManager;

    public MenuManager(RayonManager rayonManager) {
        this.rayonManager = rayonManager;
    }

    public void mainMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue sur MarketPlus\n");
        System.out.println("0: Consultation tous les articles");
        System.out.println("1: Consultation article");
        System.out.println("2: Consultation article par rayons");
        System.out.println("3: Ajout article");

        int input = sc.nextInt();
        if(input == 0) {
            allArticlesMenu();
        } else if(input == 1) {
            consultArticleMenu();
        } else if(input == 2) {
            consultArticleRayonMenu();
        } else if(input == 3) {
            ajoutArticleMenu();
        }
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
        System.out.println("Consultation d'article");
        System.out.println("Entrée:");
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        for(Rayon r : rayonManager.getAllRayons()) {
            for(Article a : r.getArticles()) {
                if(a.getName().equals(txt) || String.valueOf(a.getEan()).equals(txt)) {
                    displayArticle(a);
                }
            }
        }
        mainMenu();
    }

    public void consultArticleRayonMenu() {
        System.out.println("Consultation article par rayon");
        System.out.println("Rayon: ");
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        Rayon r = null;
        for(Rayon rlist : rayonManager.getAllRayons()) {
            if(rlist.getName().equalsIgnoreCase(txt)) {
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

    public void displayArticle(Article a) {
        System.out.println(a.getId() + " - " + a.getName() + " - " + a.getPrice() + " - " + a.getStock() + " - " + a.getEan());
    }

}
