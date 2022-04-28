package model.zelezna_ruda;

/**
 * Vyrába sa zo železa, slúži ako koncový produkt
 */
public class Srob extends Zelezo {
    public Srob(){
        /**
         * Stredná pevnosť
         */
        this.pevnost = 5;
        /**
         * Vysoká tvrdosť
         */
        this.tvrdost = 8;
        /**
         * Nízka váha
         */
        this.vaha = 1;
        /**
         * Nízka veľkosť
         */
        this.velkost = 1;
    }
}
