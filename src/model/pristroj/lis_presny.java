package model.pristroj;

import model.zelezna_ruda.Ocelova_tyc;
import model.zelezna_ruda.Roxor;
/**
 * Presný lis sa používa na rýchle spracovanie železa a ocele na tyče a roxory
 */
public class Lis_presny extends Lis{
    /**
     * Prvotné nastavenie lisu
     */
    public Lis_presny(){
        this.power = false;
        this.surovina1 = null;
        this.surovina2 = null;
    }

    /**
     * Funckia na spracovanie momentálne uloženého železa v atribúte. Presný lis sa nevypína sám od seba
     * @return Vráti vytvorený objekt roxor
     */
    public Roxor spracuj_zelezo(){
        if (power){
            Roxor r = new Roxor();
            if (this.surovina1 != null){
                this.surovina1 = null;
            }
            return r;
        }
        else{
            return null;
        }
    }
    /**
     * Funckia na spracovanie momentálne uloženej ocele v atribúte. Presný lis sa nevypína sám od seba
     * @return Vráti vytvorený objekt ocelova_tyc
     */
    public Ocelova_tyc spracuj_ocel(){
        if (power){
            Ocelova_tyc o = new Ocelova_tyc();
            if (this.surovina != null){
                this.surovina = null;
            }
            return o;
        }
        else{
            return null;
        }
    }
}
