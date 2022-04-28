package model.zelezna_ruda;
/**
 * Vyrába sa zo železa, slúži ako surovina aj ako koncový produkt
 */
public class Ocel extends Zelezo {
    public Ocel(){
        /**
         * Vysoká pevnosť
         */
        this.pevnost = 8;
        /**
         * Vysoká tvrdosť
         */
        this.tvrdost = 10;
        /**
         * Stredná váha
         */
        this.vaha = 7;
        /**
         * Vysoká veľkosť
         */
        this.velkost = 10;
    }
}
