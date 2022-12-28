package org.marketplus.objects;

import java.util.List;

public class Stats {

    private int id;
    private List<Vente> ventes;

    public void addVente(Vente v) {
        ventes.add(v);
    }

}
