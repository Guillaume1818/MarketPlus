package org.marketplus.enums;

public enum Rank {

    RESPONSABLE("Déini les rôles de chacuns au sein de la gestion du rayon"),
    ADJOINT("Assiste le responsable dans ses tâches"),
    PERMANENT("Employé commercial attitré a un rayon");

    private String description;

    Rank(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
