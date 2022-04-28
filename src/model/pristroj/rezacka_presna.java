package model.pristroj;

import model.zelezna_ruda.Srob;

/**
 * Presná rezačka sa používa na spracovanie veľkého množstva železa
 */
public class Rezacka_presna extends Rezacka{
    /**
     * Prvotné nastavenia
     */
    public Rezacka_presna(){
        this.power = false;
        this.surovina = null;
    }

    /**
     * Spracuje železo v atribúte. Presná rezačka sa nevypína sama od seba
     * @return Vráti spracovaný šrób
     */
    @Override
    public Srob spracuj() {
        if (power){
            Srob s = new Srob();
            if (this.surovina != null){
                this.surovina = null;
            }
            return s;
        }
        else{
            return null;
        }
    }

}
