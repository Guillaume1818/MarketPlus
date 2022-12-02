package org.marketplus.managers;

import org.marketplus.objects.Article;
import org.marketplus.rayons.Brico;
import org.marketplus.rayons.Multimedia;
import org.marketplus.rayons.PGC;
import org.marketplus.rayons.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonManager {

    public static List<Rayon> allRayons;
    public static List<PGC> allPgc;
    public static List<Brico> allBrico;
    public static List<Multimedia> allMultimedia;

    public void load() {
        loadRayons();
        loadArticles();
    }

    public void loadArticles() {
        Article coca = new Article(0, "Coca", 2.0, 20, 01011);
        Article biscotte = new Article(1, "Biscotte", 1.5, 15, 9310);
        Article ampoule = new Article(2, "Ampoule", 3.5, 10, 8975);
        Article tele = new Article(3, "Téléviseur", 100, 4, 87869);
        allPgc.get(0).addArticle(coca);
        allPgc.get(1).addArticle(biscotte);
        allBrico.get(0).addArticle(ampoule);
        allMultimedia.get(0).addArticle(tele);
    }

    public void loadRayons() {
        //PGC
        PGC liquide = new PGC(0, "A1", "Liquide", true);
        PGC alimentaire = new PGC(1, "A2", "Alimentaire", true);
        PGC dph = new PGC(2, "A3", "D.P.H", false);
        //BRICO
        Brico jardin = new Brico(3, "B1", "Jardin", true);
        Brico maison = new Brico(4, "B2", "Maison", false);
        Brico auto = new Brico(5, "B3", "Automobile", false);
        //MULTIMEDIA
        Multimedia telephonie = new Multimedia(6, "C1", "Téléphonie", 1);
        Multimedia electromenager = new Multimedia(7, "C2", "Électroménager", 3);
        Multimedia numerique = new Multimedia(8, "C3", "Numérique", 5);

        //DECLARATIONS RAYONS PGC
        allPgc = new ArrayList<PGC>();
        allPgc.add(liquide);
        allPgc.add(alimentaire);
        allPgc.add(dph);

        //DECLARATIONS RAYONS BRICO
        allBrico = new ArrayList<Brico>();
        allBrico.add(jardin);
        allBrico.add(maison);
        allBrico.add(auto);

        //DECLARATIONS RAYONS MULTIMÉDIA
        allMultimedia = new ArrayList<Multimedia>();
        allMultimedia.add(telephonie);
        allMultimedia.add(electromenager);
        allMultimedia.add(numerique);


        //DECLARATIONS TOUS RAYONS
        allRayons = new ArrayList<Rayon>();
        for(PGC r : allPgc) {
            allRayons.add(r);
        }
        for(Brico b : allBrico) {
            allRayons.add(b);
        }
        for(Multimedia m : allMultimedia) {
            allRayons.add(m);
        }
    }

    public List<Rayon> getAllRayons() {
        return allRayons;
    }

    public void addArticle(Rayon r, Article a) {
        r.addArticle(a);
    }

    public Rayon getRayonByName(String name) {
        for(Rayon r : allRayons) {
            if(r.getName().equalsIgnoreCase(name)) {
                return r;
            }
        }
        return null;
    }

}
