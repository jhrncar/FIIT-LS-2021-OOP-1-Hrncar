package model.pristroj;
import java.util.Random;

import model.zelezna_ruda.Srob;
//sroby
import model.zelezna_ruda.Zelezo;

/**
 * Rezačka sa používa na vytváranie šróbov zo železa
 */
public class Rezacka implements Stroj {
    /**
     * Stav zapnutá - true, vypnutá - false
     */
    public boolean power;
    /**
     * Železo, ktoré bude spracovávať lis
     */
    protected Zelezo surovina;
    protected Random random = new Random();

    /**
     * Prvotné nastavenia
     */
    public Rezacka(){
        this.power = false;
        this.surovina = null;
    }

    /**
     * Rezačka sa musí zapnúť aby mohla pracovať, čo trvá čas
     */
    @Override
    public void zapni() {
        this.power = true;
        try{
            Thread.sleep(250);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * Spracuje železo v atribúte. Pri práci je 15% šanca, že sa rezačka sama vypne
     * @return Vráti spracovaný šrób
     */
    @Override
    public Srob spracuj() {
        if (power){
            Srob s = new Srob();
            if (this.surovina != null){
                this.surovina = null;
            }
            double sanca = random.nextDouble();
            if (sanca <= 0.15){//rezacka ma malu sancu na to, aby sa sama vypla a musi sa zapnut
                this.power = false;
            }
            return s;
        }
        else{
            return null;
        }
    }

    @Override
    public void vypni() {
        this.power = false;
        
    }

    public void vloz(Zelezo z){
        this.surovina = z;
    }
    
}
