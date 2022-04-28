package model.zelezna_ruda;
/**
 * Vyrába sa zo železa, slúži ako koncový produkt
 */
public class Roxor extends Zelezo{
    public Roxor(){
        /**
         * Stredná pevnosť
         */
        this.pevnost = 6;
        /**
         * Vysoká tvrdosť
         */
        this.tvrdost = 8;
        /**
         * Nízka váha
         */
        this.vaha = 4;
        /**
         * Vysoká veľkosť
         */
        this.velkost = 7;
    }
}
