package org.marketplus.rayons;

import org.marketplus.objects.Employe;

public class PGC extends Rayon {

    private boolean dlc;

    public PGC(int id, String position, String name, boolean dlc) {
        super(id, position, name);
        this.dlc = dlc;
    }

    public boolean isDlc() {
        return dlc;
    }
}
