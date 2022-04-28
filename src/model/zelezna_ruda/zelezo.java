package model.zelezna_ruda;

/**
 * Základn
 */
public class Zelezo extends Zelezna_ruda implements java.io.Serializable{
    public Zelezo(){
        /**
         * Nízka pevnosť
         */
        this.pevnost = 3;
        /**
         * Vysoká tvrdosť
         */
        this.tvrdost = 8;
        /**
         * Vysoká váha
         */
        this.vaha = 10;
        /**
         * Vysoká veľkosť
         */
        this.velkost = 10;
    }
}