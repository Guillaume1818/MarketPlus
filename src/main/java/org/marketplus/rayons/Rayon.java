package org.marketplus.rayons;

import org.marketplus.objects.Article;
import org.marketplus.objects.Employe;
import org.marketplus.objects.Stats;

import java.util.ArrayList;
import java.util.List;

public class Rayon {

    private int id;
    private String position;
    private String name;
    private Stats stats;
    private Employe responsable;
    private List<Employe> employes;
    private List<Article> articles;

    public Rayon(int id, String position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.articles = new ArrayList<Article>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article a) {
        articles.add(a);
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void removeArticle(Article a) {
        if(articles.contains(a)) {
            articles.remove(a);
        }
    }

}
