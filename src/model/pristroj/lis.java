package model.pristroj;

import model.zelezna_ruda.Ocel;
import model.zelezna_ruda.Ocelova_tyc;
import model.zelezna_ruda.Roxor;
import model.zelezna_ruda.Zelezo;

/**
 * Lis sa používa na spracovanie železa a ocele na tyče a roxory
 */
public class Lis extends Rezacka{
    /**
     * Železo, ktoré bude spracovávať lis
     */
    protected Zelezo surovina1;
    /**
     * Oceľ, ktorú bude spracovávať lis
     */
    protected Ocel surovina2;

    /**
     * Prvotné nastavenie lisu
     */
    public Lis(){
        this.power = false;
        this.surovina1 = null;
        this.surovina2 = null;
    }
    @Override
    public void vloz(Zelezo z){
        this.surovina1 = z;
    }
    //Overload?
    public void vloz(Ocel o){
        this.surovina2 = o;
    }

    /**
     * Funckia na spracovanie momentálne uloženého železa v atribúte. Lis má 15% šancu, že sa po vytvorení železa sám vypne
     * @return Vráti vytvorený objekt roxor
     */
    public Roxor spracuj_zelezo(){
        if (power){
            Roxor r = new Roxor();
            if (this.surovina1 != null){
                this.surovina1 = null;
            }
            double sanca = random.nextDouble();
            if (sanca <= 0.15){//lis ma malu sancu na to, aby sa sam vypol a musi sa zapnut
                this.power = false;
            }
            return r;
        }
        else{
            return null;
        }
    }

    /**
     * Funckia na spracovanie momentálne uloženej ocele v atribúte. Lis má 15% šancu, že sa po vytvorení ocele sám vypne
     * @return Vráti vytvorený objekt ocelova_tyc
     */
    public Ocelova_tyc spracuj_ocel(){
        if (power){
            Ocelova_tyc o = new Ocelova_tyc();
            if (this.surovina != null){
                this.surovina = null;
            }
            double sanca = random.nextDouble();
            if (sanca <= 0.15){//lis ma malu sancu na to, aby sa sam vypol a musi sa zapnut
                this.power = false;
            }
            return o;
        }
        else{
            return null;
        }
    }
}
