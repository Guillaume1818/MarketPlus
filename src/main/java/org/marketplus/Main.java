package org.marketplus;

import org.marketplus.managers.MenuManager;
import org.marketplus.managers.RayonManager;
import org.marketplus.managers.StatManager;
import org.marketplus.rayons.Brico;
import org.marketplus.rayons.Multimedia;
import org.marketplus.rayons.PGC;
import org.marketplus.rayons.Rayon;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //LOADS
        RayonManager rayonManager = new RayonManager();
        StatManager statManager = new StatManager();
        MenuManager menuManager = new MenuManager(rayonManager, statManager);

        rayonManager.load();

        //MENUS
        menuManager.mainMenu();
    }

}
