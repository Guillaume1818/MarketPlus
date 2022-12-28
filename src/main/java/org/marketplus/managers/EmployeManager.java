package org.marketplus.managers;

import org.marketplus.objects.Employe;
import org.marketplus.rayons.Rayon;

import java.util.ArrayList;
import java.util.List;

public class EmployeManager {

    private static List<Employe> allEmployes = new ArrayList<Employe>();

    public static Employe getEmployeById(int id) {
        for(Employe e : allEmployes) {
            if(e.getId() == id) {
                return e;
            }
        }
        return null;
    }

}
