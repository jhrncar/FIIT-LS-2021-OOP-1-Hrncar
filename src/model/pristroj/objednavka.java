package model.pristroj;

import java.util.Random;

/**
 * Obejednávka, ktorú užívateľ zadá prostedníctvom GUI a manažéra
 */
public class Objednavka {
    public int cislo;
    public int ocel = 0;
    public int ocelova_tyc = 0;
    public int roxor = 0;
    public int srob = 0;
    public int zelezo = 0;
    Random rand = new Random();

    /**
     * Nastavenie hodnôt objednávky a jej čísla
     * @param zelezo Od úžívateľa, default je 0
     * @param ocel Od úžívateľa, default je 0
     * @param srob Od úžívateľa, default je 0
     * @param ocelova_tyc Od úžívateľa, default je 0
     * @param roxor Od úžívateľa, default je 0
     */
    public Objednavka(int zelezo, int ocel,int srob , int ocelova_tyc, int roxor) {
        this.ocel = ocel;
        this.ocelova_tyc = ocelova_tyc;
        this.roxor = roxor;
        this.srob = srob;
        this.zelezo = zelezo;
        this.cislo = rand.nextInt(1000);
    }
}
