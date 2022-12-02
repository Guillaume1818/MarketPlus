package org.marketplus.rayons;

public class Multimedia extends Rayon {

    private int size;

    public Multimedia(int id, String position, String name, int size) {
        super(id, position, name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
