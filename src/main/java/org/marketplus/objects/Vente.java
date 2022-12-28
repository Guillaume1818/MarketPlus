package org.marketplus.objects;

public class Vente {

    private Article a;
    private int qqt;

    public Vente(Article a, int qqt) {
        this.a = a;
        this.qqt = qqt;
    }

    public Article getArticle() {
        return a;
    }

    public int getQuantité() {
        return qqt;
    }

    public double getPrice() {
        return qqt*a.getPrice();
    }

}
