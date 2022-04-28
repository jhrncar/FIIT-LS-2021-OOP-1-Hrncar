package model.zelezna_ruda;
/**
 * Vyrába sa z ocele, slúži ako koncový produkt
 */
public class Ocelova_tyc extends Ocel{
    public Ocelova_tyc(){
        /**
         * Vysoká pevnosť
         */
        this.pevnost = 7;
        /**
         * Vysoká tvrdosť
         */
        this.tvrdost = 10;
        /**
         * Nízka váha
         */
        this.vaha = 4;
        /**
         * Stredná veľkosť
         */
        this.velkost = 5;
    }
}
