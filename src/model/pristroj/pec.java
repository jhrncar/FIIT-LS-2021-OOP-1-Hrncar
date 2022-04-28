package model.pristroj;
import model.zelezna_ruda.Zelezna_ruda;
import model.zelezna_ruda.Zelezo;
import java.lang.Math;

/**
 * Pec sa pouzíva na spracovanie železnej rudy na železo
 */
public class Pec implements Stroj {
    /**
     * Pec má svoje teplo, ktoré je nutné jej udržovať
     */
    protected int teplo;
    /**
     * Železo, ktoré sa bude spracovávať
     */
    protected Zelezna_ruda ruda;

    /**
     * Prvotné nastavenia pece
     */
    public Pec(){
        this.teplo = 0;
        this.ruda = null;
    }

    /**
     * Pec sa po zapnutí musí zohriať
     */
    @Override
    public void zapni(){
        while (teplo < 100){
            this.zohrej();
        }
    }

    /**
     * Zohrievanie pece vyžaduje čas
     */
    public void zohrej(){
        this.teplo += 20;
        try{
            Thread.sleep(50);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void vloz_rudu(Zelezna_ruda vklad_ruda){
        this.ruda = vklad_ruda;
    }

    /**
     * Spracovávanie železnej rudy na železo, pec postupne chladne, čím je chladnejŠia, tým jej to exponencíalne dlhšie trvá
     * @return Vrátí vytvorený objekt železo
     */
    @Override
    public Zelezo spracuj(){
        this.teplo -= 5;
        //cim bude chladnejsia, tym pomalsie to bude trvat 
        Cas cas = (int a) ->  (int)(Math.pow(2, ((100 - a)/12))) * 2; //lambda
        if (this.teplo < 80){
            try{
                Thread.sleep(cas.cas(this.teplo)); 
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        
        Zelezo z = new Zelezo();
        if (this.ruda != null){
            this.ruda = null;
        }
        return z;
    }

    @Override
    public void vypni(){
        this.teplo = 0;
        this.ruda = null;
    }

    public int getTeplo(){
        return this.teplo;
    }

}
