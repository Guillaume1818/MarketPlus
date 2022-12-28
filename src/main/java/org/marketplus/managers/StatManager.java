package org.marketplus.managers;

import org.marketplus.objects.Article;
import org.marketplus.objects.Employe;
import org.marketplus.objects.Stats;
import org.marketplus.objects.Vente;
import org.marketplus.rayons.Rayon;

import java.util.HashMap;

public class StatManager {

    private HashMap<Employe, Stats> statistiques = new HashMap<Employe, Stats>();

    public Stats getEmployeStats(Employe e) {
        return statistiques.get(e);
    }

    public void addVente(Vente v, int idEmploye) throws NullPointerException {
        Article a = v.getArticle();
        Employe e = EmployeManager.getEmployeById(idEmploye);
        if(e != null) {
            if (statistiques.containsKey(e)) {
                statistiques.get(e).addVente(v);
            }
        } else {
            throw new NullPointerException("Cet employé n'existe pas !");
        }
    }

}
