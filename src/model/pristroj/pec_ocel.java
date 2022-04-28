package model.pristroj;

import model.zelezna_ruda.Ocel;
import model.zelezna_ruda.Zelezo;

/**
 * Oceľová pec vytvára oceľ zo železa
 */
public class Pec_ocel extends Pec {
    /**
     * Železo, ktoré sa bude spracovávať
     */
    protected Zelezo z;
    /**
     * Na vytvorenie ocele je potrebný aj uhlík
     */
    protected int uhlik;

    /**
     * Prvotné nastavenia
     */
    public Pec_ocel(){
        this.uhlik = 20;
        this.z = null;
    }

    public void vloz_rudu(Zelezo z){
        this.z = z;
    }
    /**
     * Spracovávanie železa na oceľ, pec postupne chladne, čím je chladnejŠia, tým jej to exponencíalne dlhšie trvá
     * @return Vrátí vytvorený objekt ocel
     */
    @Override
    public Ocel spracuj(){
        this.teplo -= 3;
        this.uhlik -= 1;
        //cim bude chladnejsia, tym pomalsie to bude trvat
        Cas cas = (int a) ->  (int)(Math.pow(2, ((100 - a)/12))) * 2; //lambda
        if (this.teplo < 60){
            try{
                Thread.sleep(cas.cas(this.teplo)); 
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        Ocel o = new Ocel();
        if (this.z != null){
            this.z = null;
        }
        return o;
    }

    /**
     * Okrem tepla sa musí udržiavať aj hladina uhlíka
     */
    public void dopln_uhlik(){
        this.uhlik = 20;
        try{
            Thread.sleep(200); 
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public int getUhlik(){
        return this.uhlik;
    }

}
