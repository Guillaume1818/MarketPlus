package org.marketplus.objects;

public class Article {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int ean;

    public Article(int id, String name, double price, int stock, int ean) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.ean = ean;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getEan() {
        return ean;
    }

}
