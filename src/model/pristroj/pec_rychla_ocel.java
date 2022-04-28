package model.pristroj;

import model.zelezna_ruda.Ocel;

/**
 * Rýchla pec na oceľ sa póužíva na rýchle vytváranie veľa kúskov ocele
 */
public class Pec_rychla_ocel extends Pec_ocel {
    /**
     * Prvotné nastavenia
     */
    public Pec_rychla_ocel(){
        this.uhlik = 100;
        this.z = null;
    }

    /**
     * Spracovávanie železa na oceľ.
     * @return Vrátí vytvorený objekt ocel
     */
    @Override
    public Ocel spracuj(){
        this.teplo -= 3;
        this.uhlik -= 1;
        
        Ocel o = new Ocel();
        if (this.z != null){
            this.z = null;
        }
        return o;
    }
}
