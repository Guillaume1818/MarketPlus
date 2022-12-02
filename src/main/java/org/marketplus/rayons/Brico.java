package org.marketplus.rayons;

public class Brico extends Rayon {

    private boolean weak;

    public Brico(int id, String position, String name, boolean weak) {
        super(id, position, name);
        this.weak = weak;
    }

    public boolean isWeak() {
        return weak;
    }
}
