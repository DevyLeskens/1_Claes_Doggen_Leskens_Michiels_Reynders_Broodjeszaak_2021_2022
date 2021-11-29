package model.database;

import java.util.ArrayList;

public class Toppingdatabase {
//    De soorten beleg (naam beleg, prijs, aantal beschikbare porties en aantal verkochte porties) zitten ofwel in een tekstbestand ofwel in een Excel bestand (bepaald in de settings tab van de admin view).
//    Deze soorten broodjes en beleg worden bij het opstarten van de app ingelezen in een in memory database (een map met broodjes soorten en een map met beleg soorten) die gedurende gans de sessie wordt gebruikt.
//    Bij het afsluiten van de app worden de voorraden en omzetstatistieken van de broodjes en beleg soorten in het tekst of Excel bestand bijgewerkt.
//    Soorten broodjes en beleg toevoegen/ verwijderen, voorraad aanpassingen, … gebeuren niet via de app maar rechtstreeks in het tekst/excel bestand.

    private String name;
    private double price;
    private int sold, stock;
    //private ArrayList;

}
