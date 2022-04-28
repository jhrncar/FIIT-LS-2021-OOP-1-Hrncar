package model.pristroj;

import model.zelezna_ruda.Zelezo;
/**
 * Rýchla pec na železo sa póužíva na rýchle vytváranie veľa kúskov železa
 */
public class Pec_rychla_zelezo extends Pec {
    /**
     * Prvotné nastavenia
     */
    public Pec_rychla_zelezo(){
        this.teplo = 0;
        this.ruda = null;
    }
    /**
     * Spracovávanie železnej rudy na železo. Nie je obmedzená časovo
     * @return Vrátí vytvorený objekt železo
     */
    @Override
    public Zelezo spracuj(){
        this.teplo -= 5;

        Zelezo z = new Zelezo();
        if (this.ruda != null){
            this.ruda = null;
        }
        return z;
    }

    /**
     * Zohrievanie nie je obmedzené časovo
     */
    @Override
    public void zohrej(){
        this.teplo = 100;
        }
}

