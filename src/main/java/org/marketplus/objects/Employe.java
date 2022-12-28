package org.marketplus.objects;

import org.marketplus.enums.Rank;

public class Employe {

    int id;
    private String name;
    private String dateArrivée;
    private Rank rang;

    public Employe(int id, String name, String dateArrivée, Rank rang) {
        this.id = id;
        this.name = name;
        this.dateArrivée = dateArrivée;
        this.rang = rang;
    }

    public int getId() {
        return id;
    }
}
